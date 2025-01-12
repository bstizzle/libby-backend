package com.example.demo;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("https://libmansys.azurewebsites.net/")
@RequestMapping
public class BookController {
	private final BookRepository bookRepo;
	
	public BookController(BookRepository br) {
		this.bookRepo = br;
	}
	
	//Get a book
	@GetMapping(path="/books/{id}")
	public @ResponseBody Optional<Book> getBookById(@PathVariable(name = "id") Integer id) {
		return bookRepo.findById(id);
	}
	
	//Get all books
	@GetMapping(path="/books")
	public Iterable<Book> getBooks() {
		return bookRepo.findAll();
	}
	
	@PostMapping(path="/books") 
	@ResponseStatus(HttpStatus.CREATED)
	public Book createBook(@RequestBody Book b) {
		return bookRepo.save(b);
	}
}
