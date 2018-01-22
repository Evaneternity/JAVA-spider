package hahaha;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Initial {
	public void main() throws IOException{
		//System.out.println(System.getProperty("user.dir"));
		File file=new File(System.getProperty("user.dir")+"\\book\\帮助文档.txt");
		if (!file.exists()){
			File dir = new File(file.getParent());  
			dir.mkdirs();
			file.createNewFile();  
			String s=new String("Nothing按钮：真的没啥用\nSomething按钮：点击可以刷新书架");
			byte[] sourceByte = s.getBytes();  
			FileOutputStream outStream = new FileOutputStream(file);
			outStream.write(sourceByte); 
			outStream.close(); 
		}
		
		
	}
}
