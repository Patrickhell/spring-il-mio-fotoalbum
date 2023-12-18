package org.java.spring.db.service;

import java.util.List;

import org.java.spring.db.pojo.Message;
import org.java.spring.db.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServ {
	
	@Autowired
	private MessageRepo messageRepo;
	
	
	public List<Message> findAll() {
		
		return  messageRepo.findAll();
		
	}
	
	public Message findById(int id) {
		
		return messageRepo.findById(id).get();
	}
	
	public Message save(Message message) {
		return messageRepo.save(message);
	}
	

}