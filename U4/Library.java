import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Collection;

/*
 * Lehrstuhl Softwaretechnologie, TU Dresden, Datei Library.java
 *
 * Library-Klasse implementiert eine Bibliothek,
 * die maximal 10 B�cher aufnehmen kann
 */

 public class Library {

    private List<Book> stock;
    public Library() {
 	    stock = new ArrayList<Book>();
        System.out.println("Hello, I am a library, which can store up to 10 books!");
        }

    public void sortedInsertion(Book... newbook) {
        for(Book current:newbook){
            stock.add(current);
            System.out.println("A new book is registered: " + current);
        }
        Collections.sort(stock);
     }
     
     public Book searchForIsbn(String isbn){
        int index=Collections.binarySearch(stock, new Book(isbn));
        if (index<0) return null;
        return stock.get(index);
     }
     public ArrayList<Book> searchForAuthor(String author) {
        ArrayList<Book> result=new ArrayList<Book>(); 
        for(Book current:stock){
             if (current.getAuthor().equals(author)){
                 result.add(current);
             }
         }
         return result;
     }
}