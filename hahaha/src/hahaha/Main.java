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
    
	//��ʾ������
	public void mainWindow() {

		try {
			//װ����ͼ
			FXMLLoader loader = new FXMLLoader(
					Main.class.getResource("hahahaxml.fxml"));
			AnchorPane root = (AnchorPane) loader.load();

			//��ȡ����������
			MainWindowController controller=loader.getController();
			//������������ô��������
			controller.setMain(this);

			//������������̨
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("WL�Ķ�");
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
