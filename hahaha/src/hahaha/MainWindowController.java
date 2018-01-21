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
	
	//显示日期按钮按下
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
		ObservableList<String> strList = (ObservableList) FXCollections.observableArrayList("红色","黄色","绿色");  
		 
		BookList.setItems(strList);  

	}
	
	
	
	//@FXML private MenuItem StartReaderItem;
	@FXML
	public void StartReader(){
		DateLbl.setText("启动阅读器");
		JSQ reader=new JSQ();
		reader.main(null);
	}
	
	
	
	
	
	//习惯上会将主类对象引入注入到控制器中，以便控制器
	//能访问主类中定义的方法，完成特定的功能（比如切换窗体内容）
	private Main main;
	public void setMain(Main main) {
		this.main=main;

	}


}
