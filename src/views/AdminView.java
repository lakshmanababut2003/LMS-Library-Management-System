package views;

import java.util.Scanner;

import dto.UserDTO;
import menu.Menu;
import model.enums.Role;
import service.AuthServiceImp;
import service.UserServiceImp;
import service.exception.InvalidException;
import service.interfaces.AuthService;
import service.interfaces.ViewService;
import util.InputUtil;
import util.TableUtil;
import util.Validation;

public class AdminView implements Dashboard {

    private final UserDTO user;
    private final TableUtil tableUtil;
    private final AuthService auth;
    private final ViewService<UserDTO> users;

    public AdminView(UserDTO user){
        this.user = user;
        tableUtil = TableUtil.getPrint();
        auth = new AuthServiceImp();
        users = new UserServiceImp();
    }

    public void showDashboard(){

        System.out.println("Admin Dashboard");
        int choice ;
        Scanner sc = InputUtil.getScanner();

        do{

            Menu.getMenu().adminMenu();
            choice = Validation.getValidInt(sc, "Choice");

            if(choice == -1){
                return;
            }

            switch(choice){

                case 1:{
                    addUser(sc);
                    break;
                }
                case 2:{
                    viewAllUsers();
                    break;
                }
                case 3:{
                    System.out.println("Logout...");
                    break;
                }
                default:{
                    System.out.println("Wrong Choice ... try again");
                    break;
                }
            }

        }while(choice != 3);

    }


    private void addUser(Scanner sc){

        String userName = Validation.getValidText(sc, "User Name ");

        if(userName == null){
            return ;
        }

        String phone = Validation.getValidText(sc, "Phone");

        if(phone == null){
            return;
        }

        String accessId = Validation.getValidText(sc, "Access Id");

        if(accessId == null){
            return;
        }

        System.out.println("1.Libraian");
        System.out.println("2.Borrower");
        System.out.println("3.Exit");

        int choice = Validation.getValidInt(sc, "Choice");

        if(choice == -1){
            return;
        }

        String role = null ;

        switch(choice){
            case 1:{
                role = Role.LIBRAIAN.name();
                break;
            }
            case 2:{
                role = Role.BORROWER.name();
                break;
            }
            case 3:{
                System.out.println("Role Doesnot Empty");
                break;
            }
            default:{
                System.out.println("Wrong choice");
                break;
            }
        }

        if(role == null){
            return;
        }

        try{

            UserDTO user = auth.addUser(new UserDTO(userName, accessId, role, phone));
            tableUtil.displayUserRecord(user);
        }
        catch(InvalidException e){
            System.out.println(e.getMessage());
        }

    }

    private void viewAllUsers(){
        tableUtil.displayUserTable(users.viewAll());
    }

    
}
