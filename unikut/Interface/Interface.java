package unikut.Interface;
import java.util.Scanner;
import unikut.Logica.Account;
import unikut.Logica.DataBase;


public class Interface {
    public static void main(String[] args) {
        String op1, op2;
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
        System.out.println("0 - Finish program");
        int option = s.nextInt();
        while (option < 0 || option > 2) {
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
                Account acc = data.getAccount(user, pass);
                if (b) {
                    System.out.println("Welcome back " + data.getAccountName());
                    do{
                        if (!acc.getFriendsRequest().isEmpty()) {
                            System.out.println("You have some new friend requests check your requests");
                        }
                        System.out.println("1 - Edit your account");
                        System.out.println("2 - Add a new friend");
                        System.out.println("3 - Send message");
                        System.out.println("4 - Requests");
                        System.out.println("5 - Remove a friend");
                        System.out.println("6 - FriendList");
                        System.out.println("7 - Log out");
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
                            case 2:    
                                System.out.println("Tell the Username you want to add");
                                String userToAdd = s.next();
                                boolean f = acc.Request(acc, userToAdd, data);
                                if (f) {
                                    System.out.println("You have sent a request to " + userToAdd);
                                }else{
                                    System.out.println("User does not exist");
                                }
                                break;
                            case 3:
                                break;
                            case 4:
                                if (!acc.getFriendsRequest().isEmpty()) {
                                    for (Account accountRequest : acc.getFriendsRequest()) {
                                        System.out.println(accountRequest.getUsername() + " Has sent u a friend request");
                                        System.out.println("Do you want to accept " + accountRequest.getUsername() + " as your friend? yes/no");
                                        String acception = s.next();
                                        while (!acception.equals("yes") && !acception.equals("no")) {
                                            System.out.println("Invalid option, choose a valid one");
                                            acception = s.next();
                                        }
                                        if (acception.equals("yes")) {
                                            acc.addFriend(accountRequest, acc);
                                            System.out.println("");
                                            System.out.println("Now you and " + accountRequest.getUsername() + " are friends");
                                        }else{
                                            System.out.println("");
                                            System.out.println("You have not accepted " + accountRequest.getUsername() + " request");
                                        }   
                                    }
                                }   
                                break;
                            case 5:
                                if (acc.getFriends().isEmpty()) {
                                    System.out.println("You can´t delete if you don´t have any added friends");
                                    break;
                                }
                                System.out.println("Tell the user you want to delete");
                                String userToDelete = s.next();
                                acc.removeFriend(acc, userToDelete);
                                break;
                        }
                    System.out.println("Wanna continue? yes/no)");    
                    op2 = s.next() ;   
                    while (!op2.equals("yes") && !op2.equals("no")) {
                        System.out.println("Invalid option, choose a valid one");
                        op2= s.next();
                    }
                    }while (op2.equals("yes"));
                }else{
                    System.out.println("You have entered a invalid username or password");
                }
                break;
        }
    }while(10 > 0);
    }

}