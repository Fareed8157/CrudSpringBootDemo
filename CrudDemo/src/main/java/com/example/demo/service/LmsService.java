package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LmsRepository;
import com.example.demo.model.Book;

@Service
public class LmsService {

	@Autowired
	private LmsRepository repository;
	
	
	public Collection<Book> findAllBooks(){
		List<Book> books=new ArrayList<Book>();
		repository.findAll()
		.forEach(books::add);
		return books;
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}

	public Book findOne(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	public void save(Book book) {
		// TODO Auto-generated method stub
		repository.save(book);
	}
}
