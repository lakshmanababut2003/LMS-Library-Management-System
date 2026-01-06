package views;

import java.util.Scanner;

import dto.BookDTO;
import dto.UserDTO;
import menu.Menu;
import service.BookServiceImp;
import service.LibraianServiceImp;
import service.exception.InvalidException;
import service.interfaces.LibraianService;
import service.interfaces.ViewService;
import util.InputUtil;
import util.TableUtil;
import util.Validation;

public class LibrayianView implements Dashboard {

    private final LibraianService lbService;
    private final ViewService<BookDTO> bookService;
    private final TableUtil tableUtil;
    private final UserDTO user;

    public LibrayianView(UserDTO user) {
        lbService = new LibraianServiceImp();
        bookService = new BookServiceImp();
        tableUtil = TableUtil.getPrint();
        this.user = user;
    }

    @Override
    public void showDashboard() {

        System.out.println("Library Dashboard...");
        Scanner sc = InputUtil.getScanner();
        int choice;

        do {
            Menu.getMenu().libraianMenu();
            choice = Validation.getValidInt(sc, "Choice");

            if(choice == -1){
                return;
            }

            switch (choice) {
                case 1: {
                    addBook(sc);
                    break;
                }
                case 2: {
                    viewBooks();
                    break;
                }
                case 3: {
                    viewTransByDay(sc);
                    break;
                }
                case 4: {
                    viewDelayBorrows();
                    break;
                }
                case 5: {
                    returnBook(sc);
                    break;
                }
                case 6: {
                    System.out.println("Logouting...");
                    break;
                }
                default: {
                    System.out.println("Wrong Choice... Try Again..");
                    break;
                }
            }

        } while (choice != 6);

    }

    private void addBook(Scanner sc) {

        String bookName = Validation.getValidText(sc, "Book Name ");

        if (bookName == null) {
            return;
        }

        String authorName = Validation.getValidText(sc, "Author Name ");

        if (authorName == null) {
            return;
        }

        int stock = Validation.getValidInt(sc, "Stock");

        if (stock == -1) {
            return;
        }

        try {
            BookDTO bookDTO = lbService.addBook(new BookDTO(bookName, authorName, stock));
           tableUtil.displayBookRecord(bookDTO);
        } catch (InvalidException e) {
            System.out.println("Error Occured : " + e.getMessage());
        }

    }

    private void viewBooks() {
        tableUtil.displayBookTable(bookService.viewAll());
    }

    private void viewTransByDay(Scanner sc) {

    }

    private void viewDelayBorrows() {

    }

    private void returnBook(Scanner sc) {

    }

 
}
