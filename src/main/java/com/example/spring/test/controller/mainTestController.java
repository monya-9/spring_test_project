package com.example.spring.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class mainTestController {	
	@GetMapping("/hello")
	public String hello() {
		return "/hello";
	}
	
	@GetMapping("/test")
	public String test() {
		return "user/test";
	}
	
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "user/modify";
	}
	
	@GetMapping("/list")
	public String list() {
		return "user/list";
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "user/list";
	}
	
}
