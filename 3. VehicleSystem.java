// Base class
class Vehicle {
    // Method to be overridden
    public void start() {
        System.out.println("Vehicle starting with a generic engine.");
    }

    // Common method for all vehicles
    public void displayInfo() {
        System.out.println("This is a vehicle.");
    }
}

// Derived class Car
class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car starting with a gasoline engine.");
    }

    @Override
    public void displayInfo() {
        System.out.println("This is a Car.");
    }
}

// Derived class Motorcycle
class Motorcycle extends Vehicle {
    @Override
    public void start() {
        System.out.println("Motorcycle starting with a two-stroke engine.");
    }

    @Override
    public void displayInfo() {
        System.out.println("This is a Motorcycle.");
    }
}

// Derived class Truck
class Truck extends Vehicle {
    @Override
    public void start() {
        System.out.println("Truck starting with a diesel engine.");
    }

    @Override
    public void displayInfo() {
        System.out.println("This is a Truck.");
    }
}

// Main class to demonstrate dynamic polymorphism
public class VehicleSystem {
    public static void main(String[] args) {
        // Creating objects of different vehicle types
        Vehicle vehicle1 = new Car();
        Vehicle vehicle2 = new Motorcycle();
        Vehicle vehicle3 = new Truck();

        // Demonstrating dynamic polymorphism
        System.out.println("Demonstrating vehicle start methods:");
        vehicle1.start(); // Calls Car's start method
        vehicle2.start(); // Calls Motorcycle's start method
        vehicle3.start(); // Calls Truck's start method

        // Demonstrating displayInfo methods
        System.out.println("\nDemonstrating vehicle information:");
        vehicle1.displayInfo(); // Calls Car's displayInfo method
        vehicle2.displayInfo(); // Calls Motorcycle's displayInfo method
        vehicle3.displayInfo(); // Calls Truck's displayInfo method

        // Using an array to store different vehicle types
        System.out.println("\nUsing array to demonstrate polymorphism:");
        Vehicle[] vehicles = {new Car(), new Motorcycle(), new Truck()};
        for (Vehicle v : vehicles) {
            v.start(); // Calls the appropriate start method based on the actual object type
        }
    }
}
