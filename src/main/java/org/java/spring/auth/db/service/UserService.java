package org.java.spring.auth.db.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.java.spring.auth.db.Role;
import org.java.spring.auth.db.User;
import org.java.spring.auth.db.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;
	
	public List<User> findAll() {
		
		return userRepo.findAll();
	}

	
	public User save(User user) {
		
		return userRepo.save(user);
	}
	
   
    
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public Optional<User> findById(int id) {
        return userRepo.findById(id);
    }
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> userOptional = userRepo.findByUsername(username);
		
		if (!userOptional.isPresent()) {
			
			throw new UsernameNotFoundException("Username not found");
		}
		
		 User user = userOptional.get();
		 return new org.springframework.security.core.userdetails.User(
			        user.getUsername(),
			        user.getPassword(),
			        mapRolesToAuthorities(user.getRoles())
	     );		        
		 
	}


	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
		 return roles.stream()
		            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
		            .collect(Collectors.toList());
	}

}
