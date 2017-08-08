package com.Controller;




import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.Model.User;
import com.Service.UserService;
import com.Validator.UserValidator;
@Controller
public class UserController {
	@Autowired
	private UserValidator userValidator;
	private UserService userService;
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
    

	public UserValidator getUserValidator() {
		return userValidator;
	}


	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}


	@RequestMapping("/register")
	public ModelAndView regi(@ModelAttribute("user")User user)
	{	
		HashMap<String, Object> model = new HashMap<>();
		model.put("user", new User());
		System.out.println("register");
		
		return new ModelAndView("register",model);
		
	}
	@RequestMapping(value="/logout")
	public String GetLogout(){
		System.out.println("/ Hello method");
		return "logout";
	}
	@RequestMapping(value="/login")
	public String GetRelogin(Map<String,Object> map){
		User user = new User();
		map.put("user",user);
		System.out.println("/ method");
		return "login";
	}
	
	@RequestMapping(value="/")
	public String GetFront(Map<String,Object> map){
		User user = new User();
		map.put("user",user);
		System.out.println("/ method");
		return "login";
	}
	@RequestMapping(value = "/relogin", method = RequestMethod.GET)
    public String Front2(Model model) {
    	model.addAttribute("error", "Error:UserName or Password is incorrect..!");
    	return "login";
	}
    @RequestMapping(value="/authenticate",method=RequestMethod.POST)
	 public String authenticate(@RequestParam("uname")String userName,@RequestParam("pass")String userPassword,
	    		HttpSession session,HttpServletRequest request,Model model){
			System.out.println("authenticate");
	    	boolean success = userService.validate(userName,userPassword);
	    	if(!success){
	    	
				return "redirect:/relogin";
	    	}
	    	
	    	
	    	if(success){
	    		String s=userName;
	    		model.addAttribute("msg",s);
	    		return "Hello";
	    	}
			
	    	
	    	return "redirect:/";
	    }
	 @RequestMapping(value = "/add", method = RequestMethod.POST)
	 public String submitForm(@ModelAttribute("user") User user,
				BindingResult result, SessionStatus status) 
      {
         System.out.println("addNewaddNewaddNew");

         userValidator.validate(user, result);

       if (result.hasErrors()) {
        return "register";
        }
       else
       {
		  userService.save(user);
	  
		   status.setComplete();
			return "redirect:/";
       }
		 
	    }
    }