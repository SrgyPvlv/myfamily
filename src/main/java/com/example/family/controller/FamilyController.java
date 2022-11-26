package com.example.family.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.family.model.Family;
import com.example.family.model.FamilyRequest;
import com.example.family.service.FamilyService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FamilyController {
	
	private final FamilyService familyService;
	
	@GetMapping("/family/{id}")
	public ResponseEntity<Family> getFamilyById(@PathVariable Long id) {
		
		try {
		return new ResponseEntity<>(familyService.getFamilyById(id),HttpStatus.OK);
		}catch(Exception e) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	/*@GetMapping("/family")
	public ResponseEntity<List<Family>> getAllFamily(){
		
		try {
		return new ResponseEntity<>(familyService.getAllFamily(),HttpStatus.OK);
		} catch(Exception e) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}*/
	
	@GetMapping("/family")
	public ResponseEntity<List<Family>> findAllBySurnameOrName(@RequestParam(required=false) String surnameorname){
		
			if(surnameorname != null)
				{try {
					return new ResponseEntity<>(familyService.findAllBySurNameOrName(surnameorname),HttpStatus.OK);
					} catch(Exception e) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}}
			
			else {try {
				return new ResponseEntity<>(familyService.getAllFamily(),HttpStatus.OK);
				} catch(Exception e) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}}
	}
	
	@PostMapping("/family")
	public ResponseEntity<HttpStatus> addFamily(@RequestBody FamilyRequest familyRequest) {
		
		try {
		Family family=new Family(null,
				familyRequest.getSurname(),
				familyRequest.getName(),
				familyRequest.getFathername(),
				familyRequest.getBirthday());
		familyService.addFamily(family);

		return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/family/{id}")
	public ResponseEntity<Family> editFamily(@PathVariable Long id, @RequestBody FamilyRequest familyRequest) {
		
		try {
			Family family=familyService.getFamilyById(id);
				family.setSurname(familyRequest.getSurname());
				family.setName(familyRequest.getName());
				family.setFathername(familyRequest.getFathername());
				family.setBirthday(familyRequest.getBirthday());
		familyService.editFamily(id, family);
		return new ResponseEntity<>(family,HttpStatus.OK);
		} catch (Exception e) {return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);}
	}
	
	@DeleteMapping("/family/{id}")
	public ResponseEntity<HttpStatus> deleteFamilyById(@PathVariable Long id) {
		
		try {
		familyService.deleteFamilyById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}

}
