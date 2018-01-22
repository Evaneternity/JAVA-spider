package com.dapeng.test;

import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URLEncoder;

import com.dapeng.bean.Article;
import com.dapeng.method.UtilMethod;


import org.apache.commons.*;

public class GetArticles {
	private String bookname;
	
	public void Setbookname(String bookname)
	{
		this.bookname=bookname;
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		GetArticles book=new GetArticles();
		//book.bookname=efrefef;
//		File file=new File(System.getProperty("user.dir")+"\\book");
//		file.mkdirs();
//		
		String path = "C:\\Users\\GJLDR\\Desktop\\JAVA大作业\\spider\\1.txt";
		File file = new File(path);
		
		// TODO Auto-generated method stub
		//String firstUrl = "http://www.23us.so/files/article/html/13/13018/index.html";
		//String firstUrl = "http://www.bxwx.org/b/5/5131/832882.html";
		//String firstUrl = "http://www.bxwx.org/b/155/155024/26311965.html";
//		GetArticles f=new GetArticles();
//		String firstUrl = f.FirstURL;
//		Article article = UtilMethod.getArticle(firstUrl);
		
		
		String toutf=(URLEncoder.encode("神墓", "UTF-8")); //---> %E4%B8%8A%E6%B5%B7 
		
		Search sea=new Search();
		String firstch=sea.main(toutf+"+%E6%9C%80%E6%96%B0%E7%AB%A0%E8%8A%82");
		//String firstch=sea.main("神墓");
		Article article = UtilMethod.getArticle(firstch);
		
		   
		   int i=0;
		while(article.getNextUrl() != null && article.getContent() != null && !article.getId().equals("996627"))
		{
			i++;
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println(article.getId()+"----"+article.getTitle());
			
			bw.write("----"+article.getTitle()+"   WL小说阅读软件(java语言)");
			bw.newLine(); 
			
			System.out.println(article.getContent());
			//bw.write(article.getContent().replaceAll("([\\S]*){4}","1"));
			bw.write(article.getContent().replace((char)160,'\0'));
			//int temp=(int)article.getContent().charAt(0);
			//int temp2=(int)article.getContent().charAt(4);
			//System.out.println(temp+" "+temp2);
			bw.newLine();
			bw.close();
			article = UtilMethod.getArticle(article.getNextUrl());
		if(i==10)break;
		}
		
	}

}
