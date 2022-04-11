package unikut.Logica;
import java.util.ArrayList;

public class Account {
    private String username;
    private String password;
    private String name;
    private ArrayList<Account> accounts = new ArrayList<Account>();
    
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

    @Override
    public boolean equals(Object obj) {
       if(obj instanceof Account){
            Account other = (Account) obj;
            if (this.username.equals(other.username) && this.password.equals(other.password)){
                return true;
            }
       }   
       return false; 
    } 
}
