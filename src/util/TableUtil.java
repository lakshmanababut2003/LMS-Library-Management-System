package util;

import java.util.List;

import dto.BookDTO;
import dto.TransactionDTO;
import dto.UserDTO;

public class TableUtil {

    private static TableUtil instance;

    private TableUtil(){}

    public static TableUtil getPrint(){

        if(instance == null){
            instance = new TableUtil();
        }

        return instance;
    }

       public void displayBookRecord(BookDTO book) {

        if (book == null) {
            System.out.println("Empty...");
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(
                String.format("%-10s | %-20s | %-20s | %-10s | %-10s\n", "Book Id" ,"Book Name", "Author Name", "Stock", "Is Availbale"));
        sb.append("-----------------------------------------------------------------------------------\n");
        sb.append(String.format("-%10s | %-20s | %-20s | %-10s | %-10s\n",book.getBookId(), book.getBookName(), book.getAuthorName(),
                book.getStock(), book.isAvalible()));

        System.out.println(sb);
    }

    public void displayBookTable(List<BookDTO> books){

        if(books.isEmpty()){
            System.out.println("No more records found...");
            return;
        }

        StringBuilder sb = new StringBuilder();
        
        sb.append(
                String.format("%-10s | %-20s | %-20s | %-10s | %-10s\n", "Book Id","Book Name", "Author Name", "Stock", "Is Availbale"));
        sb.append("----------------------------------------------------------------------------------\n");

        for(BookDTO book : books){
              sb.append(String.format("%-10s | %-20s | %-20s | %-10s | %-10s\n",book.getBookId() , book.getBookName(), book.getAuthorName(),
                book.getStock(), book.isAvalible()));
        }

        System.out.println(sb);

    }

    public void displayUserRecord(UserDTO user){

        if(user == null){
            System.out.println("Empty");
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-15s | %-15s | %-15s\n" , "UserName" , "Phone" , "Status"));
        sb.append("-----------------------------------------------\n");
        sb.append(String.format("%-15s | %-15s | %-15s\n" , user.getUserName() , user.getPhone() , user.getStatus()));

        System.out.println(sb);
    }

    public void displayUserTable(List<UserDTO> users){

        if(users.isEmpty()){
            System.out.println("No more Records...");
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-15s | %-15s | %-15s\n" , "UserName" , "Phone" , "Status"));
        sb.append("-----------------------------------------------\n");

        for(UserDTO user : users){
            sb.append(String.format("%-15s | %-15s | %-15s\n" , user.getUserName() , user.getPhone() , user.getStatus())); 
        }

        System.out.println(sb);
    }

    public void displayTransactionRecord(TransactionDTO trans){

        if(trans == null){
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-10s | %-15s | %-15s | %-15s | %-10s\n", "Trans Id" , "Book Name" , "Borrow Date" , "Due Date" , "Status"));

        sb.append("-----------------------------------------------------\n");

        sb.append(String.format("%-10s | %-15s | %-15s | %-15s | %-10s\n", trans.getId() , trans.getBookName() , trans.getBorrowDate() , trans.getDueDate() , trans.getStatus()));

        System.out.println(sb);
    }

    public void displayTransctionTable(List<TransactionDTO> transactions){

        if(transactions.isEmpty()){
            System.out.println("No more Records...");
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-10s | %-15s | %-15s | %-15s | %-10s\n", "Trans Id" , "Book Name" , "Borrow Date" , "Due Date" , "Status"));

        sb.append("-----------------------------------------------------\n");

        for(TransactionDTO trans : transactions){
            sb.append(String.format("%-10s | %-15s | %-15s | %-15s | %-10s\n", trans.getId() , trans.getBookName() , trans.getBorrowDate() , trans.getDueDate() , trans.getStatus()));
        }

        System.out.println(sb);


    }



    
}
