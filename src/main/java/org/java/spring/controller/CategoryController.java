package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.pojo.Image;
import org.java.spring.db.service.CategoryServ;
import org.java.spring.db.service.ImageServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryServ categoryServ;
	
	@Autowired
	private ImageServ imageServ;
	
	
	@GetMapping("/CategoryList")
	public String getAllCategories(Model model) {
		
		List<Category> categories = categoryServ.findAll();
		
		model.addAttribute("categories", categories );
		
		return "CategoryList";
		
	}
	
	@GetMapping("/category/create")
	public String createNewCategory(Model model) {
		
		model.addAttribute("category", new Category());
		
		
		return"/Category-form";
	}
	
	@PostMapping("/category/create")
	public String storeCategory(Model model, @Valid @ModelAttribute Category category, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
        if(bindingResult.hasErrors()) {
			
			System.out.println(bindingResult);
			
			model.addAttribute("category", category);
			
			return "/Category-form";
		}
		
        categoryServ.save(category);
        redirectAttributes.addFlashAttribute("storeCategory", "Categoria creata con successo");
		
		return "redirect:/CategoryList";
	}
	
	@PostMapping("/Category/delete/{id}")
	public String deleteCategories( @PathVariable int id, RedirectAttributes redirectAttributes) {
		
		Category singleCategory = categoryServ.findById(id);
		
		for(Image image : singleCategory.getImages()) {
			
			image.deleteCategories(singleCategory);
			
			imageServ.save(image);
		}
		
		
		categoryServ.delete(singleCategory);
		
		redirectAttributes.addFlashAttribute("deleteCategory", "Categoria Cancellata con successo");
		
		
		return "redirect:/CategoryList";
		
	}
}
