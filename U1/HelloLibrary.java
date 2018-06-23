/*
 * Lehrstuhl Softwaretechnologie, TU Dresden, Datei HelloLibrary.java
 *
 * HelloLibrary-Klasse implementiert eine Anwendung,
 * die die Aufnahme von B�chern simuliert
 */

public class HelloLibrary {

  // Simulation durch main()
  public static void main(String[] args) {

  // Erzeugung eines Library-Objektes
  Library meinBibliothek=new Library();

  // Erzeugung von zwei Book-Objekten
  Book buch1=new Book("Java ist eine Insel");
  Book buch2=new Book("Java ist mehr als eine Insel");
  

  // Nachricht an die Library, dass die Books aufgenommen werden sollen
  meinBibliothek.register(buch1);
  meinBibliothek.register(buch2);
  }

}