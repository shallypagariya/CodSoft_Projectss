


import java.util.*;

public class Task3 {
    
    
    static class Account {
        private double balance;
        private int accountNumber;
        private int pin;

        public Account(int accountNumber, int pin, double initialBalance) {
            this.accountNumber = accountNumber;
            this.pin = pin;
            this.balance = initialBalance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public boolean validatePIN(int enteredPin) {
            return this.pin == enteredPin;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit successful!");
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful!");
            } else {
                System.out.println("Insufficient funds or invalid amount.");
            }
        }
    }
    

    public static void main(String[] args) {
        Map<Integer, Account> accounts = new HashMap<>();
        
        //Sample Accounts
        accounts.put(12345, new Account(12345, 1234, 1000.0));
        accounts.put(67890, new Account(67890, 5678, 2000.0));
        accounts.put(11111, new Account(11111, 1111, 500.0));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");

        System.out.print("Enter your account number: ");
        int accountNumber = scanner.nextInt();

        Account account = accounts.get(accountNumber);

        if (account != null) {
            System.out.print("Enter your PIN: ");
            int pin = scanner.nextInt();

            if (account.validatePIN(pin)) {
                int choice;
                do {
                    System.out.println("\nATM Menu:");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Exit");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Your balance is: $" + account.getBalance());
                            break;
                        case 2:
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                            break;
                        case 3:
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = scanner.nextDouble();
                            account.withdraw(withdrawAmount);
                            break;
                        case 4:
                            System.out.println("Thank you for using the ATM. Goodbye!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } while (choice != 4);
            } else {
                System.out.println("Incorrect PIN. Please try again.");
            }
        } else {
            System.out.println("Account not found. Please check the account number.");
        }

        scanner.close();
    }
}
