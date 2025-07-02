// Payment interface defining the contract for payment methods
interface Payment {
    boolean processPayment(double amount);
    boolean refundPayment(double amount);
    String getPaymentDetails();
}

// CreditCardPayment class implementing Payment interface
class CreditCardPayment implements Payment {
    private String cardNumber;
    private double balance;

    // Constructor
    public CreditCardPayment(String cardNumber, double balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Credit Card payment of $" + amount + " processed successfully.");
            return true;
        } else {
            System.out.println("Credit Card payment failed: Insufficient balance or invalid amount.");
            return false;
        }
    }

    @Override
    public boolean refundPayment(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Credit Card refund of $" + amount + " processed successfully.");
            return true;
        } else {
            System.out.println("Credit Card refund failed: Invalid amount.");
            return false;
        }
    }

    @Override
    public String getPaymentDetails() {
        return "Credit Card Payment [Card Number: " + cardNumber + ", Current Balance: $" + balance + "]";
    }
}

// PayPalPayment class implementing Payment interface
class PayPalPayment implements Payment {
    private String email;
    private double balance;

    // Constructor
    public PayPalPayment(String email, double balance) {
        this.email = email;
        this.balance = balance;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("PayPal payment of $" + amount + " processed successfully.");
            return true;
        } else {
            System.out.println("PayPal payment failed: Insufficient balance or invalid amount.");
            return false;
        }
    }

    @Override
    public boolean refundPayment(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("PayPal refund of $" + amount + " processed successfully.");
            return true;
        } else {
            System.out.println("PayPal refund failed: Invalid amount.");
            return false;
        }
    }

    @Override
    public String getPaymentDetails() {
        return "PayPal Payment [Email: " + email + ", Current Balance: $" + balance + "]";
    }
}

// Main class to demonstrate the payment gateway system
public class PaymentGateway {
    public static void main(String[] args) {
        // Create instances of different payment methods
        Payment creditCard = new CreditCardPayment("1234-5678-9012-3456", 1000.0);
        Payment payPal = new PayPalPayment("user@example.com", 500.0);

        // Demonstrate payment processing
        System.out.println("Demonstrating Payment Processing:");
        creditCard.processPayment(200.0);
        payPal.processPayment(150.0);

        // Demonstrate refund processing
        System.out.println("\nDemonstrating Refund Processing:");
        creditCard.refundPayment(100.0);
        payPal.refundPayment(50.0);

        // Demonstrate invalid operations
        System.out.println("\nDemonstrating Invalid Operations:");
        creditCard.processPayment(2000.0); // Exceeds balance
        payPal.processPayment(-50.0);      // Negative amount

        // Display payment details
        System.out.println("\nPayment Details:");
        System.out.println(creditCard.getPaymentDetails());
        System.out.println(payPal.getPaymentDetails());

        // Demonstrate polymorphism with interface array
        System.out.println("\nDemonstrating Polymorphism:");
        Payment[] payments = {creditCard, payPal};
        for (Payment payment : payments) {
            System.out.println("\nProcessing payment method:");
            payment.processPayment(100.0);
            System.out.println(payment.getPaymentDetails());
        }
    }
}