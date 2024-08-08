import java.util.Scanner;

class NumException extends Exception {
    NumException(String message) {
        super(message);
    }
}

class NegativeException extends Exception {
    NegativeException(String message) {
        super(message);
    }
}

public class Test7_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            int n = scanner.nextInt();

            if (n % 2 != 0) {
                throw new NumException("It is odd");
            }

            System.out.print("Enter another number: ");
            int pn = scanner.nextInt();

            if (pn < 0) {
                throw new NegativeException("It is negative");
            }

        } catch (NumException e) {
            System.out.println("Odd Exception: " + e.getMessage());
        } catch (NegativeException e) {
            System.out.println("Negative Exception: " + e.getMessage());
        }
    }
}
