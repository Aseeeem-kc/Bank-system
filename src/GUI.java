import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.LinkedList;

public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField depositToField;
    private JTextField depositAmountField;
    private JTextField withdrawFromField;
    private JTextField withdrawAmountField;
    private JTextField fromAccountField;
    private JTextField toAccountField;
    private JTextField transferAmountField;
    private JTextField balanceAccountField;
    private JTextField balanceDisplay;
    private LinkedList<Account> globalAccounts;

    // setting up the gui layout
    public GUI(LinkedList<Account> accounts) {
        this.globalAccounts = accounts;

        // Load the background image
        Image backgroundImage = new ImageIcon("/home/ashim/IdeaProjects/ashim_khatrichhetri_2408241_OOPassessment/src/bankbackground.jpg").getImage();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 800);
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBorder(new EmptyBorder(30, 30, 30, 30));
        contentPane.setLayout(null);

        JLabel lblWelcome = new JLabel("WELCOME TO TRANSACTION APP");
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 24));
        lblWelcome.setForeground(Color.white);
        lblWelcome.setBounds(290, 35, 500, 50);
        contentPane.add(lblWelcome);

        JLabel desc = new JLabel("Safe Banking Transactions");
        desc.setFont(new Font("Arial", Font.BOLD, 12));
        desc.setForeground(Color.white);
        desc.setBounds(405, 55, 230, 50);
        contentPane.add(desc);

        // bottom section
        JLabel madewithlbl = new JLabel("Made using JAVA, Swing");
        madewithlbl.setFont(new Font("Arial", Font.BOLD, 14));
        madewithlbl.setForeground(Color.white);
        madewithlbl.setBounds(760, 680, 500, 50);
        contentPane.add(madewithlbl);

        JLabel myname = new JLabel("Ashim kc");
        myname.setFont(new Font("Arial", Font.BOLD, 12));
        myname.setForeground(Color.white);
        myname.setBounds(890, 700, 230, 50);
        contentPane.add(myname);


        // Deposit Section
        JLabel depositLabel = new JLabel("Deposit");
        depositLabel.setFont(new Font("Arial", Font.BOLD, 22));
        depositLabel.setForeground(Color.white);
        depositLabel.setBounds(120, 100, 200, 30);
        contentPane.add(depositLabel);

        JLabel depositToLabel = new JLabel("Deposit To:");
        depositToLabel.setForeground(Color.white);
        depositToLabel.setFont(new Font("Arial", Font.BOLD, 12));
        depositToLabel.setBounds(120, 150, 100, 30);
        contentPane.add(depositToLabel);

        depositToField = new JTextField();
        depositToField.setBounds(250, 150, 125, 26);
        contentPane.add(depositToField);
        depositToField.setColumns(10);

        JLabel depositAmountLabel = new JLabel("Amount:");
        depositAmountLabel.setForeground(Color.white);
        depositAmountLabel.setFont(new Font("Arial", Font.BOLD, 12));
        depositAmountLabel.setBounds(120, 210, 100, 30);
        contentPane.add(depositAmountLabel);

        depositAmountField = new JTextField();
        depositAmountField.setBounds(250, 210, 125, 26);
        contentPane.add(depositAmountField);
        depositAmountField.setColumns(10);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(e -> {
            String amountText = depositAmountField.getText();
            String acc1Text = depositToField.getText();
            if (amountText.isEmpty() || acc1Text.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                return;
            }

            double amount = Double.parseDouble(amountText);
            int acc1 = Integer.parseInt(acc1Text);

            for (Account account : globalAccounts) {
                if (acc1 == account.getAccountNum()) {
                    if (amount <= 0){
                        JOptionPane.showMessageDialog(null, "Please enter value greater than 0");
                    }else {
                        account.deposit(amount);
                        JOptionPane.showMessageDialog(null, "Deposited successfully!");
                        Main.updateCSV(accounts);
                        break;
                    }

                }
            }
        });
        depositButton.setFont(new Font("Arial", Font.BOLD, 13));
        depositButton.setForeground(Color.black);
        depositButton.setBackground(Color.white);
        depositButton.setOpaque(true);
        depositButton.setBounds(140, 270, 230, 50);
        contentPane.add(depositButton);

        // Withdraw Section
        JLabel withdrawLabel = new JLabel("Withdraw");
        withdrawLabel.setFont(new Font("Arial", Font.BOLD, 22));
        withdrawLabel.setForeground(Color.white);
        withdrawLabel.setBounds(120, 420, 200, 30);
        contentPane.add(withdrawLabel);

        JLabel withdrawFromLabel = new JLabel("Withdraw From:");
        withdrawFromLabel.setForeground(Color.white);
        withdrawFromLabel.setFont(new Font("Arial", Font.BOLD, 12));
        withdrawFromLabel.setBounds(120, 470, 120, 30);
        contentPane.add(withdrawFromLabel);

        withdrawFromField = new JTextField();
        withdrawFromField.setBounds(250, 470, 125, 26);
        contentPane.add(withdrawFromField);
        withdrawFromField.setColumns(10);

        JLabel withdrawAmountLabel = new JLabel("Amount:");
        withdrawAmountLabel.setForeground(Color.white);
        withdrawAmountLabel.setFont(new Font("Arial", Font.BOLD, 12));
        withdrawAmountLabel.setBounds(120, 530, 100, 30);
        contentPane.add(withdrawAmountLabel);

        withdrawAmountField = new JTextField();
        withdrawAmountField.setBounds(250, 530, 125, 26);
        contentPane.add(withdrawAmountField);
        withdrawAmountField.setColumns(10);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(e -> {
            String amountText = withdrawAmountField.getText();
            String acc1Text = withdrawFromField.getText();
            if (amountText.isEmpty() || acc1Text.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                return;
            }

            double amount = Double.parseDouble(amountText);
            int acc1 = Integer.parseInt(acc1Text);

            for (Account account : accounts) {
                if (acc1 == account.getAccountNum()) {
                    if (account.withdraw(amount)) {
                        JOptionPane.showMessageDialog(null, "Withdrawn successfully!");
                        Main.updateCSV(accounts);
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient funds!");
                    }
                    break;
                }
            }
        });
        withdrawButton.setForeground(Color.black);
        withdrawButton.setBackground(Color.white);
        withdrawButton.setOpaque(true);
        withdrawButton.setBounds(140, 600, 230, 50);
        contentPane.add(withdrawButton);

        // Transfer Section
        JLabel transferLabel = new JLabel("Transfer");
        transferLabel.setFont(new Font("Arial", Font.BOLD, 22));
        transferLabel.setForeground(Color.white);
        transferLabel.setBounds(640, 100, 200, 30);
        contentPane.add(transferLabel);

        JLabel fromAccountLabel = new JLabel("From Account:");
        fromAccountLabel.setForeground(Color.white);
        fromAccountLabel.setFont(new Font("Arial", Font.BOLD, 12));
        fromAccountLabel.setBounds(640, 140, 120, 30);
        contentPane.add(fromAccountLabel);

        fromAccountField = new JTextField();
        fromAccountField.setBounds(750, 140, 125, 26);
        contentPane.add(fromAccountField);
        fromAccountField.setColumns(10);

        JLabel toAccountLabel = new JLabel("To Account:");
        toAccountLabel.setForeground(Color.white);
        toAccountLabel.setFont(new Font("Arial", Font.BOLD, 12));
        toAccountLabel.setBounds(640, 180, 120, 30);
        contentPane.add(toAccountLabel);

        toAccountField = new JTextField();
        toAccountField.setBounds(750, 180, 125, 26);
        contentPane.add(toAccountField);
        toAccountField.setColumns(10);

        JLabel transferAmountLabel = new JLabel("Amount:");
        transferAmountLabel.setForeground(Color.white);
        transferAmountLabel.setFont(new Font("Arial", Font.BOLD, 12));
        transferAmountLabel.setBounds(640, 220, 100, 30);
        contentPane.add(transferAmountLabel);

        transferAmountField = new JTextField();
        transferAmountField.setBounds(750, 220, 125, 26);
        contentPane.add(transferAmountField);
        transferAmountField.setColumns(10);

        JButton transferButton = new JButton("Transfer");
        transferButton.addActionListener(e -> {
            String amountText = transferAmountField.getText();
            String fromAccountText = fromAccountField.getText();
            String toAccountText = toAccountField.getText();

            if (amountText.isEmpty() || fromAccountText.isEmpty() || toAccountText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                return;
            }

            double amount = Double.parseDouble(amountText);
            int fromAccountNum = Integer.parseInt(fromAccountText);
            int toAccountNum = Integer.parseInt(toAccountText);

            Account fromAccount = null;
            Account toAccount = null;

            for (Account acc : globalAccounts) {
                if (acc.getAccountNum() == fromAccountNum) {
                    fromAccount = acc;
                }
                if (acc.getAccountNum() == toAccountNum) {
                    toAccount = acc;
                }
            }

            if (fromAccount != null && toAccount != null) {
                if (fromAccount.getBalance() >= amount) {
                    Transaction transaction = new Transaction();
                    if (transaction.transfer(fromAccount, toAccount, amount)) {
                        JOptionPane.showMessageDialog(null, "Transfer successful!");
                        Main.updateCSV(accounts);
                    } else {
                        JOptionPane.showMessageDialog(null, "Transfer failed!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient funds in the sender's account!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "One or both account numbers are invalid!");
            }
        });
        transferButton.setForeground(Color.black);
        transferButton.setBackground(Color.white);
        transferButton.setOpaque(true);
        transferButton.setBounds(650, 270, 230, 50);
        contentPane.add(transferButton);

        // title for balance section
        JLabel blctitlelabel = new JLabel("Check Balance");
        blctitlelabel.setFont(new Font("Arial", Font.BOLD, 22));
        blctitlelabel.setForeground(Color.white);
        blctitlelabel.setBounds(640, 420, 200, 30);
        contentPane.add(blctitlelabel);

        // Balance Section
        JLabel balanceAccountLabel = new JLabel("Account No:");
        balanceAccountLabel.setForeground(Color.white);
        balanceAccountLabel.setFont(new Font("Arial", Font.BOLD, 12));
        balanceAccountLabel.setBounds(640, 470, 120, 30);
        contentPane.add(balanceAccountLabel);

        balanceAccountField = new JTextField();
        balanceAccountField.setBounds(750, 470, 125, 26);
        contentPane.add(balanceAccountField);
        balanceAccountField.setColumns(10);

        JLabel balanceLabel = new JLabel("Balance:");
        balanceLabel.setForeground(Color.white);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 12));
        balanceLabel.setBounds(640, 530, 100, 30);
        contentPane.add(balanceLabel);

        balanceDisplay = new JTextField();
        balanceDisplay.setFont(new Font("Arial", Font.BOLD, 11));
        balanceDisplay.setBounds(750, 530, 125, 26);
        balanceDisplay.setEditable(false);
        contentPane.add(balanceDisplay);

        JButton balanceButton = new JButton("Balance");
        balanceButton.setFont(new Font("Arial", Font.BOLD, 12));
        balanceButton.addActionListener(e -> {
            String acc1Text = balanceAccountField.getText();
            if (acc1Text.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an account number.");
                return;
            }

            int accountNum = Integer.parseInt(acc1Text);
            Account account = null;
            for (Account acc : globalAccounts) {
                if (acc.getAccountNum() == accountNum) {
                    account = acc;
                    break;
                }
            }
            if (account != null) {
                balanceDisplay.setText(Double.toString(account.getBalance()));
            } else {
                JOptionPane.showMessageDialog(null, "Account not found!");
            }
        });
        balanceButton.setForeground(Color.black);
        balanceButton.setBackground(Color.white);
        balanceButton.setOpaque(true);
        balanceButton.setBounds(650, 600, 230, 50);
        contentPane.add(balanceButton);

        // View Accounts Section
        JButton viewAccountsButton = new JButton("View Accounts");
        viewAccountsButton.setFont(new Font("Arial", Font.BOLD, 12));
        viewAccountsButton.addActionListener(e -> {
            String[] columnNames = {"First Name", "Last Name", "Account Number", "Balance"};
            Object[][] data = new Object[globalAccounts.size()][4];
            for (int i = 0; i < globalAccounts.size(); i++) {
                Account acc = globalAccounts.get(i);
                data[i][0] = acc.getFirstName();
                data[i][1] = acc.getLastName();
                data[i][2] = acc.getAccountNum();
                data[i][3] = acc.getBalance();
            }

            contentPane.removeAll();
            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(200, 110, 600, 400);
            contentPane.add(scrollPane);

            JLabel tableTitle = new JLabel("Account Details");
            tableTitle.setFont(new Font("Arial", Font.BOLD, 18));
            tableTitle.setForeground(Color.white);
            tableTitle.setBounds(400, 35, 230, 50);
            contentPane.add(tableTitle);

            JButton backButton = new JButton("Back to Home");
            backButton.setBounds(410, 540, 150, 30);
            backButton.addActionListener(event -> {
                dispose();
                new GUI(globalAccounts).setVisible(true);
            });
            contentPane.add(backButton);

            contentPane.revalidate();
            contentPane.repaint();
        });
        viewAccountsButton.setForeground(Color.black);
        viewAccountsButton.setBackground(Color.white);
        viewAccountsButton.setOpaque(true);
        viewAccountsButton.setBounds(380, 680, 230, 50);
        contentPane.add(viewAccountsButton);

        setContentPane(contentPane);
    }
}
