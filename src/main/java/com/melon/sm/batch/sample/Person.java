package com.melon.sm.batch.sample;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
@Entity
@SuppressWarnings("serial")
public class Person implements Serializable {

	@Id
	private Integer id;
	private String name;
	private String email;

	public Person() {

	}

	public Person(int id) {
		this.id = id;
	}

}
