package cz.karan.jba.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.karan.jba.entity.Blog;
import cz.karan.jba.entity.Item;
import cz.karan.jba.entity.Role;
import cz.karan.jba.entity.User;
import cz.karan.jba.repository.BlogRepository;
import cz.karan.jba.repository.ItemRepository;
import cz.karan.jba.repository.RoleRepository;
import cz.karan.jba.repository.UseRepository;
import cz.karan.jba.repository.UseRepository;

@Transactional
@Service
public class InitDBService1 {

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	UseRepository userRepositiry;
	
	@PostConstruct
	public void init(){
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		
		User userAdmin = new User();
		userAdmin.setName("USER");
		List<Role> roles= new ArrayList<Role>();
		roles.add(roleAdmin);
		userAdmin.setRoles(roles);
		userRepositiry.save(userAdmin);
		
		Blog blogJavaVids = new Blog();
		blogJavaVids.setName("Java Vids");
		blogJavaVids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogJavaVids.setUser(userAdmin);
		blogRepository.save(blogJavaVids);
		
		Item item1 = new Item();
		item1.setBlog(blogJavaVids);
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com");
		item1.setPublioshedDate(new Date());
		

		Item item2 = new Item();
		item2.setBlog(blogJavaVids);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setPublioshedDate(new Date());
		
	}
}
