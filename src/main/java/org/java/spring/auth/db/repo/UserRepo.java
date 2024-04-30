package org.java.spring.auth.db.repo;


import java.util.Optional;

import org.java.spring.auth.db.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	 Optional<User> findByUsername(String username);

	    Optional<User> findById(int id);

}
