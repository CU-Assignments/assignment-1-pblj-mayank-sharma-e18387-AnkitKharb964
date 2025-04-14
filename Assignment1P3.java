import java.util.Scanner;

// BankAccount class using encapsulation
class BankAccount {
    private String name;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String name, String accountNumber, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Current Balance: " + balance);
        } else {
            System.out.println("Error: Invalid deposit amount.");
        }
    }

    // Withdraw method with overdraft protection
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Error: Insufficient funds. Current Balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! Current Balance: " + balance);
        }
    }
}

public class Assignment1P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Account creation
        System.out.println("Create Account:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Account Number: ");
        String accNo = scanner.nextLine();
        System.out.print("Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(name, accNo, initialBalance);

        // Operations
        while (true) {
            System.out.println("\nChoose Operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount to deposit: ");
                double amt = scanner.nextDouble();
                account.deposit(amt);
            } else if (choice == 2) {
                System.out.print("Enter amount to withdraw: ");
                double amt = scanner.nextDouble();
                account.withdraw(amt);
            } else if (choice == 3) {
                System.out.println("Current Balance: " + account.getBalance());
            } else if (choice == 4) {
                System.out.println("Thank you for using the banking system.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
