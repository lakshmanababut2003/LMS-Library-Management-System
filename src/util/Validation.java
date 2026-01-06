package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {

    private static final String exit = "( or press 0 to Exit )";

    public static int getValidInt(Scanner sc, String fieldName) {

        int input;

        while (true) {

            try {

                
                System.out.println("Enter the " + fieldName + exit +" :");
                input = sc.nextInt();
                sc.nextLine();

                if (input == 0) {
                    return -1;
                }

                return input;

            } catch (InputMismatchException e) {
                System.out.println("Wrong Input...(Given in Number)");
                sc.nextLine();
            }

        }

    }

    public static String getValidText(Scanner sc , String fieldName){

        String input;

        while(true){

            System.out.println("Enter the " + fieldName + exit +" :");
            input = sc.nextLine();

            if(input.equals("0")){
                return null;
            }

            if(input.trim().isEmpty()){
                System.out.println("Empty input doesnot allowed...");
            }
            else{
                return input;
            }

        }
    }

}
