package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity(name="lms_tbl")
@Data
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="book_name")
	private String bookName;
	
	private String author;
	
	@Column(name="purchase_date")
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;
	
}
