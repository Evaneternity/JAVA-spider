package hahaha;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

import com.sun.glass.ui.MenuItem;

//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.beans.property.SimpleStringProperty;
import hahaha.HelloDate;
import hahaha.JSQ;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import spiderUtil.*;

public class MainWindowController {
	
	private HelloDate date1=new HelloDate();
	@FXML private Label DateLbl;
	@FXML private Label SomethingLbl;
	
	//��ʾ���ڰ�ť����
	public void handleDateBtnClick(){
		DateLbl.setText(date1.GetHelloDate());
		//DateLbl.setText(new Date().toString());
	}
	public void SomethingBtnClick(){
		SomethingLbl.setText(date1.GetHelloDate());
		FillBookList();
	}
	
	

	@FXML private Label label;
	@FXML private TextField SearchField;
	@FXML private HBox BookBox;
	@FXML private TextField URLField;
	@FXML
	public void handleFieldEnter() throws IOException {
		String text=SearchField.getText();
		DateLbl.setText("�˴���ʱ��δ��ʾ�ɹ���ʧ��");
		SearchField.clear();
		GetArticles getart=new GetArticles();
		getart.main(text,1);
		DateLbl.setText(text+"���سɹ�");
	}
	public void URLFieldEntered() throws IOException{
		String text=URLField.getText();
		DateLbl.setText(text+"�˴���ʱ��δ��ʾ�ɹ���ʧ��");
		SearchField.clear();
		GetArticles getart=new GetArticles();
		getart.main(text,2);
		DateLbl.setText(text+"���سɹ�");
	}
	@FXML private ListView BookList;
	public void FillBookList(){
		
		//ObservableList<String> strList = (ObservableList) FXCollections.observableArrayList("��ɫ","��ɫ","��ɫ");  
		ObservableList<String> strList = (ObservableList) FXCollections.observableArrayList();  
		//������д "" �����һ������Ŀ��дnullҲ����
		File f = new File(System.getProperty("user.dir")+"\\book");
		File fa[] = f.listFiles();
		for (int i = 0; i < fa.length; i++) {
		             File fs = fa[i];
		             if (fs.isDirectory()) {
		                 //System.out.println(fs.getName() + " [Ŀ¼]");
		             } else {
		            	 strList.add(fs.getName());
		                 //System.out.println(fs.getName());
		    }
		}
		

		BookList.setItems(strList);  

	}
	public void ReaderBtnClick(){
		String s=new String();
		s=BookList.getFocusModel().getFocusedItem().toString();
		JSQ reader=new JSQ();
		reader.main(System.getProperty("user.dir")+"\\book\\"+s);
		
	}

	
	//@FXML private MenuItem StartReaderItem;
	@FXML
	public void StartReader(){
		DateLbl.setText("�����Ķ���");
		JSQ reader=new JSQ();
		reader.main(null);
	}
	public void About(){
		DateLbl.setText("����ܿ�����ʲô");
		JOptionPane.showMessageDialog(null, "�����Ϊ��Դ���\n������ߣ�WL", "MessageDialog",JOptionPane.INFORMATION_MESSAGE);
	}
	public void Help(){
		DateLbl.setText("����е����");
		JSQ reader=new JSQ();
		reader.main(System.getProperty("user.dir")+"\\book\\�����ĵ�.txt");
	}
	
	
	
	//ϰ���ϻὫ�����������ע�뵽�������У��Ա������
	//�ܷ��������ж���ķ���������ض��Ĺ��ܣ������л��������ݣ�
	private Main main;
	public void setMain(Main main) {
		this.main=main;

	}


}
