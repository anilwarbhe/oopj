// Abstract base class Shape
abstract class Shape {
    // Final variable - cannot be modified
    protected final String SHAPE_TYPE;

    // Constructor
    public Shape(String shapeType) {
        this.SHAPE_TYPE = shapeType;
    }

    // Abstract method - must be implemented by subclasses
    public abstract void draw();

    // Final method - cannot be overridden
    public final void displayType() {
        System.out.println("Shape Type: " + SHAPE_TYPE);
    }

    // Common method for all shapes
    public void describe() {
        System.out.println("This is a " + SHAPE_TYPE + " shape.");
    }
}

// Concrete class Circle extending Shape
class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    // Implementing abstract draw method
    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius: " + radius);
    }
}

// Final class Rectangle - cannot be extended
final class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    // Implementing abstract draw method
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with length: " + length + " and width: " + width);
    }
}

// Main class to demonstrate abstract and final modifiers
public class ShapeHierarchy {
    public static void main(String[] args) {
        // Create instances of Circle and Rectangle
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(10.0, 6.0);

        // Demonstrate polymorphism and abstract method implementation
        System.out.println("Demonstrating Circle:");
        circle.displayType(); // Calls final method
        circle.describe();   // Calls common method
        circle.draw();       // Calls Circle's draw method

        System.out.println("\n----------------------------\n");

        System.out.println("Demonstrating Rectangle:");
        rectangle.displayType(); // Calls final method
        rectangle.describe();   // Calls common method
        rectangle.draw();       // Calls Rectangle's draw method

        // Demonstrating polymorphism with an array of shapes
        System.out.println("\n----------------------------\n");
        System.out.println("Demonstrating Polymorphism:");
        Shape[] shapes = {circle, rectangle};
        for (Shape shape : shapes) {
            System.out.println("\nProcessing shape:");
            shape.draw(); // Calls appropriate draw method based on actual object type
        }

        // Attempting to extend Rectangle would cause a compilation error
        // class ExtendedRectangle extends Rectangle {} // This would not compile

        // Attempting to modify SHAPE_TYPE would cause a compilation error
        // circle.SHAPE_TYPE = "Oval"; // This would not compile
    }
}
