package com.schoolshoping.letsgoshoping.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the school database table.
 * 
 */
@Entity
@Table(name="school")
@NamedQuery(name="School.findAll", query="SELECT s FROM School s")
public class School implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	public School() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}