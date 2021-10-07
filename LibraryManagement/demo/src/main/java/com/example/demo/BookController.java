package com.example.demo;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BookController {
	private final BookRepository bookRepo;
	
	public BookController(BookRepository br) {
		this.bookRepo = br;
	}
	
	//Get a book
	@GetMapping(path="/{id}")
	public @ResponseBody Optional<Book> getBookById(@PathVariable(name = "id") Integer id) {
		return bookRepo.findById(id);
	}
	
	//Get all books
	@GetMapping(path="/all")
	public Iterable<Book> getBooks() {
		return bookRepo.findAll();
	}
	
	@PostMapping(path="/add") 
	@ResponseStatus(HttpStatus.CREATED)
	public Book createBook(@RequestBody Book b) {
		return bookRepo.save(b);
	}
}
