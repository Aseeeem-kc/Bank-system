import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReadAccounts reader = new ReadAccounts("src/bank_data.csv");

        ArrayList<String> firstNames = reader.getFirstNames();
        ArrayList<String> lastNames = reader.getLastNames();
        ArrayList<Integer> accountNumbers = reader.getAccountNumbers();
        ArrayList<Integer> balances = reader.getBalances();

        // Displaying the read data
        for (int i = 0; i < firstNames.size(); i++) {
            System.out.println("First Name: " + firstNames.get(i));
            System.out.println("Last Name: " + lastNames.get(i));
            System.out.println("Account Number: " + accountNumbers.get(i));
            System.out.println("Balance: " + balances.get(i));
            System.out.println();
        }

        Customer customer2 = new Customer("Ashim", "KC");

        // Create a new Account for Ashim KC with an initial balance of 10000
        Account account2 = new Account(customer2, 10000);

        // Display the account details
        System.out.println("Account created for " + customer2.firstName + " " + customer2.lastName);
        System.out.println("Account Number: " + account2.accNo);
        System.out.println("Initial Balance: " + account2.getBalance());

        Customer customer3 = new Customer("Ashim", "KC");

        // Create a new Account for Ashim KC with an initial balance of 10000
        Account account3 = new Account(customer2, 10000);

        // Display the account details
        System.out.println("Account created for " + customer2.firstName + " " + customer2.lastName);
        System.out.println("Account Number: " + account3.accNo);
        System.out.println("Initial Balance: " + account3.getBalance());
    }
}