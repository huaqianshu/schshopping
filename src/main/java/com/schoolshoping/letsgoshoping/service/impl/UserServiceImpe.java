package com.schoolshoping.letsgoshoping.service.impl;

import java.util.Date;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolshoping.letsgoshoping.base.Result;
import com.schoolshoping.letsgoshoping.dao.UserDao;
import com.schoolshoping.letsgoshoping.service.UserService;
import com.schoolshoping.letsgoshoping.entity.User;
@Service("UserService")
public class UserServiceImpe implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public Result register(Document doc){
		User user = new User();
		user.setCardid(doc.getString("cardid"));
		user.setCreatetime(new Date());
		user.setEmail(doc.getString("email"));
		user.setIntroduction(doc.getString("introduction"));
		user.setMobile(doc.getString("mobile"));
		user.setNickname(doc.getString("nickname"));
		user.setSex(doc.getString("sex"));
		user.setSchool(doc.getInteger("school"));
		user.setPassword(doc.getString("password"));
		user =userDao.save(user);
		if(user == null){
			return new Result(-1,"success");
		}
		return new Result(0,"success");
	}
	@Override
	public Result login(Document doc) {
		User user = userDao.findByMobileAndPassword(doc.getString("mobile"), doc.getString("password"));
		if(user==null){
			return new Result(-1,"手机号或密码错误");
		}
		return new Result(0,"success");
	}

	@Override
	public Result edit(Document doc) {
		userDao.updateUser(doc.getString("name"), doc.getString("cardid"), doc.getString("email"), doc.getString("nickname"), doc.getString("sex"), doc.getInteger("school"),  doc.getInteger("id"));
		return new Result(0,"success");
	}
	@Override
	public Result changeIntroduction(String introduction,int userid){
		userDao.updateUserIntroduction(introduction, userid);
		return new Result(0,"success");
	}

}
