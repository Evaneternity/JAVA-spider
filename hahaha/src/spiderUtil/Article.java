package spiderUtil;

public class Article {
	
	private String id;//id
	private String title;//����
	private String content;//����
	private String url;//��ǰ�½�url
	private String nextUrl;//��һ��url
	
	
	public String getId() 
	{
		return id;
	}
	
	public void setId(String id) 
	{
		this.id = id;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public String getContent() 
	{
		return content;
	}
	
	public void setContent(String content) 
	{
		this.content = content;
	}
	
	public String getUrl() 
	{
		return url;
	}
	
	public void setUrl(String url) 
	{
		this.url = url;
	}
	
	public String getNextUrl()
	{
		return nextUrl;
	}
	
	public void setNextUrl(String nextUrl)
	{
		this.nextUrl = nextUrl;
	}
	
	@Override
	public String toString() 
	{
		return "Article [id=" + id + ", title=" + title + ", content="
				+ content + ", url=" + url + ", nextUrl=" + nextUrl + "]";
	}
	
}
