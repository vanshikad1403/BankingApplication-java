import java.util.Scanner;
class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private String email;
    private String phoneNumber;

    public Account(int accountNumber, String accountHolderName, double balance, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully. New Balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Amount withdrawn successfully. Remaining Balance: " + balance);
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Withdrawal amount must be positive!");
        }
    }

    public void displayAccountDetails() {
        System.out.println("---- Account Details ----");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("--------------------------");
    }

    public void updateContactDetails(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Contact details updated successfully!");
    }
}
public class BankingApplication {
    private Account[] accounts;
    private int accountCount;
    private Scanner sc;

    public BankingApplication() {
        accounts = new Account[100]; 
        accountCount = 0;
        sc = new Scanner(System.in);
    }

    private Account findAccount(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    public void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double balance = sc.nextDouble();
        sc.nextLine(); 
        System.out.print("Enter email address: ");
        String email = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        int accountNumber = 1000 + accountCount + 1;
        accounts[accountCount++] = new Account(accountNumber, name, balance, email, phone);

        System.out.println("Account created successfully with Account Number: " + accountNumber);
    }

    public void performDeposit() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter deposit amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); 

        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); 

        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine(); 

        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.displayAccountDetails();
        } else {
            System.out.println("Account not found!");
        }
    }

    public void updateContact() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter new email address: ");
        String email = sc.nextLine();
        System.out.print("Enter new phone number: ");
        String phone = sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.updateContactDetails(email, phone);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void mainMenu() {
        int choice;
        do {
            System.out.println("\n===== Welcome to the Banking Application =====");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1: createAccount(); break;
                case 2: performDeposit(); break;
                case 3: performWithdrawal(); break;
                case 4: showAccountDetails(); break;
                case 5: updateContact(); break;
                case 6: System.out.println("Thank you for using the Banking Application!"); break;
                default: System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    public static void main(String[] args) {
        BankingApplication app = new BankingApplication();
        app.mainMenu();
    }
}


