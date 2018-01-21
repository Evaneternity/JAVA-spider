package com.dapeng.test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GetOneChatper {
	
	
	public static String startUrl = "http://www.bxwx.org/b/5/5131/832883.html";
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect(startUrl).timeout(5000).get();
		System.out.println(doc.getElementById("title").text());
		System.out.println(doc.getElementById("content").text());
		Element ul = doc.select("ul").first();
		String regex = "<li><a href=\"(.*?)\">ÏÂÒ»Ò³<\\/a><\\/li>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(ul.toString());
		System.out.println(matcher.find());
		System.out.println(matcher.group());
		Document nextDoc = Jsoup.parse(matcher.group());
		Element href = nextDoc.select("a").first();
		System.out.println(href.attr("href"));
		//System.out.println(ul);
		//System.out.println(doc);
	}
	
	

}
