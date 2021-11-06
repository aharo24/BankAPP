

public class SavingsAccount extends Account
{
    // interest rate
    private  double interestRate;

    public SavingsAccount(){
        super();
    }


    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }


    public SavingsAccount(int accountNumber, double interestRate){
        super(accountNumber);
        this.interestRate = interestRate;
    }

    public double calculateInterest(){
        return balance * interestRate;
    }

    public void applyInterest(){
        double interest = calculateInterest();
        System.out.printf("Interest amount %.2 added to balance%n", interest);
        deposit(interest);
    }



    @Override
    public void deposit(double amount) {
        // First check amount
        if (amount > 0){
            balance += amount;
            System.out.printf("Amount %.2 deposited %n", amount);
            System.out.printf("Current Balance is: %.2f%n", balance);
        }else{
            System.out.println("A negative amount cannot be deposited.");
        }
    }


    @Override
    public void withDraw(double amount) {
        if (amount > 0){
            // check sufficient balance
            if (amount <= balance){
                System.out.printf("Amount %.2 withdrawn from Account%n %n", amount);
                balance -= amount;
                System.out.printf("Current Balance is: %.2f%n",balance);
            }
        }else {
            System.out.println("Negative amount cannot be withdrawn!");
        }
    }
}
