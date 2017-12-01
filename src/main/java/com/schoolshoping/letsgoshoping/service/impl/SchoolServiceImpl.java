package com.schoolshoping.letsgoshoping.service.impl;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import com.schoolshoping.letsgoshoping.base.Result;
import com.schoolshoping.letsgoshoping.dao.SchoolDao;
import com.schoolshoping.letsgoshoping.entity.School;
import com.schoolshoping.letsgoshoping.service.SchoolService;
import org.springframework.stereotype.Service;

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
}
