package hahaha;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Initial {
	public void main() throws IOException{
		//System.out.println(System.getProperty("user.dir"));
		File file=new File(System.getProperty("user.dir")+"\\book\\�����ĵ�.txt");
		if (!file.exists()){
			File dir = new File(file.getParent());  
			dir.mkdirs();
			file.createNewFile();  
			String s=new String("Nothing��ť�����ûɶ��\nSomething��ť���������ˢ�����");
			byte[] sourceByte = s.getBytes();  
			FileOutputStream outStream = new FileOutputStream(file);
			outStream.write(sourceByte); 
			outStream.close(); 
		}
		
		
	}
}
