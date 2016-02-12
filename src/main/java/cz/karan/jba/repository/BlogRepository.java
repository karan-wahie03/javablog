package cz.karan.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.karan.jba.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
