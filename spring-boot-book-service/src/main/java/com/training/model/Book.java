package com.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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
	
	@NotBlank(message="title cannot be blank")
	private String title;
	private Double price;
	
	@Min(value = 100,message="min stock has to be 100")
	@Max(value = 200,message="max stock has to be 200")
	private Long stock;

}
