package com.example.family.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class FamilyRequest {

	private String surname;
	private String name;
	private String fathername;
	private LocalDate birthday;
	
	
}
