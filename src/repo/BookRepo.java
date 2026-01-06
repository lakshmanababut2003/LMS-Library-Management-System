package repo;

import java.util.*;

import model.Book;

public class BookRepo implements RepoInterface<Book> {

    private static BookRepo bookRepo;

    private BookRepo(){}

    public static BookRepo getBookRepo(){

        if(bookRepo == null){
            bookRepo = new BookRepo();
        }

        return bookRepo;
    }

    private final Map<Integer , Book> books = new HashMap<>();

    @Override
    public Book add(Book book){
         books.put(book.getBookId(),book);
         return books.get(book.getBookId());
    }

    @Override
    public List<Book> getAll(){

        return new ArrayList<>(books.values());
    }

    @Override
    public Book update(Book book){
        return this.add(book);
    }

    @Override
    public Book getById(int id){

        return books.get(id);
    }
    
}
