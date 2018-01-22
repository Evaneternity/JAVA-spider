
package com.dapeng.test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.dapeng.bean.Article;
import com.dapeng.method.UtilMethod;
import com.dapeng.bean.Article;


public class Search {
	
	private String url1="http://cn.bing.com/search?q=";//利用bing搜索引擎
	private String url2="+site%3Awww.bxwx9.org";//在笔下小说网站内搜索
	
	public static String main(String s) {
		// TODO Auto-generated method stub
		Search sea=new Search();
		String firstUrl = sea.url1+s+sea.url2;
		
		return getArticle(sea.url1+s+sea.url2);
	
	}
		
	/**
	 * 根据网页的url获取Document对象
	 * @param url 搜索网页的url
	 * @return Document对象
	 */
	public static Document getDocument(String url){
		Document doc = null;
		try {
			doc = Jsoup.connect(url).timeout(5000).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}
	
	/**
	 * 根据获取的Document对象找到小说名的章节列表的URL
	 * @param Document doc
	 * @return 章节列表的URL
	 */
	public static String getSearchUrl(Document doc){
		//System.out.println(s);
		Element ol = doc.select("ol").first();
		//System.out.println(ol.toString());
		String regex = "<a target=\"_blank\" href=\"(.*?)\"(.*?)>(.*?)<\\/a>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(ol.toString());
		Document nextDoc = null;
		if (matcher.find()) {
			nextDoc = Jsoup.parse(matcher.group());
			Element href = nextDoc.select("a").first();
			String muluurl=new String(href.attr("href"));
			System.out.println(muluurl);
			//return "http://www.bxwx.org/b/5/5131/" + href.attr("href");
			//return href.attr("href");
			Article article = new Article();		
			article.setUrl(muluurl);
			Document doc1 = getDocument(muluurl);
			System.out.println(getFirstChUrl(doc1));
			
			String URl=muluurl;
			for(int number=0,i=0;i<URl.length();i++)
			{
				if(URl.charAt(i)=='/')
				{
					number++;
				}
				if(number==6)
				{
					URl=URl.substring(0,i+1);
					//System.out.println(s);
					break;
				}
					
			}
			
			return URl+getFirstChUrl(doc1);
			
		}else{
			return null;
		}
		
		
	}
	
	
	/**
	 * 根据获取的Document对象找到小说名的第一章的URL
	 * @param Document doc
	 * @return 章小说第一章的URL
	 */
	public static String getFirstChUrl(Document doc){
		//System.out.println(s);
		Element dd = doc.select("dd").get(1);
		//System.out.println(ol.toString());
		String regex = "<a href=\"(.*?)\">(.*?)</a>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(dd.toString());
		Document nextDoc = null;
		if (matcher.find()) {
			nextDoc = Jsoup.parse(matcher.group());
			Element href = nextDoc.select("a").first();
			String firstchurl=new String(href.attr("href"));
			System.out.println(firstchurl);
			//return "http://www.bxwx.org/b/5/5131/" + href.attr("href");
			//return href.attr("href");

			return firstchurl;
			
			
		}else{
			return null;
		}
		
		
	}
	
	/**
	 * 根据url获取id
	 * @param url
	 * @return id 
	 */
	public static String getId(String url){
		String urlSpilts[] = url.split("/");
		return (urlSpilts[urlSpilts.length - 1]).split("\\.")[0];
	}
	
	/**
	 * 根据Url（此URL为利用bing搜索引擎在笔下小说网站搜索）返回搜索到的小说的章节列表
	 * @param URL
	 * @return URL
	 */
	public static String getArticle(String url){
		
		Document doc = getDocument(url);
		return(getSearchUrl(doc));
		
	}
	
	

}
