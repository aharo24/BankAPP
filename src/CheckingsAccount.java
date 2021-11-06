public class CheckingsAccount extends Account
{
    private static double FEE = 2.5;

    public CheckingsAccount(){
        super();
    }

    public CheckingsAccount(int accountNumber, double FEE){
        super(accountNumber);
        this.FEE = FEE;


    }

    @Override
    public void deposit(double amount) {
        // First check amount
        if (amount > 0){
            balance += amount;
            System.out.printf("Amount %.2 deposited %n", amount);
            //transaction FEE
            balance -= FEE;
            System.out.printf("Amount %.2 deposited %n", FEE);
            System.out.printf("Current Balance is: %.2f%n", balance);


        }else{
            System.out.println("A negative amount cannot be deposited.");
        }
    }

    @Override
    public void withDraw(double amount) {
        if (amount > 0){
            // check sufficient balance
            if (amount + FEE <= balance){
                System.out.printf("Amount %.2 withdrawn from Account%n %n", amount);
                balance -= amount;
                balance -= FEE;
                System.out.printf("FEE of  %.2 appplied to Account%n %n", FEE);
                System.out.printf("Current Balance is: %.2f%n",balance);
            }

        }else {
            System.out.println("Negative amount cannot be withdrawn!");

        }

    }
}
