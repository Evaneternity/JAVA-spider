package com.dapeng.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import com.dapeng.bean.Article;
import com.dapeng.method.UtilMethod;
import org.apache.commons.*;

public class GetArticles {
	private String FirstURL="http://www.bxwx.org/b/155/155024/26311965.html";
	
	public void setFirstURL(String s){
		this.FirstURL=s;
	}
	public String getFirstURL(){
		return this.FirstURL;
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\GJLDR\\Desktop\\JAVA����ҵ\\spider\\1.txt";
		File file = new File(path);
		String b = new String();
		//�����ļ������
		//FileOutputStream out= new FileOutputStream(file,true);
		//��������������GET�����õ�����Դ������ʽ����
		//InputStream inputstream = getMethod.getResponseBodyAsStream();
		
		// TODO Auto-generated method stub
		//String firstUrl = "http://www.23us.so/files/article/html/13/13018/index.html";
		//String firstUrl = "http://www.bxwx.org/b/5/5131/832882.html";
		//String firstUrl = "http://www.bxwx.org/b/155/155024/26311965.html";
		GetArticles f=new GetArticles();
		String firstUrl = f.FirstURL;
		Article article = UtilMethod.getArticle(firstUrl);
		while(article.getNextUrl() != null && article.getContent() != null && !article.getId().equals("996627")){
			article = UtilMethod.getArticle(article.getNextUrl());
			System.out.println(article.getId()+"----"+article.getTitle());
//			FileOutputStream out1= new FileOutputStream(file,true);
//			b=article.getTitle();
//			byte bytes[]=new byte[9000];   
//            bytes=b.getBytes();  
//            int len=bytes.length;   //���ֽڵĳ��ȣ������ַ����ĳ���
//            out1.write(bytes,0,len); 
//            b="123\n";
//            bytes=b.getBytes();  
//            len=bytes.length;   //���ֽڵĳ��ȣ������ַ����ĳ���
//            out1.write(bytes,0,len);
//            b=article.getContent();
//			bytes=b.getBytes();  
//            len=bytes.length;   //���ֽڵĳ��ȣ������ַ����ĳ���
//            out1.write(bytes,0,len);
//            out1.close();
		}
	}

}
