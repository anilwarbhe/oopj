// Final class that cannot be extended
final class BankVault {
    // Final variable - cannot be modified after initialization
    private final String VAULT_ID = "BV-001";
    private final double MAX_CAPACITY = 1000000.0; // Maximum storage capacity in dollars
    private double currentBalance;

    // Constructor
    public BankVault(double initialBalance) {
        this.currentBalance = initialBalance;
    }

    // Final method - cannot be overridden
    public final void deposit(double amount) {
        if (amount > 0 && (currentBalance + amount) <= MAX_CAPACITY) {
            currentBalance += amount;
            System.out.println("Deposited $" + amount + " to vault " + VAULT_ID);
            System.out.println("Current balance: $" + currentBalance);
        } else {
            System.out.println("Deposit failed: Invalid amount or exceeds vault capacity.");
        }
    }

    // Non-final method - could be overridden if the class weren't final
    public void checkBalance() {
        System.out.println("Vault " + VAULT_ID + " balance: $" + currentBalance);
    }

    // Getter for VAULT_ID
    public String getVaultId() {
        return VAULT_ID;
    }
}

// Main class to demonstrate the final modifier
public class BankVaultSystem {
    public static void main(String[] args) {
        // Create a BankVault object
        BankVault vault = new BankVault(50000.0);

        // Demonstrate final variable
        System.out.println("Vault ID: " + vault.getVaultId());
        // Attempting to modify VAULT_ID would cause a compilation error
        // vault.VAULT_ID = "BV-002"; // This would not compile

        // Demonstrate final method
        vault.deposit(10000.0);
        vault.checkBalance();

        // Attempting to extend BankVault would cause a compilation error
        // class ExtendedVault extends BankVault {} // This would not compile
    }
}
