// Base class
// abstract class

public abstract class Account
{
    // account number
    private int accountNumber;

    // balance
    protected double balance;

    // DVC
    public Account(){}

    //EVC
    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public int getAccountNumber() { return accountNumber; }
    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    // abstract
    /*
    Function to deposit into the account as long as
    the amount parameter is > 0
    ** we can apply a transaction fee for our checkingAccount
     */
    public abstract void deposit(double amount);


    /*

     */
    public abstract void withDraw(double amount);

}
