package com.melon.sm.batch.sample;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@SuppressWarnings("serial")
public class Person implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String email;

	public Person() {

	}

}
