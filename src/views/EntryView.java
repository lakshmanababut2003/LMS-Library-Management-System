package views;

import java.util.Scanner;

import dto.UserDTO;
import menu.Menu;
import service.AuthServiceImp;
import service.exception.InvalidException;
import service.interfaces.AuthService;
import util.InputUtil;
import util.Validation;
import views.factory.UserFactory;

public class EntryView {

    private final AuthService auth ;

    public EntryView(){
        auth = new AuthServiceImp();
    }

    public void goToLogin(){

        Scanner sc = InputUtil.getScanner();
        int choice ;

        do{
            Menu.getMenu().entryMenu();
            choice = Validation.getValidInt(sc, "Choice");

            switch(choice){
                case 1:{
                    doLogin(sc);
                    break;
                }
                case 2:{
                    System.out.println("Exiting... Thanks for coming...");
                    break;
                }
                default:{
                    System.out.println("Wrong Choice....");
                    break;
                }
            }
        }
        while(choice != 2);


    }

    private void doLogin(Scanner sc){

        String userName = Validation.getValidText(sc, "Username");

        if(userName == null){
            return;
        }

        String accessId = Validation.getValidText(sc, "Access Id");

        if(accessId == null){
            return ;
        }

        try{
            UserDTO user = auth.validUser(new UserDTO(userName, accessId));
            goToDashboard(user);

        }
        catch(InvalidException e){
            System.out.println(e.getMessage());
        }

    }

    private void goToDashboard(UserDTO user){

        Dashboard dashboard = UserFactory.getUserFactory().getUserDashboard(user);

        if(dashboard == null){
            System.out.println("InValid Role (404b not found)...");
            return;
        }

        dashboard.showDashboard();

    }
    
}


