package org.java.spring.db.service;

import java.util.List;
import java.util.Optional;

import org.java.spring.db.pojo.UserProfile;
import org.java.spring.db.pojo.Message;
import org.java.spring.db.repo.MessageRepo;
import org.java.spring.db.repo.UserProfileRepo;
import org.java.spring.dto.DtoMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServ {
	
	@Autowired
	private MessageRepo messageRepo;
	
	@Autowired
	private UserProfileRepo userProfileRepo;
	
	
	public List<Message> findAll() {
		
		return  messageRepo.findAll();
		
	}
	
	public Message findById(int id) {
		
		return messageRepo.findById(id).get();
	}
	
	public Message save(DtoMessage dtoMessage ) {
		
	  Optional<UserProfile> userProfile = userProfileRepo.findById(dtoMessage.getProfileId());
	  if(userProfile.isPresent()) {
		  
		  Message message = new Message(dtoMessage.getName(), dtoMessage.getEmail(), dtoMessage.getContent(), userProfile.get());
		    return messageRepo.save(message);

	  } else {
		  return null;
	  }
	}
	
	public List<Message> findByuserProfileId(int userProfileId){
		
		return messageRepo.findByuserProfileId(userProfileId);
	}

	public void delete (Message message) {
		
			messageRepo.delete(message);
	}
	
	public void deleteMessagesByUserProfileId(int userProfileId) {
	    List<Message> messages = messageRepo.findByuserProfileId(userProfileId);
	    messageRepo.deleteAll(messages);
	}
	
	
	
	
	
	

}