import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
          balance -= amount;
        }
    }

class ATM {
    public static void main(String[] args) {
        Account account1 = new Account("123", "Madhu", 10000);
        Account account2 = new Account("321", "Tae", 5000);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to XYZ Bank ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Transfer Cash");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance in account1 is: " + account1.getBalance());
                     System.out.println("Your current balance in account2 is:"+account2.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the amount you want to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if(account1.getBalance()< withdrawAmount)
                     { 
                         System.out.println("Insufficient funds");
                         break;
                     }
                    else{
                    account1.withdraw(withdrawAmount);
                    System.out.println("Successfully withdrew " + withdrawAmount + ". Your new balance is: " + account1.getBalance());
                    break;
                     }
                case 3:
                    System.out.print("Enter the amount you want to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account1.deposit(depositAmount);
                    System.out.println("Successfully deposited " + depositAmount + ". Your new balance is: " + account1.getBalance());
                    break;
                case 4:
                    System.out.print("Enter the amount you want to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    account1.withdraw(transferAmount);
                    account2.deposit(transferAmount);
                    System.out.println("Successfully transferred " + transferAmount + " from account " + account1.getAccountNumber() + " to account " + account2.getAccountNumber());
                    break;
                case 5:
                    System.out.println("Thank you for using XYZ Bank ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}