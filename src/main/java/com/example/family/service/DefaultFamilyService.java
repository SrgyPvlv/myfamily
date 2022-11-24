package com.example.family.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.family.exeption.FamilyNotFoundExeption;
import com.example.family.model.Family;
import com.example.family.model.FamilyEntity;
import com.example.family.repository.FamilyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultFamilyService implements FamilyService {
	
	private final FamilyRepository familyRepository;
	
	@Override
	public Family getFamilyById(Long id) {
		FamilyEntity familyEntity=familyRepository
				.findById(id)
				.orElseThrow(()->new FamilyNotFoundExeption("Family not found id: "+id));
		return new Family(familyEntity.getId(),
				familyEntity.getSurname(),
				familyEntity.getName(),
				familyEntity.getFathername(),
				familyEntity.getBirthday());
			
	}

	@Override
	public List<Family> getAllFamily() {
		Iterable<FamilyEntity> iterable=familyRepository.findAll();
		
		ArrayList<Family> families=new ArrayList<>();
		
		for(FamilyEntity familyEntity: iterable) {
			families.add(new Family(familyEntity.getId(),
					familyEntity.getSurname(),
					familyEntity.getName(),
					familyEntity.getFathername(),
					familyEntity.getBirthday()));				
		}
				
		return families;
	}

	@Override
	public void addFamily(Family family) {
		
		familyRepository.saveAndFlush(new FamilyEntity(null,
				family.getSurname(),
				family.getName(),
				family.getFathername(),
				family.getBirthday()));
	}

	@Override
	public void editFamily(Long id, Family family) {
		FamilyEntity familyEntity=familyRepository.findById(id)
				.orElseThrow(()->new FamilyNotFoundExeption("Family not found id: "+id));
		
				familyEntity.setSurname(family.getSurname());
				familyEntity.setName(family.getName());
				familyEntity.setFathername(family.getFathername());
				familyEntity.setBirthday(family.getBirthday());
				
				familyRepository.saveAndFlush(familyEntity);
	}

	@Override
	public void deleteFamilyById(Long Id) {
		familyRepository.deleteById(Id);
		
	}

	@Override
	public List<Family> getFamilyBySurnameContaining(String surname) {
		Iterable<FamilyEntity> iterable=familyRepository
				.findAllBySurnameContainingIgnoreCase(surname);
		
		ArrayList<Family> families=new ArrayList<>();
		
		for(FamilyEntity familyEntity: iterable) {
			families.add(new Family(familyEntity.getId(),familyEntity.getSurname(),
			familyEntity.getName(),
			familyEntity.getFathername(),
			familyEntity.getBirthday()
			));
		};
		
		return families;
	}

}
