package com.example.demo;

import org.springframework.data.annotation.Id;

public class Book {
	
	@Id
	private int id;
	
	private String title;
	private String author;
	private String summary;
	private String isbn;
	private boolean isCheckedOut;
	
	public Book() {}
	
	public Book(String title, String author, String summary, String isbn, boolean isCheckedOut) {
		this.title = title;
		this.author = author;
		this.summary = summary;
		this.isbn = isbn;
		this.isCheckedOut = isCheckedOut;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isCheckedOut() {
		return isCheckedOut;
	}

	public void setCheckedOut(boolean isCheckedOut) {
		this.isCheckedOut = isCheckedOut;
	}
	
	
}
