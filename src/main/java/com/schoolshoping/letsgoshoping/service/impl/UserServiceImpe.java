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
		user.setCardid(doc.getString("Cardid"));
		user.setCreatetime(new Date());
		user.setEmail(doc.getString("Email"));
		user.setIntroduction(doc.getString("Introduction"));
		user.setMobile(doc.getString("Mobile"));
		user.setNickname(doc.getString("Nickname"));
		user.setSex(doc.getString("Sex"));
		user.setSchool(doc.getInteger("School"));
		userDao.save(user);
		return new Result(0,"success");
	}
	@Override
	public Result login(Document doc) {
		// TODO Auto-generated method stub
		return null;
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
