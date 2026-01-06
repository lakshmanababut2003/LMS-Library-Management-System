package dto;

public class BookDTO {

    private int bookId;
    private String bookName;
    private String authorName;
    private int stock;
    private boolean isAvalible;

    public BookDTO(String bookName , String authorName , int stock){
        this.bookName = bookName;
        this.authorName = authorName;
        this.stock = stock;
    }

    public BookDTO(String bookName , String authorName , int stock , int bookId , boolean isAvalible){
        this(bookName, authorName, stock);
        this.bookId = bookId;
        this.isAvalible = isAvalible;
    }

    public int getBookId(){
        return bookId;
    }

    public String getBookName(){
        return bookName;
    }

    public String getAuthorName(){
        return authorName;
    }

    public int getStock(){
        return stock;
    }

    public boolean isAvalible(){
        return isAvalible;
    }
    
}
