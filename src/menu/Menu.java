package menu;

public class Menu {

    private static  Menu instance;

    private Menu(){}

    public static Menu getMenu(){

        if(instance == null){
            instance = new Menu();
        }

        return instance;
    }

    public void entryMenu(){
        System.out.println();
        System.out.println("1.Login");
        System.out.println("2.Exit");
        System.out.println();
    } 

    public void adminMenu(){
        System.out.println();
        System.out.println("1.Add User");
        System.out.println("2.View All Users");
        System.out.println("3.Exit");
        System.out.println("4.Exit");
    }

    public void libraianMenu(){
        System.out.println();
        System.out.println("1.Add a Book ");
        System.out.println("2.View All Books");
        System.out.println("3.View Day Wise Transactions");
        System.out.println("4.View Delay Borrows");
        System.out.println("5.Return Module");
        System.out.println("6.Logout");
        System.out.println();
    }

    public void borrowerMenu(){
        System.out.println();
        System.out.println("1.view Books");
        System.out.println("2.Borrow a Book ");
        System.out.println("3.View My Transactions");
        System.out.println("4.Logout");
        System.out.println();
    }
    
}
