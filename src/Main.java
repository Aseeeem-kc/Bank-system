import java.awt.*;
import java.io.*;
import java.util.LinkedList;

class ReadAccount {

    private String filePath;
    private LinkedList<String> firstNames;
    private LinkedList<String> lastNames;
    private LinkedList<Integer> accountNumbers;
    private LinkedList<Double> balances;

    public ReadAccount(String s) throws IOException {
        this.filePath = "accounts.csv";

        // linked list initialization for account details
        firstNames = new LinkedList<>();
        lastNames = new LinkedList<>();
        accountNumbers = new LinkedList<>();
        balances = new LinkedList<>();

        // Read the file
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new FileNotFoundException("File not found: " + filePath);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;

            // Read lines for account data
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                firstNames.add(values[0]);
                lastNames.add(values[1]);
                accountNumbers.add(Integer.parseInt(values[2]));
                try {
                    balances.add(Double.parseDouble(values[3]));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid balance format in a row: " + line);
                }
            }
        }
    }

    // Getter methods for LinkedLists
    public LinkedList<String> getFirstNames() {
        return firstNames;
    }

    public LinkedList<String> getLastNames() {
        return lastNames;
    }

    public LinkedList<Integer> getAccountNumbers() {
        return accountNumbers;
    }

    public LinkedList<Double> getBalances() {
        return balances;
    }
}

// Customer class
class Customer {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }
}

// Account class
class Account extends Customer {
    private int accountNumber;
    private double balance;

    public Account(String fName, String lName, int accountNumber, double balance) {
        setFirstName(fName);
        setLastName(lName);
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNum() {
        return accountNumber;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// Transaction class
class Transaction {
    public boolean transfer(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        } else {
            return false;
        }
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        // Create a ReadAccount object to read account information from CSV
        ReadAccount readAccounts;
        LinkedList<Account> accounts = new LinkedList<>();

        try {
            readAccounts = new ReadAccount("/home/ashim/IdeaProjects/ashim_khatrichhetri_2408241_OOPassessment/src/accounts.csv");

            LinkedList<String> firstNames = readAccounts.getFirstNames();
            LinkedList<String> lastNames = readAccounts.getLastNames();
            LinkedList<Integer> accountNumbers = readAccounts.getAccountNumbers();
            LinkedList<Double> balances = readAccounts.getBalances();

            // Create accounts based on CSV data
            for (int i = 0; i < accountNumbers.size(); i++) {
                accounts.add(new Account(
                        firstNames.get(i),
                        lastNames.get(i),
                        accountNumbers.get(i),
                        balances.get(i)
                ));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set up GUI
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI(accounts);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    // Method to update the CSV file after each transaction
    public static void updateCSV(LinkedList<Account> accounts) {
        try {
            FileWriter writer = new FileWriter("/home/ashim/IdeaProjects/ashim_khatrichhetri_2408241_OOPassessment/src/accounts.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (Account account : accounts) {
                bufferedWriter.write(account.getFirstName() + "," + account.getLastName() + "," +
                        account.getAccountNum() + "," + account.getBalance() + "\n");
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
}}
