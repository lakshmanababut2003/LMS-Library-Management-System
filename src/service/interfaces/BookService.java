package service.interfaces;

import model.Book;

public interface BookService {

    Book findByBookName(String bookName);
    
}
