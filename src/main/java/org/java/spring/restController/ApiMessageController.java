package org.java.spring.restController;

import org.java.spring.db.pojo.Message;
import org.java.spring.db.service.MessageServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ApiMessageController {
	
	@Autowired
	private MessageServ messageServ;
	
	@PostMapping
	public ResponseEntity<Message> message(@RequestBody Message message){
		
		messageServ.save(message);
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
