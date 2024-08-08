import pkg1.Account;
import pkg2.SavingsAccount;
import pkg2.CurrentAccount;

import java.util.Scanner;

public class Test6_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SavingsAccount savingsAccount = new SavingsAccount("URK22AI1023", "Soorya", 0.03);
        CurrentAccount currentAccount = new CurrentAccount("URK23AI1023", "S@123", 1000.0);

        while (true) {
            System.out.println("Banking Operations Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scan.nextDouble();
                    savingsAccount.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scan.nextDouble();
                    currentAccount.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("Savings Account Balance: $" + savingsAccount.getBalance());
                    System.out.println("Current Account Balance: $" + currentAccount.getBalance());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scan.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}