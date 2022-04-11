package unikut.Logica;
import java.util.ArrayList;

public class DataBase extends Account{
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private String accountName;


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

    public boolean EditAccount(String edit, String user, String pass, int i){
        for (Account account: accounts) {
            if (account.getUsername().equals(user) && account.getPassword().equals(pass)) {
                switch (i) {
                    case 1:
                        account.setName(edit);
                        System.out.println(account.getName());
                        break;
                    case 2:
                        account.setPassword(edit);
                        break;
                    case 3:
                        account.setUsername(edit);
                        break;
                }         
                return true;
            }
        }
        return false;
    }

}
