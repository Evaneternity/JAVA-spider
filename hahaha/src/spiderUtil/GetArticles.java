package spiderUtil;

import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URLEncoder;
import java.util.Date;

import spiderUtil.Article;
import spiderUtil.UtilMethod;


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
	public void main(String sername,int mode) throws IOException {
		
			
		GetArticles book=new GetArticles();
		//book.bookname=efrefef;
//		File file=new File(System.getProperty("user.dir")+"\\book");
//		file.mkdirs();
//		
		File file;
		
		// TODO Auto-generated method stub
		//String firstUrl = "http://www.23us.so/files/article/html/13/13018/index.html";
		//String firstUrl = "http://www.bxwx.org/b/5/5131/832882.html";
		//String firstUrl = "http://www.bxwx.org/b/155/155024/26311965.html";
//		GetArticles f=new GetArticles();
//		String firstUrl = f.FirstURL;
//		Article article = UtilMethod.getArticle(firstUrl);
		Article article;
		if (mode==1){
			String path = System.getProperty("user.dir")+"\\book\\"+sername+".txt";
			file = new File(path);
		
		String toutf=(URLEncoder.encode(sername, "UTF-8")); //---> %E4%B8%8A%E6%B5%B7 
		
		Search sea=new Search();
		String firstch=sea.main(toutf+"+%E6%9C%80%E6%96%B0%E7%AB%A0%E8%8A%82");
		//String firstch=sea.main(toutf);
		//String firstch=sea.main("神墓");
		System.out.println(firstch);
			article = UtilMethod.getArticle(firstch);
		}
		else if (mode==2){
			String path = System.getProperty("user.dir")+"\\book\\"+sername.replace('/','_').replace(':','_').replace('.','_')+".txt";

			file = new File(path);
			article = UtilMethod.getArticle(sername);
		}
		else{
			article=UtilMethod.getArticle(null);
			file = new File(System.getProperty("user.dir")+"\\book\\error.txt");
		}
		   
		int i=0;
		while(article.getNextUrl() != null && article.getContent() != null && !article.getId().equals("996627"))
		{
			i++;
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println(article.getId()+"----"+article.getTitle());
			
			bw.write("----"+article.getTitle()+"   WL小说阅读软件(java语言)");
			bw.newLine(); 
			
			//System.out.println(article.getContent());
			//bw.write(article.getContent().replaceAll("([\\S]*){4}","1"));
			//bw.write(article.getContent().replace((char)160,(char)10));
			bw.write(article.getContent().replaceAll("\\u00A0{4}",""+(char)32+(char)32+(char)10+(char)10));
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
