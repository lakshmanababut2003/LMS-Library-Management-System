package service;

import java.util.*;

import dto.TransactionDTO;
import model.Book;
import model.Transaction;
import repo.BookRepo;
import repo.RepoInterface;
import repo.TransactionRepo;
import service.exception.InvalidException;
import service.interfaces.BookService;
import service.interfaces.BorrowerService;
import service.interfaces.UserService;

public class BorrowServiceImp implements BorrowerService {

    private static int idCounter = 1;
    private final BookService bookService;
    private final RepoInterface<Transaction> repo;
    private final UserService userService;

    public BorrowServiceImp(){
        bookService = new BookServiceImp();
        repo = TransactionRepo.getTransactionRepo();
        userService = new UserServiceImp();
    }

    @Override
    public TransactionDTO borrowBook(TransactionDTO req){

        if(req.getBookName().isEmpty()){
            throw new InvalidException("Invalid Input fields...");
        }

        try{
            Book book = bookService.findByBookName(req.getBookName());
            book.setStock(book.getStock()-1);

            Transaction transaction = repo.add(new Transaction(
                idCounter++,
                 userService.getIdByUserName(req.getUserName()).getId(),
                  book.getBookId(), 
                  req.getBorrowDate())
                );

            return new TransactionDTO(transaction.getId(),req.getBookName(), req.getUserName(),transaction.getBorrowDate() , transaction.getDueDate(), transaction.getStatus());

        }
        catch(InvalidException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    public TransactionDTO viewMyTransactions(int userId){

        List<TransactionDTO> myTransactions = new ArrayList<>();

        for(Transaction transaction : repo.getAll()){

            // myTransactions.add(new TransactionDTO(transaction.getId(), , null, null, null, null));
        }

        return null;
    }

    // private TransactionDTO sendRes(Transaction tra)
    
}
