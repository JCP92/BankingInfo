/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

/**
 *
 * @author Josh
 */
public class BankAccount {
    private String accountNumber;
    private String accountType;
    private String customer;
    private double balance;
    private double overdrawLimit;


    public static final double DEFAULT_OVERDRAW_LIMIT = 50;
    public String getAccNumber(){ return accountNumber; }
    public String getAccType() { return accountType; }
    public double getBal(){ return balance; }
    public void setBal(double bal){ balance = bal; }
    public double getODLimit(){ return overdrawLimit; }
    public void setODLimit(double limit) { overdrawLimit = limit; }
    void setCustomer(Customer info){
        customer = info.getID();
    }
    public String getCustomer(Customer info) { return info.getName(); }
    public void deposite(double amt){ this.balance += amt; }
    public void withdraw(double amt){ this.balance -= amt; }
    public void transfer(BankAccount acct, double amt){
        acct.withdraw(amt);
        this.deposite(amt);
    }
    
    @Override
    public String toString(){return "Customer: "+customer+"\nAccount Type: "+accountType+"\nAccount Number: "+accountNumber+"\nBalance: "+balance+"\nOver Draft Limit: "+overdrawLimit;}

    
    public BankAccount(String accNum, String accType, double ODlimit){
        this.accountNumber = accNum;
        this.accountType = accType;
        this.overdrawLimit = ODlimit;
    }
    public BankAccount(String accNum, String accType){
        this.accountNumber = accNum;
        this.accountType = accType;
        this.overdrawLimit = DEFAULT_OVERDRAW_LIMIT;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankAccount savings = new BankAccount("200981", "Savings", 0);
        BankAccount checking = new BankAccount("200981", "Checking");
        Customer george = new Customer("111-22-3333", "George Gymnasium");
				
        savings.setCustomer(george);

        checking.setCustomer(george);
        savings.deposite(100);
        checking.deposite(79.23);
        savings.transfer(checking, 25.10);
        checking.withdraw(10);  
        System.out.println(savings);
        System.out.println(checking);
    }    
    
}
