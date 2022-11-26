package com.example.family.service;

import java.util.List;

import com.example.family.model.Family;

public interface FamilyService {
Family getFamilyById(Long id);
List<Family> getAllFamily();
void addFamily(Family family);
void editFamily(Long id, Family family);
void deleteFamilyById(Long Id);
List<Family> findAllBySurNameOrName(String surnameOrName);
}
