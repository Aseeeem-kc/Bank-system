import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class ReadAccounts {
    private ArrayList<String> firstNames = new ArrayList<>();
    private ArrayList<String> lastNames = new ArrayList<>();
    private ArrayList<Integer> accountNumbers = new ArrayList<>();
    private ArrayList<Integer> balances = new ArrayList<>();

    ReadAccounts(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                firstNames.add(data[0]);
                lastNames.add(data[1]);
                accountNumbers.add(Integer.parseInt(data[2]));
                balances.add(Integer.parseInt(data[3]));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    ArrayList<String> getFirstNames() {
        return firstNames;
    }

    ArrayList<String> getLastNames() {
        return lastNames;
    }

    ArrayList<Integer> getAccountNumbers() {
        return accountNumbers;
    }

    ArrayList<Integer> getBalances() {
        return balances;
    }
}
