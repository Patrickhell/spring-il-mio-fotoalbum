package org.java.spring.db.repo;

import java.util.List;

import org.java.spring.db.pojo.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository <Message, Integer>{
	
	List<Message> findByuserProfileId(int userProfileId);
	

}

