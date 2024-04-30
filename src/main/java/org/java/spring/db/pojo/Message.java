package org.java.spring.db.pojo;


import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	@Length(min = 5, max = 255)
	private String content;
	
	
	@ManyToOne
	@JoinColumn(name = "user_profile_id")
	@JsonIgnore
	private UserProfile userProfile;
	
	public  Message() { }
	public Message(String name, String email , String content, UserProfile userProfile ) {
		
		setContent(name);
		setName(email);
		setEmail(content);
		setUserProfile(userProfile);
	}
	
	
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getContent() {
		return content;
	}
	
	
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	public UserProfile getUserProfile() {
		return userProfile;
	}
	
	
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + getId() + "]" + getName() + getEmail() + getContent();
	}
	
	
	

}