package com.stackroute.newz.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.aspectj.weaver.tools.Trace;
import org.springframework.stereotype.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/*
 * The class "UserProfile" will be acting as the data model for the UserProfile Table in the database. 
 * Please note that this class is annotated with @Entity annotation. 
 * Hibernate will scan all package for any Java objects annotated with the @Entity annotation. 
 * If it finds any, then it will begin the process of looking through that particular 
 * Java object to recreate it as a table in your database.
 */
@Entity
@Table(name="userprofile")
public class UserProfile {
	/*
	 * This class should have six fields
	 * (newsId,firstName,lastName, contact,createAt,newsList). 
	 * Out of these six fields, the
	 * field newsId should be primary key and auto-generated. This class should
	 * also contain the getters and setters for the fields along with the no-arg ,
	 * parameterized constructor and toString method. 
	 * annotate newsList field with @OneToMany and add
	 * @JsonIgnore annotation.
	 * 
	 * The data type for createAt field should be LocalDateTime. 
	 * Please add @JsonSerialize(using = ToStringSerializer.class) for this field
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	String userId;
	@Column(name="firstName")
	String firstName;
	@Column(name="lastName")
	String lastName;
	@Column(name="contact")
	String contact; 
	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name="createAt")
	LocalDateTime createAt;
	@OneToMany
//	(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	List<News> newsList;

	
	
	
	public UserProfile(String userId, String firstName, String lastName, String contact, LocalDateTime createAt,
			List<News> newsList) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.createAt = createAt;
		this.newsList = newsList;		
	}

	public UserProfile() {
		super();
	}

	
	public String getContact() {
		return contact;
	}

	
	public void setContact(String contact) {
		this.contact=contact;
	}

	
	public LocalDateTime getCreateAt() {
		return createAt;
	}

	
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt=createAt;
	}

	
	public String getUserId() {
		return userId;
	}

	
	public void setUserId(String userId) {
		this.userId=userId;
	}

	
	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	@Override
	public String toString() {
		return "UserProfile [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", contact="
				+ contact + ", createAt=" + createAt + ", newsList=" + newsList + "]";
	}

	

}
