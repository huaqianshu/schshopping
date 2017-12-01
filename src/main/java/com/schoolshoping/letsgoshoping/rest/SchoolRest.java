package com.schoolshoping.letsgoshoping.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoolshoping.letsgoshoping.base.Result;
import com.schoolshoping.letsgoshoping.service.SchoolService;

@Controller
@RequestMapping("/school")
public class SchoolRest {
	@Autowired
	@Qualifier("SchoolService")
	private SchoolService schoolService;
	@RequestMapping(value="getSchoolId")
	public Result login(@RequestParam("name")String name){
		return schoolService.findbyName(name);
	}
}
