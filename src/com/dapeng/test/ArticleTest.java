package com.dapeng.test;

import com.dapeng.bean.Article;
import com.dapeng.method.UtilMethod;

public class ArticleTest {

	public static String startUrl = "http://www.bxwx.org/b/5/5131/832883.html";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Article article = UtilMethod.getArticle(startUrl);
		System.out.println(article);
	}

}
