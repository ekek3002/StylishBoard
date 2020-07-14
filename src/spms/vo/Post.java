package spms.vo;

import java.util.Date;

public class Post {
	protected int no;				
	protected String title;			
	protected String content;		
	protected Date createdDate;		
	protected String id;
	
	public String getId() {
		return id;
	}
	public Post setId(String id) {
		this.id = id;
		return this;
	}
	
	public int getNo() {
		return no;
	}
	public Post setNo(int no) {
		this.no = no;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Post setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Post setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Post setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
}
