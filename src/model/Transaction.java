package model;

import java.time.LocalDate;
import java.util.Date;

import model.enums.TransactionStatus;

public class Transaction {

    private int id;
    private int userId;
    private int bookId;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private TransactionStatus status;
    private double fineAmount;

    public Transaction(int id , int userId , int bookId , LocalDate borrowDate){
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.dueDate = this.borrowDate.plusDays(20);
        this.status = TransactionStatus.NotReturned;
    }

    public int getId(){
        return id;
    }

    public int getUserId(){
        return userId;
    }
    
    public int getBookId(){
        return bookId;
    }

    public LocalDate getBorrowDate(){
        return borrowDate;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public LocalDate getReturnDate(){
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate){
        this.returnDate = returnDate;
    }

    public void setStatus(TransactionStatus status){
        this.status = status;
    }

    public String getStatus(){
        return status.name();
    }

    public void setFineAmount(double amount){
        this.fineAmount = amount;
    }

    public double getFineAmount(){
        return fineAmount;
    }


}
