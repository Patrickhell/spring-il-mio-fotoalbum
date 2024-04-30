package org.java.spring.restController;

import java.util.List;

import org.java.spring.db.pojo.Message;
import org.java.spring.db.service.MessageServ;
import org.java.spring.dto.DtoMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ApiMessageController {
	
	@Autowired
	private MessageServ messageServ;
	
	@GetMapping("/{userProfileId}")
	public ResponseEntity<List<Message>> getAllMessagesByUserProfileId(@PathVariable int userProfileId) {
		
		List <Message> messages = messageServ.findByuserProfileId(userProfileId);
		
		return new ResponseEntity<>(messages, HttpStatus.OK);
	}
	
	@GetMapping("/messages/{id}")
	public ResponseEntity <Message> getMessagesByUserProfileId(@PathVariable int id) {
		
		Message message = messageServ.findById(id);
		
		return new ResponseEntity<>(message, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<DtoMessage> createMessage(@RequestBody DtoMessage message){
		
		messageServ.save(message);
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
