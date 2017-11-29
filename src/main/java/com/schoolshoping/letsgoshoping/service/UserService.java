package com.schoolshoping.letsgoshoping.service;

import org.bson.Document;

import com.schoolshoping.letsgoshoping.base.Result;

public interface UserService {
	//注册
	Result signIn(Document doc);
	//登录
	Result login(Document doc);
	//修改资料
	Result edit(Document doc);
}
