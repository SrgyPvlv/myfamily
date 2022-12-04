package com.example.family.resolver;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.family.model.FamilyEntity;
import com.example.family.repository.FamilyRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

	private final FamilyRepository familyRepository;
	
	public Iterable<FamilyEntity> findAllFamilies(){
		return familyRepository.findAll();
	}
	
	public Long countFamilies() {
		return familyRepository.count();
	}
	
}
