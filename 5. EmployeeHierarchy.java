// Base Employee class
abstract class Employee {
    // Common attributes for all employees
    protected String employeeId;
    protected String name;
    protected double baseSalary;

    // Constructor
    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Abstract method to calculate salary (to be implemented by subclasses)
    public abstract double calculateSalary();

    // Common method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
    }
}

// FullTimeEmployee class inheriting from Employee
class FullTimeEmployee extends Employee {
    private double bonusPercentage; // Additional attribute for full-time employees

    // Constructor
    public FullTimeEmployee(String employeeId, String name, double baseSalary, double bonusPercentage) {
        super(employeeId, name, baseSalary);
        this.bonusPercentage = bonusPercentage;
    }

    // Implementing calculateSalary for full-time employees
    @Override
    public double calculateSalary() {
        return baseSalary + (baseSalary * bonusPercentage / 100);
    }

    // Overriding displayDetails to include full-time specific information
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Employee Type: Full-Time");
        System.out.println("Bonus Percentage: " + bonusPercentage + "%");
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

// PartTimeEmployee class inheriting from Employee
class PartTimeEmployee extends Employee {
    private int hoursWorked; // Additional attribute for part-time employees
    private double hourlyRate;

    // Constructor
    public PartTimeEmployee(String employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Implementing calculateSalary for part-time employees
    @Override
    public double calculateSalary() {
        return baseSalary + (hoursWorked * hourlyRate);
    }

    // Overriding displayDetails to include part-time specific information
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Employee Type: Part-Time");
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

// Main class to demonstrate the employee hierarchy
public class EmployeeHierarchy {
    public static void main(String[] args) {
        // Creating a full-time employee
        Employee fullTimeEmp = new FullTimeEmployee("FT001", "John Doe", 50000.0, 10.0);
        System.out.println("Full-Time Employee Details:");
        fullTimeEmp.displayDetails();

        System.out.println("\n----------------------------\n");

        // Creating a part-time employee
        Employee partTimeEmp = new PartTimeEmployee("PT001", "Jane Smith", 20000.0, 20, 25.0);
        System.out.println("Part-Time Employee Details:");
        partTimeEmp.displayDetails();

        // Demonstrating polymorphism with an array of employees
        System.out.println("\n----------------------------\n");
        System.out.println("Demonstrating Polymorphism:");
        Employee[] employees = {fullTimeEmp, partTimeEmp};
        for (Employee emp : employees) {
            System.out.println("\nEmployee Salary Calculation:");
            System.out.println("Salary: $" + emp.calculateSalary());
        }
    }
}
