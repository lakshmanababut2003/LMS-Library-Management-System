package dto;

import java.time.LocalDate;

public class TransactionDTO {

    private int id;
    private String bookName;
    private String userName;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fineAmount;
    private String status;

    public TransactionDTO(String bookName , LocalDate borrowDate , String  userName){
        this.bookName = bookName;
        this.borrowDate = borrowDate;
        this.userName = userName;
    }

    public TransactionDTO(int id ,String bookName , String userName , LocalDate borrowDate , LocalDate dueDate , String status){
        this(bookName, borrowDate , userName);
        this.id = id;
        this.dueDate = dueDate;
        this.status = status;
    }

    public TransactionDTO(int id ,String bookName , String userName , LocalDate borrowDate , LocalDate dueDate , String status , LocalDate returnDate , double fineAmount){
        this(id , bookName, userName , borrowDate, dueDate, status);
        this.returnDate = returnDate;
        this.fineAmount = fineAmount;
    }

    public int getId(){
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getUserName(){
        return userName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public String getStatus() {
        return status;
    }

    
    
}
