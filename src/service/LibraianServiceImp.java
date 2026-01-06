package service;

import dto.BookDTO;
import model.Book;
import repo.BookRepo;
import repo.RepoInterface;
import service.exception.InvalidException;
import service.interfaces.LibraianService;

public class LibraianServiceImp implements LibraianService {

    private static int bookIdCounter = 1;
    private final RepoInterface<Book> repo ;

    public LibraianServiceImp(){
        repo = BookRepo.getBookRepo();
    }

    @Override
    public BookDTO addBook(BookDTO req){

        if(req.getBookName().isEmpty() || req.getStock() < 0 || req.getAuthorName().isEmpty() ){
            throw new InvalidException("Invalid Inputs...(Please check...)");
        }

        Book savedBook = repo.add(new Book(bookIdCounter++, req.getBookName(), req.getAuthorName(), req.getStock()));

        return sendResponse(savedBook) ;
    }

 
    private BookDTO sendResponse(Book book){

        return new BookDTO(book.getbookName(), 
        book.getAuthor(), 
        book.getStock(),
         book.getBookId(), 
         book.isAvalible());
    }
    
}
