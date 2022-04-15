package unikut.Logica;
import java.util.ArrayList;

public class DataBase {
    
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private String accountName;

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    public void CreateAccount(Account account){
        accounts.add(account);
    }

    public void ShowAccounts(){
        for (Account account: accounts) {
            System.out.println(account.getName());
        }
    }

    public boolean Login(String user, String pass){
        for (Account account: accounts) {
            if (account.getUsername().equals(user) && account.getPassword().equals(pass)) {
                setAccountName(account.getName());
                return true;
            }
        }
        return false;
    }

    public Account getAccount(String user, String pass){
        for (Account account: accounts) {
            if (account.getUsername().equals(user) && account.getPassword().equals(pass)) {
                return account;
            }
        }
        return null;
    }

    public boolean EditAccount(String edit, String user, String pass, int i){
        for (Account account: accounts) {
            if (account.getUsername().equals(user) && account.getPassword().equals(pass)) {
                switch (i) {
                    case 1:
                        account.setName(edit);
                        System.out.println(account.getName());
                        break;
                    case 2:
                        account.setUsername(edit);
                        System.out.println(account.getUsername());
                        break;
                    case 3:
                        account.setPassword(edit);
                        System.out.println(account.getPassword());
                        break;
                }         
                return true;
            }
        }
        return false;
    }

}
