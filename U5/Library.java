import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.TreeMap;
// import java.util.Collections;
// import java.util.Collection;

/*
 * Lehrstuhl Softwaretechnologie, TU Dresden, Datei Library.java
 *
 * Library-Klasse implementiert eine Bibliothek,
 * die maximal 10 B�cher aufnehmen kann
 */

public class Library {

  private Set<Book> stock;

  public Library() {
    stock = new TreeSet<Book>();
    System.out.println("Hello, I am a library, which can store up to 10 books!");
  }

  public boolean insertBook(Book... newbook) {
    for (Book current : newbook) {
      if (stock.contains(current)){
        return false;
      }
      stock.add(current);
    }
    return true;
  }

  public Book searchForIsbn(String isbn) {
    // int index=Collections.binarySearch(stock, new Book(isbn));
    // if (index<0) return null;
    // return stock.get(index);
    Iterator<Book> it = stock.iterator();
    while (it.hasNext()) {
      Book value = it.next();
      if(isbn.equals(value.getIsbn())){
        return value;
      };
    }
    return null;
  }

  public HashSet<Book> searchForAuthor(String author) {
    HashSet<Book> result = new HashSet<Book>();
    for (Book current : stock) {
      if (current.getAuthor().equals(author)) {
        result.add(current);
      }
    }
    return result;
  }

  public TreeMap<String,Set<Book>> listStockByAuthor(){
    HashMap<String,Set<Book>> map =new HashMap<String,Set<Book>>();
    Iterator<Book> it = stock.iterator();
    while (it.hasNext()) {
      Book value = it.next();
      if(map.get(value.getAuthor())!=null){
        map.get(value.getAuthor()).add(value);
      }else{
        TreeSet<Book> setsInMap=new TreeSet<Book>();
        setsInMap.add(value);
        map.put(value.getAuthor(),setsInMap);
      };
    }
    return map;
  }
}