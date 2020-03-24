public class Book {
    private String author;
    private String title;
    private String genre;

    public Book(String author, String title, String genre){
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    public String getGenre(){
        return this.genre;
    }
}
