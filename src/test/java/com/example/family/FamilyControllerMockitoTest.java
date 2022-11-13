package com.example.family;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import com.example.family.controller.FamilyController;
import com.example.family.model.Family;
import com.example.family.service.FamilyService;

public class FamilyControllerMockitoTest {

	@InjectMocks
	private FamilyController familyController;
	
	@Mock
	private FamilyService familyService;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	
	@Test
	public void testGetFamilyById(){
		Family family=new Family();
		family.setId(1l);
		when(familyService.getFamilyById(1l)).thenReturn(family);
		
		Family f=familyController.getFamilyById(1l).getBody();
		
		verify(familyService).getFamilyById(1l);
		
		Assertions.assertEquals(1l,f.getId().longValue());
	}
}
