import java.util.Arrays;

// Class for printing numbers from 1 to 10
class NumberPrinter implements Runnable {
    private String threadName;

    public NumberPrinter(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(threadName + " printing: " + i);
                Thread.sleep(500); // Simulate some work with delay
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted: " + e.getMessage());
        }
        System.out.println(threadName + " completed.");
    }
}

// Class for calculating sum of an array
class ArraySumCalculator implements Runnable {
    private String threadName;
    private int[] array;
    private int sum;

    public ArraySumCalculator(String threadName, int[] array) {
        this.threadName = threadName;
        this.array = array;
        this.sum = 0;
    }

    @Override
    public void run() {
        try {
            for (int num : array) {
                sum += num;
                Thread.sleep(200); // Simulate some work with delay
            }
            System.out.println(threadName + " calculated sum: " + sum);
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted: " + e.getMessage());
        }
        System.out.println(threadName + " completed.");
    }

    public int getSum() {
        return sum;
    }
}

// Class for sorting an array
class ArraySorter implements Runnable {
    private String threadName;
    private int[] array;

    public ArraySorter(String threadName, int[] array) {
        this.threadName = threadName;
        this.array = array;
    }

    @Override
    public void run() {
        try {
            System.out.println(threadName + " original array: " + Arrays.toString(array));
            Arrays.sort(array);
            Thread.sleep(1000); // Simulate sorting time
            System.out.println(threadName + " sorted array: " + Arrays.toString(array));
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted: " + e.getMessage());
        }
        System.out.println(threadName + " completed.");
    }
}

// Main class to demonstrate thread-based multitasking
public class MultitaskingSystem {
    public static void main(String[] args) {
        // Create data for tasks
        int[] arrayForSum = {5, 2, 8, 1, 9};
        int[] arrayForSort = {5, 2, 8, 1, 9}; // Separate array to avoid data race

        // Create thread instances
        Thread numberPrinterThread = new Thread(new NumberPrinter("NumberPrinter"));
        Thread sumCalculatorThread = new Thread(new ArraySumCalculator("SumCalculator", arrayForSum));
        Thread arraySorterThread = new Thread(new ArraySorter("ArraySorter", arrayForSort));

        // Start all threads
        System.out.println("Starting all tasks...");
        numberPrinterThread.start();
        sumCalculatorThread.start();
        arraySorterThread.start();

        // Wait for all threads to complete
        try {
            numberPrinterThread.join();
            sumCalculatorThread.join();
            arraySorterThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        // Display final message
        System.out.println("All tasks completed.");
    }
}
