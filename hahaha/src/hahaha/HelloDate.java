package hahaha;

import java.util.*;
//import java.lang.String;
public class HelloDate{
	private String s;
	public String GetHelloDate(){
		s="你好，现在是：";
		s=s+(new Date().toString());
		return s;
	}
	
}