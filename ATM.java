import java.util.ArrayList;
import java.util.Scanner;

public class ATM{
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int balance = 1000; // starting balance is $1000
            int withdrawAmount, depositAmount, transferAmount;
            ArrayList<String> transactionHistory = new ArrayList<String>();

            // ATM interface
            System.out.println("Welcome to the ATM!");
            int choice = 0;

            while (choice != 5) {
                System.out.println("\nPlease select an option:");
                System.out.println("1. Check balance");
                System.out.println("2. Withdraw cash");
                System.out.println("3. Deposit cash");
                System.out.println("4. Transfer funds");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");

                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("\nYour current balance is $" + balance);
                        break;
                    case 2:
                        System.out.print("\nEnter amount to withdraw: $");
                        withdrawAmount = input.nextInt();

                        if (withdrawAmount > balance) {
                            System.out.println("\nInsufficient funds!");
                        } else {
                            balance -= withdrawAmount;
                            System.out.println("\nPlease take your cash.");
                            System.out.println("Your new balance is $" + balance);
                            transactionHistory.add("Withdraw: $" + withdrawAmount);
                        }
                        break;
                    case 3:
                        System.out.print("\nEnter amount to deposit: $");
                        depositAmount = input.nextInt();
                        balance += depositAmount;
                        System.out.println("\nDeposit successful!");
                        System.out.println("Your new balance is $" + balance);
                        transactionHistory.add("Deposit: $" + depositAmount);
                        break;
                    case 4:
                        System.out.print("\nEnter the amount to transfer: $");
                        transferAmount = input.nextInt();
                        if (transferAmount > balance) {
                            System.out.println("\nInsufficient funds!");
                        } else {
                            System.out.print("\nEnter the recipient's account number: ");
                            int recipientAccount = input.nextInt();
                            System.out.println("\nTransfer successful!");
                            System.out.println(
                                    "$" + transferAmount + " has been transferred to account number "
                                            + recipientAccount);
                            balance -= transferAmount;
                            transactionHistory.add("Transfer: $" + transferAmount + " to account " + recipientAccount);
                        }
                        break;
                    case 5:
                        System.out.println("\nThank you for using the ATM!");
                        break;
                    default:
                        System.out.println("\nInvalid choice!");
                        break;
                }
            }
            System.out.println("\nTransaction history:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}
