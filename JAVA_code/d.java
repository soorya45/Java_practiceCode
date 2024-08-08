public class OverloadingExample {

    private String name;
    private int age;

    // Default constructor
    public OverloadingExample() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Constructor with name parameter
    public OverloadingExample(String name) {
        this.name = name;
        this.age = 0;
    }

    // Constructor with name and age parameters
    public OverloadingExample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method with two int parameters
    public int add(int a, int b) {
        return a + b;
    }

    // Method with three int parameters
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method with two double parameters
    public double add(double a, double b) {
        return a + b;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        OverloadingExample example1 = new OverloadingExample();
        OverloadingExample example2 = new OverloadingExample("John");
        OverloadingExample example3 = new OverloadingExample("Alice", 25);

        example1.displayInfo();
        example2.displayInfo();
        example3.displayInfo();

        System.out.println("Sum of two integers: " + example1.add(3, 5));
        System.out.println("Sum of three integers: " + example1.add(3, 5, 7));
        System.out.println("Sum of two doubles: " + example1.add(2.5, 3.5));
    }
}
