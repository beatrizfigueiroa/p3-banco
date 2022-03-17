package unikut.Logica;
import java.util.LinkedList;

public class Account {
    private String username;
    private String password;
    private String name;
    private LinkedList<Account> accounts = new LinkedList<Account>();
    
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

    public void CreateAccount(Account account){
        accounts.add(account);
    }
    public void ShowAccounts(){
        System.out.println(accounts);
    }
}
