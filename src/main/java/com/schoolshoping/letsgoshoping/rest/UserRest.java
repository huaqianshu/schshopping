package com.schoolshoping.letsgoshoping.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoolshoping.letsgoshoping.base.Result;

@Controller
@RequestMapping("/user")
public class UserRest {
	public Result login(@RequestParam("data")String data){
		return null;
	}
}
