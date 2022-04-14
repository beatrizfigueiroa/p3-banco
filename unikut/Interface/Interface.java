package unikut.Interface;
import java.util.Scanner;
import unikut.Logica.Account;
import unikut.Logica.DataBase;


public class Interface {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DataBase data = new DataBase();
        System.out.println("  _    _       _ _          _   \n" +
        " | |  | |     (_) |        | |  \n" +
        " | |  | |_ __  _| | ___   _| |_ \n" +
        " | |  | | '_ \\| | |/ / | | | __|\n" +
        " | |__| | | | | |   <| |_| | |_ \n" +
        "  \\____/|_| |_|_|_|\\_\\\\__,_|\\__|");
        System.out.println("");
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
                account.setUsername(s.next());
                System.out.println("Create a password");
                account.setPassword(s.next());
                System.out.println("Tell your name");
                account.setName(s.next());
                data.CreateAccount(account);
                data.ShowAccounts();
                break;
        
            case 2:
                System.out.print("Username: ");
                String user = s.next();
                System.out.print("Password: ");
                String pass = s.next();
                boolean b = data.Login(user, pass);
                if (b) {
                    System.out.println("Welcome back " + data.getAccountName());
                    System.out.println("1 - Edit your account");
                    System.out.println("2 - Add a new friend");
                    System.out.println("3 - Send message");
                    int option2 = s.nextInt();
                    switch (option2) {
                        case 1:
                            System.out.println("What do you want to change");
                            System.out.println("1 - Name | 2- Username | 3 - Password ");
                            int option3 = s.nextInt();
                            if (option3 == 1) {
                                System.out.println("Tell your new name");
                                String newName = s.next();
                                System.out.println(data.EditAccount(newName, user, pass, option3));
                            }else if (option3 == 2) {
                                System.out.println("Tell your new User");
                                String newUser = s.next();
                                System.out.println(data.EditAccount(newUser, user, pass, option3));
                            }else if (option3 == 3) {
                                System.out.println("Tell your new pass");
                                String newPass = s.next();
                                System.out.println(data.EditAccount(newPass, user, pass, option3));
                            }
                            data.ShowAccounts();
                            break;
                    
                        default:
                            break;
                    }
                }else{
                    System.out.println("You have entered a invalid username or password");
                }
                break;
        }
    }while(10 > 0);
    }

}