package com.example.family.model;

import java.util.Date;

import lombok.Data;

@Data
public class FamilyRequest {

	private String surname;
	private String name;
	private String fathername;
	private Date birthday;
	
	
}
