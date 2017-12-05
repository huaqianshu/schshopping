package com.schoolshoping.letsgoshoping.service;
import com.schoolshoping.letsgoshoping.base.Result;
public interface SchoolService {
	Result findbyName(String name);
	Result findAll();
}
