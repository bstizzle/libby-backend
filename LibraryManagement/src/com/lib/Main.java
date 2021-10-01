package com.lib;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public List<Books> booksList; //maybe use a queue instead
    public static void main(String[] args) {
	// write your code here
        System.out.println("Greetings...");

        Scanner reader = new Scanner(System.in);
        System.out.println("Please create your account");
        System.out.print("Username: ");
        String user = reader.nextLine();
        System.out.print("Password: ");
        String pass = reader.nextLine();


        Account newAccount = new Account(user,pass);
        System.out.println("Registered!");

        //Adding books into a mock database
        HashMap<Integer, Books> bookMap = new HashMap<>();
        bookMap.put(1, new Books("Bizarre Adventures" ,"Bk", "Sci-Fi", null));
        bookMap.put(2, new Books("1984", "George Orwell", "Dystopian", null));
        bookMap.put(3, new Books("Life of Pi" ,"Yann Martel", "Drama", null));
        bookMap.put(4, new Books("Fahrenheit 451", "Ray Bradbury", "Fiction", null));

        //Ask user what they want to do....
        //Display to the user the available books to choose from
        System.out.println("You now have the option to select a book to hold onto.");
        System.out.println("Here is a list of the available books to choose form...");
        for(Map.Entry<Integer, Books> entry : bookMap.entrySet()){
            System.out.println("Book Number: #"+ entry.getKey() + " ... Book name: " + entry.getValue().getBookName() +
                    ", Author: " + entry.getValue().getAuthor() + ", Category: " + entry.getValue().getCategory());
        }

        
        //added exception handling code
        boolean valid = false;
        do {
        	 //Next they can select the book to hold onto, set a due date...
            System.out.print("\n Choose which book you would like to check out by entering the book number: ");
            int bookNum = reader.nextInt();
            
        	try {
                //find the book using bookNum, set the due date, and then remove the book from library
        		Books newBook = bookMap.get(bookNum);
        		newBook.setDate(1);
        		newAccount.addBookToList(bookNum, newBook);
        		bookMap.remove(bookNum);
        		valid = true;
        	}
        
        	catch (NullPointerException e){
        		System.out.println("Invalid book, try again.");
        		valid = false;
        	}
        } while(!valid);
        

        //checking if the borrowing of book works correctly
        System.out.println("Checking the library: " + bookMap);
        newAccount.getBooksList();

       
        
        valid = false;
        while(!valid) {
        	
        	 //getting user input
            System.out.print("Enter 1 if you want to return a book, 0 if you are finished.");
            int returning = reader.nextInt();
            
        	switch(returning){
            	case 0:
            		System.out.println("All done.");
            		valid = true;
            		
            		break;
            	case 1:
            		//return the book
            		System.out.println("--Returning Book--");
            		System.out.println("Here is a list of available books you can return.");
            		newAccount.getBooksList();

            		//needs to select which book user wants to return. so that's why bookList needs to be a map
            		System.out.print("\n Choose which book you would like to return by entering the book number: ");
            		int returnNum = reader.nextInt();
            		Books returnBook = newAccount.booksList.get(returnNum);
            		returnBook.setDate();
            		bookMap.put(returnNum, returnBook);
            		newAccount.booksList.remove(returnNum);
            		valid = true;
            		
            		break;
            	default:
            		System.out.println("Please enter a valid number");
            		valid = false;
            		continue;

        	}
        }
        
        //Checking if returning the book works correctly
        System.out.println("Checking the library: " + bookMap);
        newAccount.getBooksList();
        reader.close();
    }
}