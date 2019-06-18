package com.example.demo.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Book;
import com.example.demo.service.LmsService;

@Controller
public class MainController {

	@Autowired
	private LmsService lmsService;
	
	@GetMapping("/")
	public String init(ModelMap model) {
		model.addAttribute("books",lmsService.findAllBooks());
		model.addAttribute("mode", "BOOK_VIEW");
		return "index";
	}
	
	
	@GetMapping("/updateBook")
	public String init(@RequestParam long id, ModelMap model, HttpServletRequest req) {
		model.addAttribute("book",lmsService.findOne(id));
		model.addAttribute("mode", "BOOK_EDIT");
		return "index";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class,"purchaseDate", new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"),false));
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Book book,BindingResult error) {
		System.out.println(book.getPurchaseDate());
		lmsService.save(book);
		
		return "redirect:/";
	}
	
	@GetMapping("/newBook")
	public String newBook(ModelMap model) {
		model.addAttribute("mode", "BOOK_NEW");
		return "index";
	}
	
	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam long id,ModelMap model) {
		lmsService.delete(id);
		model.addAttribute("mode", "BOOK_VIEW");
		return "index";
	}
	
	
//	@GetMapping("/findAllBooks")
//	public Collection<Book> getAllBooks(){
//		return lmsService.findAllBooks();
//	}
}
