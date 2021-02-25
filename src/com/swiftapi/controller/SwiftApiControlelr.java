package com.swiftapi.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@ComponentScan("com.swiftapi.controller")
@RequestMapping("/")
@EnableWebMvc
public class SwiftApiControlelr {
	
	@GetMapping(value="/test")
	 public String testRun() {
		System.out.println(" public String testRun()");
		 return "server is running...";
	 }
}
