public class BankAccount {
    // Instance variables (attributes)
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
            System.out.println("New balance: $" + balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("\nAccount Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: $" + balance);
    }

    // Main method to demonstrate the use of BankAccount class
    public static void main(String[] args) {
        // Creating objects of BankAccount class
        BankAccount account1 = new BankAccount("1001", "John Doe", 1000.0);
        BankAccount account2 = new BankAccount("1002", "Jane Smith", 500.0);

        // Performing operations on account1
        System.out.println("\nOperations for Account 1:");
        account1.displayAccountDetails();
        account1.deposit(500.0);
        account1.withdraw(200.0);
        account1.withdraw(2000.0); // Attempting to withdraw more than balance
        account1.displayAccountDetails();

        // Performing operations on account2
        System.out.println("\nOperations for Account 2:");
        account2.displayAccountDetails();
        account2.deposit(1000.0);
        account2.withdraw(300.0);
        account2.displayAccountDetails();
    }
}