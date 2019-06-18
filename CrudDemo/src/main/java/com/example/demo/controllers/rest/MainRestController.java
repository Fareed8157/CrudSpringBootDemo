package com.example.demo.controllers.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.LmsService;

@RestController
public class MainRestController {

	@Autowired
	private LmsService lmsService;
	
//	@GetMapping(value="/")
//	public String hello() {
//		return "hello world";
//	}
	
	@GetMapping("/findAllBooks")
	public Collection<Book> getAllBooks(){
		return lmsService.findAllBooks();
	}
	
	@GetMapping("/delete")
	public void delete(@RequestParam long id){
		 lmsService.delete(id);
	}
	
}
