package cz.karan.jba.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

@Service
@Transactional
public class UserService {

	@Autowired
	private UseRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	public User findOne(int id){
		return userRepository.findOne(id);
	}
	
	@Transactional
	public User findOneWithBlog(int id) {
		User user= findOne(id);
		List<Blog> blogs= blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}
	public void save(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setEnabled(true);
		user.setPassword(encoder.encode(user.getPassword()));
		List<Role> roles= new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		userRepository.save(user);
	}
	public User findOneWithBlog(String name) {
		// TODO Auto-generated method stub
		User user = userRepository.findByName(name);
		return findOneWithBlog(user.getId());
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

		
	}
	

