import java.util.ArrayList;

public class Borrower {

    private String name;
    private ArrayList<Book> borrowedCollection;

    public Borrower(String name){
        this.name = name;
        this.borrowedCollection = new ArrayList<Book>();
    }

    public void getBook(Book book){
        this.borrowedCollection.add(book);
    }

    public void returnBook(Book book){
        this.borrowedCollection.remove(book);
    }


    public int getCollection() {
        return this.borrowedCollection.size();
    }
}
