import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposite(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + "sucessful.Current balance:$" + balance);
        } else {
            System.out.println("Invaild deposir amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("withdrawal of $" + amount + " sucessful.Current balance: $" + balance);
        } else {
            System.out.println("Invaid withdeawal amount or insufficent balance.");
        }
    }

}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;

    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. withdraw");
        System.out.println("Exit");

    }

    public void performTransaction(int choic, Scanner scanner) {
        int Choice = 0;
        switch (Choice) {
            case 1:
                System.out.println("Current balance: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount :$");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposite(depositAmount);
                break;
            case 3:
                System.out.println("Enter withdrawal amount:$");
                double withdrawalAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Exiting ATM.THANKS U!");
                scanner.close();
                System.exit(0);

            default:
                System.out.println("Invaild choice.Please select a vaild option");

        }
    }

}

public class ATM_Interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter intial account balance: $");
        double initialBalance = scanner.nextDouble();
        BankAccount bankAccount = new BankAccount(initialBalance);

        ATM atm = new ATM(bankAccount);

        while (true) {
            atm.displayMenu();
            System.out.println("Select an option:");
            int choice = scanner.nextInt();

            atm.performTransaction(choice, scanner);
        }
    }

}