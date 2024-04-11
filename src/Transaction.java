class Transaction {
    void transfer(Account fromAccount, int fromAccNo, Account toAccount, int toAccNo, int amount) {
        // Check if the provided account numbers match the actual accounts
        if (fromAccount.accNo == fromAccNo && toAccount.accNo == toAccNo) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transfer successful");
        } else {
            System.out.println("Invalid account numbers");
        }
    }
}
