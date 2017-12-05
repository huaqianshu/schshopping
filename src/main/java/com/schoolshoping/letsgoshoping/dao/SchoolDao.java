package com.schoolshoping.letsgoshoping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.schoolshoping.letsgoshoping.entity.School;
import com.schoolshoping.letsgoshoping.entity.User;
@Transactional
public interface SchoolDao extends JpaRepository<School,Long>{
	School findByName(String name);
	List<School> findAll();
}
