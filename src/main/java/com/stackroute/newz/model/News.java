package com.stackroute.newz.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


/*
 * The class "News" will be acting as the data model for the News Table in the database. 
 * Please note that this class is annotated with @Entity annotation. 
 * Hibernate will scan all package for any Java objects annotated with the @Entity annotation. 
 * If it finds any, then it will begin the process of looking through that particular 
 * Java object to recreate it as a table in your database.
 */

@Entity
@Table(name="news")
public class News {
	@Id //specifies the primary key of the entity
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="news_id")
	int newsId;
	@Column(name="title")
	String title;
	@Column(name="author")
	String author;
	@Column(name="description")
	String description;
	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name="publishedAt")
	LocalDateTime publishedAt;
	@Column(name="content")
	String content;
	@Column(name="url")
	String url;
	@Column(name="urlToImage")
	String urlToImage;
	@ManyToOne
	@JoinColumn(name="user_id_fk")
	@JsonIgnore
	UserProfile user;
	@OneToOne
//	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "reminder_id_fk")
	Reminder reminder;

	/*
	 * This class should have ten fields
	 * (newsId,title,author,description, publishedAt, content, url, urlToImage,user,reminder). 
	 * Out of these ten fields, the
	 * field newsId should be primary key and auto-generated. This class should
	 * also contain the getters and setters for the fields along with the no-arg ,
	 * parameterized constructor and toString method. 
	 * annotate user field with @ManyToOne and reminder field as @OneToOne and add
	 * @JsonIgnore for both of them.
	 * 
	 * The data type for publishedAt field should be LocalDateTime. 
	 * Please add @JsonSerialize(using = ToStringSerializer.class) for this field
	 */
	
	
	
	
	public News(int newsId, String title, String author, String description, LocalDateTime publishedAt, String content,
			String url, String urlToImage, UserProfile user, Reminder reminder) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.publishedAt = publishedAt;
		this.content = content;
		this.url = url;
		this.urlToImage = urlToImage;
		this.user = user;
		this.reminder = reminder;
		
	}
	
	
	/**
	 * @return the newsID
	 */
	
	public News() {
		super();
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the newsID
	 */
	public int getNewsId() {
		return newsId;
		
	}
	/**
	 * @param newsID the newsID to set
	 */
	public void setNewsId(int newsId) {
		this.newsId=newsId;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title=title;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url=url;
	}
	/**
	 * @return the urlToImage
	 */
	public String getUrlToImage() {
		return this.urlToImage;
	}
	/**
	 * @param urlToImage the urlToImage to set
	 */
	public void setUrlToImage(String urlToImage) {
		this.urlToImage=urlToImage;		
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author=author;		
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description=description;
	}
	/**
	 * @return the publishedAt
	 */
	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}
	/**
	 * @param publishedAt the publishedAt to set
	 */
	public void setPublishedAt(LocalDateTime publishedAt) {
		this.publishedAt=publishedAt;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content=content;
		
	}
	public UserProfile getUser() {
		return user;
	}


	public void setUser(UserProfile user) {
		this.user = user;
	}


	public Reminder getReminder() {
		return reminder;
	}


	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}


	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", publishedAt=" + publishedAt + ", content=" + content + ", url=" + url + ", urlToImage="
				+ urlToImage + ", user=" + user + ", reminder=" + reminder + "]";
	}
	
	
	

	
	
}
