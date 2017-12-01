package com.schoolshoping.letsgoshoping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolshoping.letsgoshoping.entity.School;
import com.schoolshoping.letsgoshoping.entity.User;

public interface SchoolDao extends JpaRepository<School,Long>{
	School findByName(String name);
}
