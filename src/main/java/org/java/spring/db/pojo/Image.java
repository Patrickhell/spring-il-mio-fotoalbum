package org.java.spring.db.pojo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, unique = true)
	@Length (min = 5, max = 60, message = "Il nome aver un numero di caratteri compreso tra 5 e 60")
	private String name;
	
	@Column(columnDefinition = "TEXT")
	@NotEmpty(message = "Il campo descrizione non può essere vuoto")
	@Length (min = 10 , max = 120, message = "Il nome aver un numero di caratteri compreso tra 10 e 120")
	private String description;
	
	@Column
	private boolean isVisible;
	
	@Column(length = 300)
	@NotEmpty(message = "Il image Url nome non può essere vuoto")
	private String foto;
	
	@ManyToMany()
	private List<Category>categories;
	
	public Image() { }
	public Image (String name, String description, boolean isVisible, String foto, Category... categories) {
		
		setName(name);
		setDescription(description);
		setVisible(isVisible);
		setFoto(foto);
		setCategories(categories);
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String image) {
		this.foto = image;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void deleteCategories(Category category) {
		getCategories().remove(category);
	}
	
	public void ClearCategories() {
		getCategories().clear();
	}
	
	@JsonProperty
	public void setCategories(Category... categories) {
		
		setCategories(Arrays.asList(categories));
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + getId() + "] " + getName() + getDescription() + isVisible() + getFoto();
	}
	
	
	
	
	
	

}
