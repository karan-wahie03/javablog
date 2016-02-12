package cz.karan.jba.service;

import java.util.List;

import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.karan.jba.entity.User;
import cz.karan.jba.repository.UseRepository;

@Service
public class UserService {

	@Autowired
	private UseRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
}
