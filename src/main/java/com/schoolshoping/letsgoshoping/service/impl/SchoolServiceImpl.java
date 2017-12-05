package com.schoolshoping.letsgoshoping.service.impl;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.schoolshoping.letsgoshoping.base.Result;
import com.schoolshoping.letsgoshoping.dao.SchoolDao;
import com.schoolshoping.letsgoshoping.entity.School;
import com.schoolshoping.letsgoshoping.service.SchoolService;
import org.springframework.stereotype.Service;
@Configuration
@Service("SchoolService")
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolDao schoolDao;
	@Override
	public Result findbyName(String name){
		School school = schoolDao.findByName(name);
		Result res = new Result(0,"success");
		res.setData(new Document("schoolid",school.getId()));
		return res;
	}
	@Override
	public Result findAll() {
		List<School> list = schoolDao.findAll();
		Result res=new Result(0,"success");
		res.set("schools", list);
		return res;
	}
}
