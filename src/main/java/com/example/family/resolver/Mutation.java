package com.example.family.resolver;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.family.exeption.FamilyNotFoundExeption;
import com.example.family.model.FamilyEntity;
import com.example.family.repository.FamilyRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

	private final FamilyRepository familyRepository;
	
	public FamilyEntity createFamily(String surname, String name, String fathername, LocalDate birthday) {
		FamilyEntity family=new FamilyEntity();
		family.setSurname(surname);
		family.setName(name);
		family.setFathername(fathername);
		family.setBirthday(birthday);
		
		familyRepository.saveAndFlush(family);
		
		return family;
	}
	
	public FamilyEntity updateFamily(Long id, String surname, String name, String fathername, LocalDate birthday){
		
		FamilyEntity family=familyRepository.findById(id).orElseThrow(()->new FamilyNotFoundExeption("Not found FamilyEntity to update!"));
		
		family.setSurname(surname);
		family.setName(name);
		family.setFathername(fathername);
		family.setBirthday(birthday);
		
		familyRepository.saveAndFlush(family);
		
		return family;
	}
	
	public boolean deleteFamily(Long id) {
		familyRepository.deleteById(id);
		
		return true;
	}
}
