import java.util.Random;
class Account {
    private static int lastAssignedAccountNumber = 1000;
    public int accNo;
    private int accBalance;
    private Customer customer;

    Account(Customer customer, int initialBalance) {
        customer = customer;
        accNo = ++lastAssignedAccountNumber;
        accBalance = initialBalance;
    }


    void deposit(int amount) {
        accBalance += amount;
    }

    void withdraw(int amount) {
        if (accBalance >= amount) {
            accBalance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    int getBalance() {
        return accBalance;
    }

    void transfer(Account fromAccount, Account toAccount, int amount) {
        if (fromAccount.accBalance >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transfer successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }
}