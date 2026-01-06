package service;

import java.util.ArrayList;
import java.util.List;

import dto.BookDTO;
import model.Book;
import repo.BookRepo;
import repo.RepoInterface;
import service.exception.InvalidException;
import service.interfaces.BookService;
import service.interfaces.ViewService;

public class BookServiceImp implements ViewService<BookDTO> , BookService {

    private final RepoInterface<Book> repo;

    public BookServiceImp() {
        repo = BookRepo.getBookRepo();
    }

    @Override
    public List<BookDTO> viewAll() {

        List<BookDTO> books = new ArrayList<>();

        if (repo.getAll().isEmpty()) {
            return null;
        }

        for (Book book : repo.getAll()) {
            books.add(sendResponse(book));
        }

        return books;
    }

    public Book findByBookName(String bookName){

        List<Book> books = repo.getAll();

        if (repo.getAll().isEmpty()) {
            return null;
        }

        for(Book book : books){
            if(book.getbookName().equals(bookName)){
                return book;
            }
        }

        throw new InvalidException("Book Name Doesnot exits");

    }

    public String findById(int id){

        Book book = repo.getById(id);

        if(book == null){
            throw new InvalidException("Invalid Id...");
        }

        return book.getbookName();
    }



    private BookDTO sendResponse(Book book) {

        return new BookDTO(book.getbookName(),
                book.getAuthor(),
                book.getStock(),
                book.getBookId(),
                book.isAvalible());
    }

}
