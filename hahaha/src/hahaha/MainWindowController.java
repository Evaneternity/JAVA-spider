package hahaha;

import java.util.*;

import com.sun.glass.ui.MenuItem;

import ObservableList;
import hahaha.HelloDate;
import hahaha.JSQ;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class MainWindowController {
	
	private HelloDate date1=new HelloDate();
	@FXML private Label DateLbl;
	
	//��ʾ���ڰ�ť����
	public void handleDateBtnClick(){
		DateLbl.setText(date1.GetHelloDate());
		//DateLbl.setText(new Date().toString());
	}

	@FXML private Label label;
	@FXML private TextField SearchField;
	@FXML private HBox BookBox;
	
	@FXML
	public void handleFieldEnter() {
		String text=SearchField.getText();
		DateLbl.setText(text);
		SearchField.clear();
	}
	
	@FXML private ListView BookList;
	public void FillBookList(){
		ObservableList<String> strList = (ObservableList) FXCollections.observableArrayList("��ɫ","��ɫ","��ɫ");  
		 
		BookList.setItems(strList);  

	}
	
	
	
	//@FXML private MenuItem StartReaderItem;
	@FXML
	public void StartReader(){
		DateLbl.setText("�����Ķ���");
		JSQ reader=new JSQ();
		reader.main(null);
	}
	
	
	
	
	
	//ϰ���ϻὫ�����������ע�뵽�������У��Ա������
	//�ܷ��������ж���ķ���������ض��Ĺ��ܣ������л��������ݣ�
	private Main main;
	public void setMain(Main main) {
		this.main=main;

	}


}
