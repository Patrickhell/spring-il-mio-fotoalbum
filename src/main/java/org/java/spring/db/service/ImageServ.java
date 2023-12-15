package org.java.spring.db.service;

import java.util.List;

import org.java.spring.db.pojo.Image;
import org.java.spring.db.repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServ {
	
	@Autowired
	private ImageRepo imageRepo;
	
	public List<Image> findAll() {
		
		return imageRepo.findAll();
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
