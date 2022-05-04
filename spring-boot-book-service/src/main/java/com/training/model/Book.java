package com.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="books")
public class Book {
	
	@Id //primary key
	private Long isbn;
	private String title;
	private Double price;
	private Long stock;

}
