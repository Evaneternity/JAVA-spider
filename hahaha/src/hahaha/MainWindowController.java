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
	
	
	//Nothing按钮按下
	public void handleDateBtnClick(){
		DateLbl.setText(date1.GetHelloDate());
		//DateLbl.setText(new Date().toString());
	}
	//Something按钮按下
	public void SomethingBtnClick(){
		SomethingLbl.setText(date1.GetHelloDate());
		FillBookList();
	}
	//第一个搜索框输入
	@FXML
	public void handleFieldEnter() throws IOException {
		String text=SearchField.getText();
		DateLbl.setText("此处长时间未提示成功则失败");
		SearchField.clear();
		GetArticles getart=new GetArticles();
		getart.main(text,1);
		DateLbl.setText(text+"下载成功");
	}
	//第二个搜索框输入
	public void URLFieldEntered() throws IOException{
		String text=URLField.getText();
		DateLbl.setText("此处长时间未提示成功则失败");
		URLField.clear();
		GetArticles getart=new GetArticles();
		getart.main(text,2);
		DateLbl.setText(text+"下载成功");
	}
	//刷新书架
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
	//读这本书按钮按下
	public void ReaderBtnClick(){
		String s=new String();
		s=BookList.getFocusModel().getFocusedItem().toString();
		TXTReader reader=new TXTReader();
		reader.main(System.getProperty("user.dir")+"\\book\\"+s);
		
	}
	//菜单项 启动阅读器
	@FXML
	public void StartReader(){
		DateLbl.setText("启动阅读器");
		TXTReader reader=new TXTReader();
		reader.main(null);
	}
	//菜单项 About
	public void About(){
		DateLbl.setText("大概能看出点什么");
		JOptionPane.showMessageDialog(null, "本软件为开源软件\n软件作者：WL", "MessageDialog",JOptionPane.INFORMATION_MESSAGE);
	}
	//菜单项 Help
	public void Help(){
		DateLbl.setText("大概有点帮助");
		TXTReader reader=new TXTReader();
		reader.main(System.getProperty("user.dir")+"\\book\\帮助文档.txt");
	}
	
	
	
	//习惯上会将主类对象引入注入到控制器中，以便控制器
	//能访问主类中定义的方法，完成特定的功能（比如切换窗体内容）
	private Main main;
	public void setMain(Main main) {
		this.main=main;

	}


}
