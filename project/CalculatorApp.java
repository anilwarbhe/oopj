// Package for mathematical operations
package mathops;

// Class containing mathematical operations
class MathOperations {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}

// Package for user interaction
package userinterface;

import java.util.Scanner;

// Class handling user input and output
class UserInteraction {
    private Scanner scanner;

    public UserInteraction() {
        scanner = new Scanner(System.in);
    }

    public double getNumberInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Clear invalid input
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }

    public String getOperationInput() {
        System.out.print("Enter operation (+, -, *, /): ");
        String operation = scanner.next();
        while (!operation.matches("[+\\-*/]")) {
            System.out.println("Invalid operation. Please enter +, -, *, or /.");
            System.out.print("Enter operation (+, -, *, /): ");
            operation = scanner.next();
        }
        return operation;
    }

    public void displayResult(double result) {
        System.out.println("Result: " + result);
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }

    public void closeScanner() {
        scanner.close();
    }
}

// Main class in the default package to demonstrate package usage
import mathops.MathOperations;
import userinterface.UserInteraction;

public class CalculatorApp {
    public static void main(String[] args) {
        // Create instances of classes from different packages
        MathOperations math = new MathOperations();
        UserInteraction ui = new UserInteraction();

        try {
            // Get user input
            double num1 = ui.getNumberInput("Enter first number: ");
            double num2 = ui.getNumberInput("Enter second number: ");
            String operation = ui.getOperationInput();

            // Perform calculation based on operation
            double result;
            switch (operation) {
                case "+":
                    result = math.add(num1, num2);
                    ui.displayResult(result);
                    break;
                case "-":
                    result = math.subtract(num1, num2);
                    ui.displayResult(result);
                    break;
                case "*":
                    result = math.multiply(num1, num2);
                    ui.displayResult(result);
                    break;
                case "/":
                    result = math.divide(num1, num2);
                    ui.displayResult(result);
                    break;
                default:
                    ui.displayError("Unexpected operation.");
            }
        } catch (ArithmeticException e) {
            ui.displayError(e.getMessage());
        } finally {
            ui.closeScanner();
        }
    }
}