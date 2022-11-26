package com.example.family.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.family.model.FamilyEntity;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyEntity, Long> {
	
	@Query(value="select * from family where lower(surname) like concat('%',:surnamename,'%')"
			+ " or lower(name) like concat('%',:surnamename,'%')",nativeQuery=true)
	public List<FamilyEntity> findAllBySurNameOrName(@Param("surnamename") String surnameOrName);

}
