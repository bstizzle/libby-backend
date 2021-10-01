package com.lib;

import java.util.HashMap;
import java.util.Map;

public class Account {
    private String username;
    private String password;
    protected HashMap<Integer, Books> booksList;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.booksList = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void getBooksList() {
        System.out.println("Books in current users hold: ");
        for(Map.Entry<Integer, Books> entry: booksList.entrySet()){
            System.out.println("Book Number: #"+ entry.getKey() + " ... Book name: " + entry.getValue().getBookName() +
                    ", Author: " + entry.getValue().getAuthor() + ", Category: " + entry.getValue().getCategory() +
                    ", Due Date: " + entry.getValue().getDate());
        }
    }

    public void addBookToList(int bookNum, Books newBook) {
        this.booksList.put(bookNum, newBook);
    }
}
