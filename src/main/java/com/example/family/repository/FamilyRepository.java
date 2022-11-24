package com.example.family.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.family.model.FamilyEntity;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyEntity, Long> {
	
	List<FamilyEntity> findAllBySurnameContainingIgnoreCase(String surname);

}
