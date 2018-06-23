import java.lang.Comparable;

public class Book implements Comparable<Book> {

    private String title;
    private String author;
    private String isbn;

    public Book(String isbn, String author, String title) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        System.out.println("Book " + title + " created.");
    }

    public Book(String isbn) {
        this.isbn = isbn;
        this.author = "";
        this.title = "";
        System.out.println("Book " + title + " created.");
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return this.author;
    }

    public String toString() {
        return title;
    }

    public int compareTo(Book o) {
        return this.isbn.compareTo(o.isbn);
    }
}
