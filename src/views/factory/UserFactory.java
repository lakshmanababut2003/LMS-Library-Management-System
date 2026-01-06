package views.factory;

import dto.UserDTO;
import views.AdminView;
import views.BorrowerView;
import views.Dashboard;
import views.LibrayianView;

public class UserFactory {

    private static UserFactory userFactory;
    private LibrayianView libInstance ;
    private BorrowerView borwInstance;
    private AdminView adminInstance;

    private UserFactory(){}

    public static UserFactory getUserFactory(){

        if(userFactory == null){
            userFactory = new UserFactory();
        }

        return userFactory;
    }

    public Dashboard getUserDashboard(UserDTO user){

        switch(user.getRole()){

            case "LIBRAIAN":{
                if(libInstance == null){
                    libInstance = new LibrayianView(user);
                }

                return libInstance;
            }
            case "BORROWER":{

                if(borwInstance == null){
                    borwInstance = new BorrowerView(user);
                }

                return borwInstance;

            }
            case "ADMIN":{

                if(adminInstance == null){
                    adminInstance = new AdminView(user);
                }

                return adminInstance;
            }
            default:{
                return null;
            }
        }
    }
    
}
