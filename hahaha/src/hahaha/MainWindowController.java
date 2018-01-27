package hahaha;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

import com.sun.glass.ui.MenuItem;

//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.beans.property.SimpleStringProperty;
import hahaha.HelloDate;
import hahaha.TXTReader;
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
	@FXML private Label label;
	@FXML private TextField SearchField;
	@FXML private TextField URLField;	
	@FXML private ListView BookList;
	
	
	//Nothing��ť����
	public void handleDateBtnClick(){
		DateLbl.setText(date1.GetHelloDate());
		//DateLbl.setText(new Date().toString());
	}
	//Something��ť����
	public void SomethingBtnClick(){
		SomethingLbl.setText(date1.GetHelloDate());
		FillBookList();
	}
	//��һ������������
	@FXML
	public void handleFieldEnter() throws IOException {
		String text=SearchField.getText();
		DateLbl.setText("�˴���ʱ��δ��ʾ�ɹ���ʧ��");
		SearchField.clear();
		GetArticles getart=new GetArticles();
		getart.main(text,1);
		DateLbl.setText(text+"���سɹ�");
	}
	//�ڶ�������������
	public void URLFieldEntered() throws IOException{
		String text=URLField.getText();
		DateLbl.setText("�˴���ʱ��δ��ʾ�ɹ���ʧ��");
		URLField.clear();
		GetArticles getart=new GetArticles();
		getart.main(text,2);
		DateLbl.setText(text+"���سɹ�");
	}
	//ˢ�����
	public void FillBookList(){
		ObservableList<String> strList = (ObservableList) FXCollections.observableArrayList();  
		File f = new File(System.getProperty("user.dir")+"\\book");
		File fa[] = f.listFiles();
		for (int i = 0; i < fa.length; i++) {
		             File fs = fa[i];
		             if (fs.isDirectory()) {

		             } else {
		            	 strList.add(fs.getName());
		                 //System.out.println(fs.getName());
		    }
		}
		
		BookList.setItems(strList);  

	}
	//���Ȿ�鰴ť����
	public void ReaderBtnClick(){
		String s=new String();
		s=BookList.getFocusModel().getFocusedItem().toString();
		TXTReader reader=new TXTReader();
		reader.main(System.getProperty("user.dir")+"\\book\\"+s);
		
	}
	//�˵��� �����Ķ���
	@FXML
	public void StartReader(){
		DateLbl.setText("�����Ķ���");
		TXTReader reader=new TXTReader();
		reader.main(null);
	}
	//�˵��� About
	public void About(){
		DateLbl.setText("����ܿ�����ʲô");
		JOptionPane.showMessageDialog(null, "�����Ϊ��Դ���\n������ߣ�WL", "MessageDialog",JOptionPane.INFORMATION_MESSAGE);
	}
	//�˵��� Help
	public void Help(){
		DateLbl.setText("����е����");
		TXTReader reader=new TXTReader();
		reader.main(System.getProperty("user.dir")+"\\book\\�����ĵ�.txt");
	}
	
	
	
	//ϰ���ϻὫ�����������ע�뵽�������У��Ա������
	//�ܷ��������ж���ķ���������ض��Ĺ��ܣ������л��������ݣ�
	private Main main;
	public void setMain(Main main) {
		this.main=main;

	}


}
