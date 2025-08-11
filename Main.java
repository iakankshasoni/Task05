package Task5;
public class Main {
    public static void main(String[] args) {
        SavingsAccount myAccount = new SavingsAccount("Akanksha Soni", 5000, 5);

        myAccount.displayBalance();
        myAccount.deposit(1500);
        myAccount.withdraw(2000);
        myAccount.addInterest();
        myAccount.displayBalance();

        myAccount.showTransactionHistory();
    }
}
