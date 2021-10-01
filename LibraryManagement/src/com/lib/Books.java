package com.lib;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Books {
    private String bookName;
    private String author;
    private String category;
    private LocalDate date;

    public Books(String bookName, String author, String category, LocalDate date) {
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.date = date;
    }

    //getters and setters
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(int week) {
        LocalDate today = LocalDate.now();
        //adding the week to the current date
        this.date = today.plus(week, ChronoUnit.WEEKS);
    }

    //Overloading method
    public void setDate(){
        this.date = null;
    }
}
