package service.interfaces;

import dto.TransactionDTO;

public interface BorrowerService {

    TransactionDTO borrowBook(TransactionDTO req);
    TransactionDTO viewMyTransactions(int userId);
    
}
