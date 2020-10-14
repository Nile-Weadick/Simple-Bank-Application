/**
 *
 * @author NileW & Col P
 */
public class Account {
    
    private String accountNum, accountName, openDate;
    private double accountBalance;
    
    public Account(String accountNum, String accountName, String openDate, double accountBalance){
        this.accountNum = accountNum;
        this.accountName = accountName;
        this.openDate = openDate;
        this.accountBalance = accountBalance;
    }
    
    public void withdraw(double x){
        this.accountBalance = this.accountBalance - x;
    }
    
    public void deposit(double x){
        this.accountBalance = this.accountBalance + x;
    }
    
    public void transfer(Account a, double x){
        this.withdraw(x);
        a.deposit(x);
    }
    
    //Get methods
    public String getAccountName(){
        return this.accountName;
    }
    
    public String getOpenDate(){
        return this.openDate;
    }
    
    public double getAccountBalance(){
        return this.accountBalance;
    }
    
    @Override
    public String toString(){ //over ride the toString function to only return account num
        return this.accountNum;
    }
}
