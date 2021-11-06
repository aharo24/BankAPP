import java.util.Scanner;

public class AccountTester
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Create an array of Accounts
        Account[] accounts = new Account[10];
        int numberOfAccounts = 0;

        int choice;
        do {
            choice = menu(sc);
            System.out.println();

            if (choice == 1){
                accounts[numberOfAccounts ++] = createAccount(sc);
            }else if(choice == 2){
                doDeposit(accounts, numberOfAccounts, sc);
            }else if (choice == 3){
                doWithDraw(accounts, numberOfAccounts, sc);
            }else if (choice == 4){
                applyInterest(accounts,numberOfAccounts, sc);
            }else
                System.out.println("GoodBye ! (:");

        } while (choice != 5);
    }


    public static int accountMenu(Scanner sc)
    {
        System.out.println("Select Account Type: ");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");

        int choice;
        do {
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
        } while (choice < 1 || choice > 2);
        return choice;
    }

    public static int menu(Scanner sc)
    {
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. WithDraw Funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int choice;
        do {
            System.out.print("Enter Choice:  ");
            choice = sc.nextInt();
        } while (choice < 1 || choice > 5);
        return choice;
    }

    //Function to
    public static int searchAccount(Account[] accounts, int count, int accountNumber)
    {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    //Function to perform Deposit on a selected account
    public static void doDeposit(Account[] accounts, int count, Scanner sc)
    {
        //get Account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = sc.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            // amount
            System.out.print("Please enter Amount: ");
            double amount = sc.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("No account exists with AccountNumber: " + accountNumber);
        }
    }


    public static void doWithDraw(Account[] accounts, int count, Scanner sc)
    {
        //get Account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = sc.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            // amount
            System.out.print("Please enter WithDraw Amount: ");
            double amount = sc.nextDouble();

            accounts[index].withDraw(amount);
        } else {
            System.out.println("No account exists with AccountNumber: " + accountNumber);
        }
    }


    public static void applyInterest(Account[] accounts, int count, Scanner sc)
    {
        //get Account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = sc.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

        if (index > 0) {
            //must be an instance of SavingsAccount
            if (accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount) accounts[index]).applyInterest();
            } else {
                System.out.println("No account exists with AccountNumber: " + accountNumber);
            }

        }
    }


        //Function to create a new Account
        public static Account createAccount (Scanner sc )
        {
            int choice = accountMenu(sc);
            Account account = null;

            int accountNumber;
            System.out.print("Enter Account Number: ");
            accountNumber = sc.nextInt();

            if (choice == 1) {            //Checking Account
                System.out.println("Transaction Fee: ");
                double fee = sc.nextDouble();
                account = new CheckingsAccount(accountNumber, fee);

            } else {       // Savings Account
                System.out.print("Please enter Interest Rate: ");
                double interestRate = sc.nextDouble();

                account = new SavingsAccount(accountNumber, interestRate);
            }
            return account;
        }
}