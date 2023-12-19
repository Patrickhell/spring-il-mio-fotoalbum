package org.java.spring.restController;

import java.util.List;

import org.java.spring.db.pojo.Image;
import org.java.spring.db.service.ImageServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fotoalbum")
public class ApiFotoController {
	
	@Autowired
	private ImageServ imageServ;
	
	@GetMapping
	public ResponseEntity<List<Image>> getIndex(@RequestParam(required = false) String query) {
		
		List<Image> images;

	    if (query == null || query.isEmpty()) {
	        images = imageServ.findAll(); 
	        
	    } else {
	        images = imageServ.findByName(query);
	    }
	    
		return new ResponseEntity<>(images, HttpStatus.OK);
		
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity <Image> getImage(@PathVariable int id) {
		
		Image image = imageServ.findById(id);
		
		return new ResponseEntity<>(image, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Image> createImage(@RequestBody Image image) {
		
		imageServ.save(image);
		
		return new ResponseEntity<>(image, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity <Image> UpdateImage(@PathVariable int id, @RequestBody Image newImage) {
		
		Image image = imageServ.findById(id);
		
		image.setName(newImage.getName());
		image.setDescription(newImage.getDescription());
		image.setFoto(newImage.getFoto());
		image.setVisible(newImage.isVisible());
		
		imageServ.save(image);
		
		return new ResponseEntity<>(image, HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity <Image> deleteImage(@PathVariable int id) {
		
		Image image = imageServ.findById(id);
		
		imageServ.delete(image);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
