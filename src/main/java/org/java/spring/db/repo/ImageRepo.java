package org.java.spring.db.repo;


import java.util.List;

import org.java.spring.db.pojo.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo  extends JpaRepository<Image, Integer> {
	
	List<Image> findByNameContainingIgnoreCase(String query);
	
	List<Image> findByNameLikeIgnoreCase(String query);

}
