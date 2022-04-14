package unikut.Logica;
import java.util.ArrayList;

public class Account extends DataBase{
    private String username;
    private String password;
    private String name;
    private ArrayList<Account> friends = new ArrayList<Account>();
    private ArrayList<Account> friendsRequest = new ArrayList<Account>();

    public ArrayList<Account> getFriendsRequest(){
        return this.friendsRequest;
    }
    
    public ArrayList<Account> getFriends(){
        return this.friends;
    }
    
    public boolean Request(Account acc, String User, DataBase data){
        for (Account account : data.accounts) {
            if (account.getUsername().equals(User)) {
                account.friendsRequest.add(acc);
                return true;
            }
        }
        return false;
    }

    public boolean addFriend(Account acc, Account acc2){
        acc2.friends.add(acc);
        acc.friends.add(acc2);
        return true;
    }
    
    public boolean removeFriend(Account acc, String User){
        for (Account account : acc.friends) {
            if (account.getUsername().equals(User)) {
                acc.friends.remove(account);
                account.friends.remove(acc);
                return true;
            }
        }
        return false;
    }

    public String getUsername() {
        return username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
