package com.yolo.model;


/**
 * NaverBlogVO.java
 *
 * @author Jun
 * @since 2018. 7. 2.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 2. Jun 최초 생성
 *
 * </pre>
 */
/**
 * NaverBlogVO.java
 *
 * @author Jun
 * @since 2018. 7. 2.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 7. 2. Jun 최초 생성
 *
 * </pre>
 */
public class NaverBlogVO {
	private String title;//게시글 이름
	private String link;//게시글 링크
	private String description;//게시글 설명
	private String bloggername;//블로거 이름
	private String bloggerlink;//블로그 링크
	private String postdate;//게시일
	
	private final String regex = "http://blog.naver.com/([a-zA-Z0-9]*)\\?Redirect=Log&amp;logNo=([0-9]*)";;
	
	public String getTitle() {
		if (title == null)
			return "없음";
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		if (link == null)
			return "없음";
		return link.replaceAll(regex, "https://blog.naver.com/$1/$2");
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		if (description == null)
			return "없음";
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBloggername() {
		if (bloggername == null)
			return "없음";
		return bloggername;
	}
	public void setBloggername(String bloggername) {
		this.bloggername = bloggername;
	}
	public String getBloggerlink() {
		if (bloggerlink == null)
			return "없음";
		return bloggerlink;
	}
	public void setBloggerlink(String bloggerlink) {
		this.bloggerlink = bloggerlink;
	}
	public String getPostdate() {
		if (postdate == null)
			return "없음";
		return postdate.substring(0,4) + "." + postdate.substring(4,6) + "." + postdate.substring(6,8);
	}
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	
	@Override
	public String toString() {
		return "NaverBlogVO [title=" + title + ", link=" + link.replaceAll(regex, "https://blog.naver.com/$1/$2")
				+ ", description=" + description + ", bloggername="
				+ bloggername + ", bloggerlink=" + bloggerlink + ", postdate="
				+ postdate + "]";
	}
	
	public NaverBlogVO(String title, String link, String description,
			String bloggername, String bloggerlink, String postdate) {
		super();
		this.title = title;
		this.link = link;
		this.description = description;
		this.bloggername = bloggername;
		this.bloggerlink = bloggerlink;
		this.postdate = postdate;
	}
	
	public NaverBlogVO() {
		super();
	}
	
}
