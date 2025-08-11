package Task5;
import java.util.ArrayList;
import java.util.List;

class Account {
    protected String accountHolder;
    protected double balance;
    protected List<String> transactionHistory;

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            System.out.println("Successfully withdrew: " + amount);
        } else {
            System.out.println("Invalid withdraw amount!");
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

// Savings Account inherits from Account
class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountHolder, double initialBalance, double interestRate) {
        super(accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    // Method overriding
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal not allowed from Savings Account!");
        }
    }

    public void addInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        transactionHistory.add("Interest added: " + interest);
        System.out.println("Interest of " + interest + " added.");
    }
}
