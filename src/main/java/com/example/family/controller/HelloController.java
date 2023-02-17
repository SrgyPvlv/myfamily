package com.example.family.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//test

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello(@RequestParam(name="name",required=false) String name) {
		return "Привет," + name+"!";
	}
	
}
