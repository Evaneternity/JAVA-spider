package hahaha;

import java.lang.System;
import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		mainWindow();
	}
    
	//显示主窗体
	public void mainWindow() {

		try {
			//装载视图
			FXMLLoader loader = new FXMLLoader(
					Main.class.getResource("hahahaxml.fxml"));
			AnchorPane root = (AnchorPane) loader.load();

			//获取控制器引用
			MainWindowController controller=loader.getController();
			//将主类对象引用传入控制器
			controller.setMain(this);

			//构建场景和舞台
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("WL阅读");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {
		Initial ini=new Initial();
		ini.main();
		launch(args);
	}

}
