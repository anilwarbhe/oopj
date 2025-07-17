public class Calculator {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    // Method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }

    // Method to add an array of integers
    public int add(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    // Method to add an array of doubles
    public double add(double[] numbers) {
        double sum = 0.0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }

    // Main method to demonstrate method overloading
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Adding two integers
        System.out.println("Sum of two integers (5, 10): " + calc.add(5, 10));

        // Adding three integers
        System.out.println("Sum of three integers (5, 10, 15): " + calc.add(5, 10, 15));

        // Adding two doubles
        System.out.println("Sum of two doubles (5.5, 10.7): " + calc.add(5.5, 10.7));

        // Adding an array of integers
        int[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Sum of integer array {1, 2, 3, 4, 5}: " + calc.add(intArray));

        // Adding an array of doubles
        double[] doubleArray = {1.1, 2.2, 3.3};
        System.out.println("Sum of double array {1.1, 2.2, 3.3}: " + calc.add(doubleArray));
    }
}
