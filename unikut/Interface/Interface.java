package unikut.Interface;
import java.util.InputMismatchException;
import java.util.Scanner;

import unikut.Logica.Account;
import unikut.Logica.DataBase;


public class Interface {
    public static void main(String[] args){
        int option, option2;
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
        try{
            do{
            System.out.println("What to do?");
            System.out.println("1 - Sing up");
            System.out.println("2 - Login");
            System.out.println("3 - Finish program");
            option = s.nextInt();
            while (option < 1 || option > 3) {
                System.out.println("^^");
                System.out.println("Invalid option, choose between:");
                System.out.println("1 - Sing up");
                System.out.println("2 - Login");
                System.out.println("3 - Finish program");
                option = s.nextInt();
            }
            switch (option) {
                case 1:
                    Account account = new Account();
                    System.out.println("Create a Username");
                    String usernameSing = s.next();
                    if (!data.getAccounts().isEmpty()){
                        for (Account ac : data.getAccounts()) {
                            while (ac.getUsername().equals(usernameSing)) {
                                System.out.println("This username already exist, try a new one");
                                usernameSing = s.next();
                            }
                        }
                    }
                    account.setUsername(usernameSing);
                    System.out.println("Create a password");
                    account.setPassword(s.next());
                    System.out.println("Tell your name");
                    String name = s.nextLine();
                    name = s.nextLine();
                    account.setName(name);
                    data.CreateAccount(account);
                    break;
            
                case 2:
                    while (data.getAccounts().isEmpty()) {
                        System.out.println("There are no accounts, please sing up");
                        System.out.println("1 - Sing up");
                        System.out.println("2 - Login");
                        System.out.println("3 - Finish program");
                        option = s.nextInt();
                    }
                    System.out.print("Username: ");
                    String user = s.next();
                    System.out.print("Password: ");
                    String pass = s.next();
                    boolean b = data.Login(user, pass);
                    Account acc = data.getAccount(user, pass);
                    if (b) {
                        System.out.println("Welcome back " + data.getAccountName() + " :D");
                        do{
                            if (!acc.getFriendsRequest().isEmpty()) {
                                System.out.println("You have some new friend requests check your requests");
                            }
                            if (!acc.getMessagesAccounts().isEmpty()) {
                                System.out.println("You have some new messages");
                            }
                            System.out.println("");
                            System.out.println("1 - Edit your account");
                            System.out.println("2 - Add a new friend");
                            System.out.println("3 - Send message");
                            System.out.println("4 - View messages");
                            System.out.println("5 - Requests");
                            System.out.println("6 - Remove a friend");
                            System.out.println("7 - FriendList");
                            System.out.println("8 - Log out");
                            option2 = s.nextInt();
                            while (option2 < 1 || option2 > 8) {
                                System.out.println("Invalid option, choose a valid one");
                                System.out.println("1 - Edit your account");
                                System.out.println("2 - Add a new friend");
                                System.out.println("3 - Send message");
                                System.out.println("4 - View messages");
                                System.out.println("5 - Requests");
                                System.out.println("6 - Remove a friend");
                                System.out.println("7 - FriendList");
                                System.out.println("8 - Log out");
                                option2 = s.nextInt();
                            }
                            switch (option2) {
                                case 1:
                                    System.out.println("What do you want to change");
                                    System.out.println("1 - Name | 2- Username | 3 - Password ");
                                    int option3 = s.nextInt();
                                    while (option3 < 1 || option3 > 3) {
                                        System.out.println("Invalid option, choose a valid one");
                                        System.out.println("1 - Name | 2- Username | 3 - Password ");
                                        option3 = s.nextInt();
                                    }
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
                                    break;
                                case 2:    
                                    if (acc.getFriends().size() > 24) {
                                        System.out.println("You have reached the limit of friends");
                                        break;
                                    }
                                    System.out.println("Tell the Username you want to add");
                                    String userToAdd = s.next();
                                    while (userToAdd.equals(acc.getUsername())) {
                                        System.out.println("You can't request yourself as a friend, write a valid user");
                                        userToAdd = s.next();
                                    }
                                    boolean f = acc.Request(acc, userToAdd, data);
                                    if (f) {
                                        System.out.println("You have sent a request to " + userToAdd);
                                    }else{
                                        System.out.println("User does not exist");
                                    }
                                    break;
                                case 3:
                                    if (acc.getFriends().isEmpty()) {
                                        System.out.println("You have no friends to text");
                                    }else{
                                        System.out.println("Enter the username you want to send a message");
                                        String userSendMessage = s.next();
                                        System.out.println("Type message");
                                        String message = s.nextLine();
                                        message = s.nextLine();
                                        message = message + " sent by " + acc.getUsername();
                                        Boolean m = acc.Message(acc, userSendMessage, data, message);
                                        if(m){
                                            System.out.println("You've just sent a message"); 
                                        }
                                        break;
                                }
                                case 4:
                                    if (acc.getMessagesAccounts().isEmpty()) {
                                        System.out.println("You have no messages");
                                    }else{
                                        acc.ShowMessages();
                                        acc.getMessagesAccounts().clear();
                                    }
                                    break; 
                                case 5:
                                    while (!acc.getFriendsRequest().isEmpty()) {
                                        Account accountRequest = new Account();
                                        for (int i = 0; i < acc.getFriendsRequest().size(); i++) {
                                            accountRequest = acc.getFriendsRequest().get(i); 
                                            System.out.println(accountRequest.getUsername() + " Has sent u a friend request");
                                            System.out.println("Do you want to accept " + accountRequest.getUsername() + " as your friend? yes/no");
                                            String acception = s.next();
                                            while (!acception.equals("yes") && !acception.equals("no")) {
                                                System.out.println("Invalid option, choose a valid one");
                                                acception = s.next();
                                            }
                                            if (acception.equals("yes") && acc.getFriends().size()> 24){
                                                System.out.println("You can't accept because you have passed friend limit");
                                                break;
                                            }else if (acception.equals("yes")) {
                                                acc.addFriend(accountRequest, acc);
                                                System.out.println("Now you and " + accountRequest.getUsername() + " are friends");
                                            }else{
                                                System.out.println("You have not accepted " + accountRequest.getUsername() + " request");
                                            } 
                                            acc.removeRequest(acc, accountRequest.getUsername(), data);  
                                        }
                                        
                                    }   
                                    break;
                                case 6:
                                    if (acc.getFriends().isEmpty()) {
                                        System.out.println("You can't delete if you don't have any added friends");
                                        break;
                                    }
                                    System.out.println("Tell the user you want to delete");
                                    String userToDelete = s.next();
                                    acc.removeFriend(acc, userToDelete);
                                    break;
                                case 7:   
                                    if (acc.getFriends().isEmpty()) {
                                        System.out.println("You have no friends");
                                    }else{
                                        acc.ShowFriends();
                                    }
                                    break; 
                                case 8:
                                    System.out.println("See ya :D"); 
                            }
                        }while (option2 != 8);
                    }else{
                        System.out.println("You have entered a invalid username or password");
                        
                    }
                    break;
            case 3:
                break;         
            }

            }while(option != 3);
        }catch(InputMismatchException ex){
            System.out.println("You have entered a different type of read");
            System.out.println("Critical error has occored");
            System.out.println(" :C ");
        }
        finally{
            s.close();
            System.out.println("Finishing program, please restart it");
        }
    }

}