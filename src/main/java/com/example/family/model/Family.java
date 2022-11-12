package com.example.family.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Family {
	Long id;
	String surname;
	String name;
	String fathername;
	Date birthday;
}
