package el;

import java.util.Scanner;

public class excp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            double[] values = new double[2];

            for (int i = 0; i < 2; i++) {
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("Enter value " + (i + 1) + ": ");
                        values[i] = Double.parseDouble(scanner.nextLine());
                        validInput = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                }
            }

            boolean validChoice = false;
            while (!validChoice) {
                try {
                    System.out.println("Select an operation:");
                    System.out.println("1. Addition");
                    System.out.println("2. Subtraction");
                    System.out.println("3. Multiplication");
                    System.out.println("4. Division");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice (1/2/3/4/5): ");
                    int choice = Integer.parseInt(scanner.nextLine());

                    if (choice == 5) {
                        System.out.println("Exiting the program.");
                        scanner.close();
                        System.exit(0);
                    }

                    double result = 0.0;

                    switch (choice) {
                        case 1:
                            result = values[0] + values[1];
                            System.out.println("Result: " + result);
                            validChoice = true;
                            break;
                        case 2:
                            result = values[0] - values[1];
                            System.out.println("Result: " + result);
                            validChoice = true;
                            break;
                        case 3:
                            result = values[0] * values[1];
                            System.out.println("Result: " + result);
                            validChoice = true;
                            break;
                        case 4:
                            if (values[1] == 0) {
                                throw new ArithmeticException("Division by zero is not allowed.");
                            }
                            result = values[0] / values[1];
                            System.out.println("Result: " + result);
                            validChoice = true;
                            break;
                        default:
                            System.out.println("Invalid choice. Please select a valid operation (1/2/3/4/5).");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice. Please enter a valid number (1/2/3/4/5).");
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
