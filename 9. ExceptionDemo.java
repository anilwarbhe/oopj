public class ExceptionDemo {
    // Method that may throw different types of exceptions
    public static void processData(String[] data, int index, int divisor) {
        try {
            // Potential NullPointerException if data is null
            if (data == null) {
                throw new NullPointerException("Data array is null");
            }

            // Potential ArrayIndexOutOfBoundsException if index is invalid
            String value = data[index];

            // Potential ArithmeticException if divisor is zero
            int number = Integer.parseInt(value);
            int result = number / divisor;

            System.out.println("Result of division: " + result);
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Error: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Error: Invalid index " + index);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: Division by zero is not allowed");
        } catch (NumberFormatException e) {
            System.out.println("Number Format Error: Cannot convert string to integer");
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } finally {
            System.out.println("Data processing attempt completed.");
        }
    }

    public static void main(String[] args) {
        // Test case 1: Valid input
        System.out.println("Test Case 1: Valid input");
        String[] validData = {"10", "20", "30"};
        processData(validData, 1, 2);

        // Test case 2: Null array (NullPointerException)
        System.out.println("\nTest Case 2: Null array");
        String[] nullData = null;
        processData(nullData, 0, 1);

        // Test case 3: Invalid index (ArrayIndexOutOfBoundsException)
        System.out.println("\nTest Case 3: Invalid index");
        processData(validData, 5, 2);

        // Test case 4: Division by zero (ArithmeticException)
        System.out.println("\nTest Case 4: Division by zero");
        processData(validData, 0, 0);

        // Test case 5: Invalid number format (NumberFormatException)
        System.out.println("\nTest Case 5: Invalid number format");
        String[] invalidData = {"abc", "20", "30"};
        processData(invalidData, 0, 2);
    }
}
