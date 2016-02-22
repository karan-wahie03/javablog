package cz.karan.jba.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.karan.jba.entity.Blog;
import cz.karan.jba.entity.User;
import cz.karan.jba.service.BlogService;
import cz.karan.jba.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	@ModelAttribute("user")
	public User constructUser(){
		return new User();
	}
	
	
	@ModelAttribute("blog")
	public Blog constructBlog(){
		return new Blog();
	}
	
	
	
	
	@RequestMapping("/users")
	public String users(Model model){
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	@RequestMapping("/users/{id}")
	public String details (Model model, @PathVariable int id){
		model.addAttribute("user", userService.findOneWithBlog(id));
		return "user-detail";
	}
	
	@RequestMapping("/register")
	public String showRegistrer()
	{
		return"user-register";
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegistrer(@Valid @ModelAttribute("user") User user, BindingResult result)
	{
		if(result.hasErrors()){
			return "user-register";
		}
		userService.save(user);
		return"redirect:/register.html?success=true";
	}
	@RequestMapping
	public String account( Model model, Principal principal){
		String name= principal.getName();
		model.addAttribute("user", userService.findOneWithBlog(name));
		return "user-detail";
	}
	
	
	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String doAddBlog(Model model ,@Valid @ModelAttribute("blog") Blog blog, BindingResult result, Principal principle){
		if(result.hasErrors()){
			return account(model,principle);
		}
		String name= principle.getName();
		blogService.save(blog,name);
		return"redirect:/account.html";
	}
	
	
	@RequestMapping("blog/remove/{id}")
	public String removeBlog(@PathVariable int id){
		Blog blog= blogService.find(id);
		blogService.delete(blog);
		return "redirect:/account.html";
	}
	
	
	
	@RequestMapping("users/remove/{id}")
	public String removeUser(@PathVariable int id){
		userService.delete(id);
		return "redirect:/users.html";
	}
	
	
	@RequestMapping("/available")
	public String available(@RequestParam String name){
		Boolean available= userService.findOneWithName(name)==null;
		return available.toString();
	}
}
