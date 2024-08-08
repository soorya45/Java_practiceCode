import java.util.Scanner;
class Shape {
    protected double dim1;
    protected double dim2;
    public Shape() {
        dim1 = 0.0;
        dim2 = 0.0;
    }
    public Shape(double dimension1, double dimension2) {
        this.dim1 = dimension1;
        this.dim2 = dimension2;
    }
    public double getDimension1() {
        return dim1;
    }
    public void setDimension1(double dimension1) {
        this.dim1 = dimension1;
    }
    public double getDimension2() {
        return dim2;
    }
    public void setDimension2(double dimension2) {
        this.dim2 = dimension2;
    }
    public double findArea() {
        return 0.0; 
    }
    public void displayArea() {
        System.out.println("Area: " + findArea());
    }
}
class Triangle extends Shape {
    public Triangle(double base, double height) {
        super(base, height);
    }

    @Override
    public double findArea() {
        return 0.5 * dim1 * dim2;
    }

    @Override
    public void displayArea() {
        System.out.println("Triangle Area: " + findArea());
    }
}
class Rectangle extends Shape {
    public Rectangle(double length, double width) {
        super(length, width);
    }

    @Override
    public double findArea() {
        return dim1 * dim2;
    }

    @Override
    public void displayArea() {
        System.out.println("Rectangle Area: " + findArea());
    }
}

public class ex5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double dimension1, dimension2;

        do {
            System.out.println("Menu:");
            System.out.println("1. Calculate Triangle Area");
            System.out.println("2. Calculate Rectangle Area");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the base of the triangle: ");
                    dimension1 = scanner.nextDouble();
                    System.out.print("Enter the height of the triangle: ");
                    dimension2 = scanner.nextDouble();
                    Shape triangle = new Triangle(dimension1, dimension2);
                    triangle.displayArea();
                    break;

                case 2:
                    System.out.print("Enter the length of the rectangle: ");
                    dimension1 = scanner.nextDouble();
                    System.out.print("Enter the width of the rectangle: ");
                    dimension2 = scanner.nextDouble();
                    Shape rectangle = new Rectangle(dimension1, dimension2);
                    rectangle.displayArea();
                    break;

                case 3:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }
}