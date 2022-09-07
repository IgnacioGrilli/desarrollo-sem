package com.desarrollo.sem.servlet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiServlet {

    @RequestMapping(value = "/")
	public String hello() {
		return "Hello World";
	}

}