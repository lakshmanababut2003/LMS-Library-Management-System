package views;

import java.time.LocalDate;
import java.util.Scanner;

import dto.BookDTO;
import dto.TransactionDTO;
import dto.UserDTO;
import menu.Menu;
import service.BookServiceImp;
import service.BorrowServiceImp;
import service.interfaces.BorrowerService;
import service.interfaces.ViewService;
import util.InputUtil;
import util.TableUtil;
import util.Validation;

public class BorrowerView implements Dashboard {

    private final TableUtil tableUtil;
    private final ViewService<BookDTO> bookService;
    private final UserDTO user;
    private final BorrowerService borrowerService;

    public BorrowerView(UserDTO user){
        tableUtil = TableUtil.getPrint();
        bookService = new BookServiceImp();
        borrowerService = new BorrowServiceImp();
        this.user = user;
    }

    @Override
    public void showDashboard(){

        System.out.println("Borrower Dashboard....");
        Scanner sc = InputUtil.getScanner();
        int choice ;

        do{
            Menu.getMenu().borrowerMenu();
            choice = Validation.getValidInt(sc, "Choice");

            if(choice == -1){
                return;
            }

            switch(choice){

                case 1:{
                    viewAllBooks();
                    break;
                }
                case 2:{
                    borrowBook(sc);
                    break;
                }
                case 3:{
                    viewMyTransaction();
                    break;
                }
                case 4:{
                    System.out.println("Logout...");
                    break;
                }
                default:{
                    System.out.println("Wrong Choice...Try Again...");
                    break;
                }
            }
        }
        while(choice != 5);

    }

    private void viewAllBooks(){
        tableUtil.displayBookTable(bookService.viewAll());
    }

    private void borrowBook(Scanner sc){

        String bookName = Validation.getValidText(sc, "Book Name");

        if(bookName == null){
            return;
        }

        TransactionDTO res = borrowerService.borrowBook(new TransactionDTO(bookName, LocalDate.now(), user.getUserName()));
        tableUtil.displayTransactionRecord(res);
    }

    private void viewMyTransaction(){

    }
    
}
