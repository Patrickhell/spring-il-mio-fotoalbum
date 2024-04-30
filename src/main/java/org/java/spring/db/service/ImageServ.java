package org.java.spring.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.pojo.Image;
import org.java.spring.db.pojo.UserProfile;
import org.java.spring.db.repo.ImageRepo;
import org.java.spring.db.repo.UserProfileRepo;
import org.java.spring.dto.DtoImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServ {
	
	@Autowired
	private ImageRepo imageRepo;
	
	@Autowired
	private UserProfileRepo userProfileRepo;
	
	public List<Image> findAll() {
		
		return imageRepo.findAll();
	}
	
   public List<Image> findVisible() {
		
		return imageRepo.findAll().stream().filter(item -> item.getIsVisible() == true).toList();
	}
	
	public Image findById(int id){
		
		return imageRepo.findById(id).get();
	}
	
   public List<Image> findByName(String query){
		
		return imageRepo.findByNameContainingIgnoreCase(query);
		
	}
	
	public List<Image> findByNameLike(String query) {
		
		return imageRepo.findByNameLikeIgnoreCase(query);
	}
	
	public List<Image> findByUserProfile(int userProfileId) {
		
		return imageRepo.findImageByUserProfileId(userProfileId);
	}
	
   public Image save(DtoImage dtoImage) {
	   Optional<UserProfile> userProfile = userProfileRepo.findById(dtoImage.getProfileId());
	   List<Category> categoryList = new ArrayList<Category>();
	   
	   if(dtoImage.getCategories() != null) {
		   for (String item : dtoImage.getCategories()) {

			   categoryList.add(new Category(item));
		}
		   
	   }
	   
	   Image image = new Image(dtoImage.getName(), dtoImage.getDescription() , dtoImage.isVisible() , dtoImage.getFoto() , userProfile.get(), categoryList );
		
    	return imageRepo.save(image);
	}
    
   public Image save(Image image) {
		
    	return imageRepo.save(image);
	}
   
    public void delete(Image image) {
		
    	imageRepo.delete(image);
	}
    
	public void deleteById(int id) {
		
		imageRepo.deleteById(id);
	}

}
