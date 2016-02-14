package cz.karan.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.karan.jba.entity.Blog;
import cz.karan.jba.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	
	List<Blog> findByUser(User user);

}
