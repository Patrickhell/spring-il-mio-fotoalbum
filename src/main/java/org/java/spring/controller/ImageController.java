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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;


@Controller
public class ImageController {
	
	@Autowired
	private ImageServ imageServ;
	
	@Autowired
	private CategoryServ categoryServ;
	
	
	@GetMapping
	public String getImages(Model model,  @RequestParam(required = false) String query) {
		
		
		List<Image> images = query == null ? imageServ.findAll() : imageServ.findByName(query);
		
		model.addAttribute("images", images);
		model.addAttribute("query", query == null ? "" : query);
		
		return "ImageIndex";
				
		
	}

	
	@GetMapping("/image/{id}")
	public String getSingleImage(Model model, @PathVariable int id) {
		
		Image singleImage = imageServ.findById(id);
	
		
		model.addAttribute("singleImage", singleImage);
		
		return "SingleImage";
		
	}
	
	@GetMapping("/image/create")
	public String CreatenewImage(Model model) {
		
		List<Category> Categories = categoryServ.findAll();
		
		model.addAttribute("image", new Image());
		model.addAttribute("categories", Categories);
		
		return "/image-form";
	}
	
	@PostMapping("/image/create")
	public String ImageStore(Model  model, @Valid @ModelAttribute Image image, BindingResult bindingResult) {
		

		if(bindingResult.hasErrors()) {
			
			System.out.println(bindingResult);
			model.addAttribute("image", image);
			
			return "/image-form";
		}
		
		imageServ.save(image);
		
		return "redirect:/";
		
	}
	
	@GetMapping("image/edit/{id}")
	public String editImage(Model model, @PathVariable int id) {
		
		List<Category> categories = categoryServ.findAll();
		Image singleImage = imageServ.findById(id);
		
		model.addAttribute("singleImage", singleImage);
		model.addAttribute("categories", categories);
		
		return"/image-edit";
		
		
	}
	
	@PostMapping("image/edit/{id}")
	public String updateImage(Model  model, @Valid @ModelAttribute Image image, BindingResult bindingResult) {
		
       if(bindingResult.hasErrors()) {
			
			System.out.println(bindingResult);
			model.addAttribute("image", image);
			
			return "/image-edit";
		}
       imageServ.save(image);
       
       return"redirect:/";
	}
	
	@PostMapping("image/delete/{id}") 
	public String deleteImage(@PathVariable int id, RedirectAttributes redirectAttributes){
			
			Image singleImage = imageServ.findById(id);
			
			singleImage.ClearCategories();
			imageServ.save(singleImage);
			
			imageServ.delete(singleImage);
			
			redirectAttributes.addFlashAttribute("deleteImage", singleImage);
			
			return"redirect:/";
			
	}
	
	
	
}
