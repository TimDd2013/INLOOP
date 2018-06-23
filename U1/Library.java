/*
 * Lehrstuhl Softwaretechnologie, TU Dresden, Datei Library.java
 *
 * Library-Klasse implementiert eine Bibliothek,
 * die maximal 10 B�cher aufnehmen kann
 */

 public class Library {

    private Book [] myBooks;

    private int number;

    public Library() {
 	   myBooks = new Book[10];
        number = 0;
        System.out.println("Hello, I am a library, which can store up to 10 books!");
        }

    public void register(Book book) {
        myBooks[number] = book;
        number += 1;
        System.out.println("A new book is registered: " + book);
     }
     public void add(Book book) {
        if (number>=10){
            System.out.println("The library is full!");    
            return;
        }
        myBooks[number] = book;
        number += 1;
        System.out.println("I added the book " + book+"!");
     }
     public Book search(String title){
         for (int i=0;i<number;i++){
             if (myBooks[i].toString().equals(title)){
                 System.out.println("The book with the title "+title+" exists in the library!");
                return myBooks[i];
             }
         }
         System.out.println("The book with the title "+title+" does not exist in the library!");
         return null;
     }
     public void loan(String title){
         if (search(title)!=null){
             search(title).setState(true);
         };
         return;
     }
}