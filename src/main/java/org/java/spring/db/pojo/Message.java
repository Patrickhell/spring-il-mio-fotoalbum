package org.java.spring.db.pojo;

import org.hibernate.validator.constraints.Length;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	@NotNull
	private String email;
	
	@Column(nullable = false)
	@NotNull
	@Length(min = 5, max = 255)
	private String content;
	
	
	public  Message() { }
	public Message(String email, String content) {
		
		setEmail(email);
		setContent(content);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + getId() + "]" + getEmail() + getContent();
	}
	
	
	

}