package org.java.spring.db.service;

import java.util.List;
import java.util.Optional;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServ {

	@Autowired
	private CategoryRepo categoryRepo;
	
	
	public List<Category> findAll() {
		
		return categoryRepo.findAll();
	}
	
	public Category findById(int id) {
		
		return categoryRepo.findById(id).get();
	}
	public void save(Category category) {
		
		Optional<Category> findByNameIfExist = categoryRepo.findByName(category.getName());
			
			if(findByNameIfExist.isPresent()) {
				
				throw new IllegalStateException("La categoria" + category.getName() + "è gia esistente");
			}
		
		categoryRepo.save(category);
	}
	
	
	public void delete(Category category) {
		
		categoryRepo.delete(category);
	}
   public void deleteBtId(int id) {
		
		categoryRepo.deleteById(id);
	}
	
}
