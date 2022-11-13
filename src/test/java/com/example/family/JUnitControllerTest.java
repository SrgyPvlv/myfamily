package com.example.family;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.example.family.controller.HelloController;

public class JUnitControllerTest {

	@Test
	public void helloControllerTest() {
		String name="Sergey";
		HelloController helloController=new HelloController();
		String result=helloController.hello(name);
		Assertions.assertEquals(result,"Привет,Sergey!");
	}
}
