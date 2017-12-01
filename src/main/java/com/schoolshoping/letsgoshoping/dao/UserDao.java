package com.schoolshoping.letsgoshoping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.schoolshoping.letsgoshoping.entity.User;
@Transactional
public interface UserDao extends JpaRepository<User,Long>{
	//保存
	@Override
	User save(User user);
	//更新
	@Modifying
	@Query("update User u set u.name=?1 ,u.cardid = ?2 ,u.email = ?3 ,u.nickname=?4 ,u.sex=1 u.school=?5 where u.id=?6" )
	User updateUser(String name,String cardid,String email,String nickname,String sex,int school,int id);
	//更新简介
	@Modifying
	@Query("update User u set u.introduction=?1 where u.id=?2" )
	User updateUserIntroduction(String introduction,int id);
}
