import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> collection;
    private int capacity;
    private HashMap<String, Integer> bookGenres;

    public Library() {
        this.capacity = 5;
        this.collection = new ArrayList<Book>();
        this.bookGenres = new HashMap<String, Integer>();
    }

    public int getBooks() {
        return this.collection.size();
    }

    public boolean hasCapacity() {
        return this.capacity > 0;
    }

    public HashMap<String, Integer> getBookGenres() {
        return this.bookGenres;
    }

    public void addBook(Book book) {
        if (hasCapacity()) {
            this.collection.add(book);
            this.capacity -= 1;
        }
    }

    public void lendBook(Book book, Borrower borrower) {
        this.collection.remove(book);
        borrower.getBook(book);
    }

    public Object countBooksByGenre() {
        for (int i = 0; i < getBooks(); i++) {
            String genre = this.collection.get(i).getGenre();
            if (this.bookGenres.containsKey(genre)) {
                int value = bookGenres.get(genre);
                this.bookGenres.remove(genre);
                this.bookGenres.put(genre, (value + 1));
            } else {
                this.bookGenres.put(genre, 1);
            }
        }
        return this.bookGenres;
    }
}
