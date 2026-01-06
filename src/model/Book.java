package model;

public class Book {

    private int  bookId;
    private String bookName;
    private String author;
    private int stock;
    private boolean isAvalible;

    public Book(int bookId , String bookName , String author , int stock ){

        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.stock = stock;
        this.isAvalible = true;
    }

    public int getBookId(){
        return bookId;
    }

    public String getbookName(){
        return bookName;
    }

    public String getAuthor(){
        return author;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }


    public void setIsAvalible(boolean isAvalible){
        this.isAvalible = isAvalible;
    }

    public boolean isAvalible(){
        return isAvalible;
    }

    
}
