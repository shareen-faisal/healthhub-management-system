 import java.util.Scanner;
 class Account {
    private String accountNumber;
    private double balance;

    // Default constructor
    public Account() {
        this.accountNumber = "";
        this.balance = 0.0;
    }

    // Parameterized constructor
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Setter for account number
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addBalance(){

        Scanner key = new Scanner(System.in);
        System.out.println("\nEnter the amount which you want to add in your account");
        double amount=key.nextDouble();

        while(amount <=0){
            System.out.println("Enter a valid amount");
            amount=key.nextDouble();
        }//while

        setBalance(getBalance() + amount);

        System.out.println("\nYour total balance is: Rs."+ getBalance());
        System.out.println();


    }//addBalance()
}//account
