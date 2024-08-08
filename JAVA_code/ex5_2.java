import java.util.Scanner;
class CashTree {
    protected String name;
    protected int codeno;
    protected String location;
    protected double balance;

    public CashTree(String name, int codeno, String location) {
        this.name = name;
        this.codeno = codeno;
        this.location = location;
        this.balance = 0.0;
    }

    public double viewBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// Subclass - SBI_Bank
class SBI_Bank extends CashTree {
    private double serviceCharge;
    private double interestRate;
    private double maxWithdrawalLimit;

    public SBI_Bank(String name, int codeno, String location) {
        super(name, codeno, location);
        this.serviceCharge = 1.5; 
        this.interestRate = 4.0; 
        this.maxWithdrawalLimit = 50000.0; 
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= maxWithdrawalLimit) {
            double withdrawalAmount = amount + (amount * (serviceCharge / 100.0));
            if (withdrawalAmount <= balance) {
                balance -= withdrawalAmount;
                return true;
            }
        }
        return false;
    }
}
class HDFC_Bank extends CashTree {
    private double serviceCharge;
    private double interestRate;
    private double maxWithdrawalLimit;

    public HDFC_Bank(String name, int codeno, String location) {
        super(name, codeno, location);
        this.serviceCharge = 2.0; 
        this.interestRate = 3.5; 
        this.maxWithdrawalLimit = 60000.0; 
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= maxWithdrawalLimit) {
            double withdrawalAmount = amount + (amount * (serviceCharge / 100.0));
            if (withdrawalAmount <= balance) {
                balance -= withdrawalAmount;
                return true;
            }
        }
        return false;
    }
}

public class ex5_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CashTree sbiATM = new SBI_Bank("SBI ATM", 101, "SBI Branch A");
        CashTree hdfcATM = new HDFC_Bank("HDFC ATM", 201, "HDFC Branch B");

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. SBI Bank");
            System.out.println("2. HDFC Bank");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    operateATM(sbiATM);
                    break;
                case 2:
                    operateATM(hdfcATM);
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

    public static void operateATM(CashTree atm) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nATM Options:");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Balance: $" + atm.viewBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    boolean success = atm.withdraw(withdrawalAmount);
                    if (success) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Withdrawal failed. Insufficient balance or exceeded limit.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (option != 4);
    }
}
