package com.schoolshoping.letsgoshoping.rest;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schoolshoping.letsgoshoping.base.Result;
import com.schoolshoping.letsgoshoping.service.UserService;
@RestController
@RequestMapping("/user")
public class UserRest {
	@Autowired
	@Qualifier("UserService")
	private UserService userService;
	@CrossOrigin(origins = "*")
	@RequestMapping(value="login",method = RequestMethod.POST)
	public Result login(@RequestParam("data")String data){
		return userService.login(Document.parse(data));
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="signup",method = RequestMethod.POST)
	public Result signup(@RequestParam("data")String data){
		Document doc = Document.parse(data);
		return userService.register(doc);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="test")
	public Result test(){
		return new Result(0,"success");
	}
}
