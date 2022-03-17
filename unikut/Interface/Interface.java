package unikut.Interface;
import java.util.Scanner;

import unikut.Logica.Account;


public class Interface {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("UNIKUT");
        System.out.println("Wellcome :)");
        do{
        System.out.println("What to do?");
        System.out.println("1 - Sing up");
        System.out.println("2 - Login");
        int option = s.nextInt();
        while (option < 1 || option > 2) {
            System.out.println("^^");
            System.out.println("Invalid option, choose between:");
            System.out.println("1 - Sing up");
            System.out.println("2 - Login");
            option = s.nextInt();
        }
        switch (option) {
            case 1:
                Account account = new Account();
                System.out.println("Create a Username");
                account.setPassword(s.nextLine());
                s.nextLine();
                System.out.println("Create a password");
                account.setUsername(s.nextLine());
                System.out.println("Tell your name");
                account.setName(s.nextLine());
                account.CreateAccount(account);
                account.ShowAccounts();
                break;
        
            case 2:

                break;
        }
    }while(10 > 0);
    }

}