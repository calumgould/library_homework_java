import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    Library library;
    Book book;
    Book book2;
    Borrower borrower;

    @Before
    public void before(){
        library = new Library();
        book = new Book("Andy Weir", "The Martian", "Sci-fi");
        book2 = new Book("Erlend Loe", "Naive, Super", "Scandinavian");
        borrower = new Borrower("Callllllllum");
    }

    @Test
    public void checkCollectionStartsEmpty(){
        assertEquals(0, library.getBooks());
    }

    @Test
    public void checkCanAddBook(){
        library.addBook(book);
        assertEquals(1, library.getBooks());
    }

    @Test
    public void checkHasCapacity(){
        assertEquals(true, library.hasCapacity());
    }

    @Test
    public void checkHasNoCapacity(){
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        assertEquals(false, library.hasCapacity());
    }

    @Test
    public void checkCanBorrowBook(){
        library.addBook(book);
        library.addBook(book2);
        library.lendBook(book, borrower);
        assertEquals(1, library.getBooks());
        assertEquals(1, borrower.getCollection());
    }

    @Test
    public void checkCanCountBooksByGenre(){
        library.addBook(book);
        library.addBook(book);
        library.addBook(book2);
        library.addBook(book2);
        library.addBook(book2);
        library.countBooksByGenre();
        String genre1 = book.getGenre();
        String genre2 = book2.getGenre();
        int value1 = library.getBookGenres().get(genre1);
        int value2 = library.getBookGenres().get(genre2);
        assertEquals(2, value1);
        assertEquals(3, value2);
    }
}
