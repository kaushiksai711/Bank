import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
    }

    public void addCustomer(String name, double initialDeposit) {
        Customer newCustomer = new Customer(name, initialDeposit);
        customers.add(newCustomer);
        System.out.println("Customer added: " + name);
    }

    public Customer getCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add new customer");
            System.out.println("2. Perform transaction for existing customer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double initialDeposit = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    bank.addCustomer(name, initialDeposit);
                    break;

                case 2:
                    System.out.print("Enter customer name: ");
                    String existingName = scanner.nextLine();
                    Customer customer = bank.getCustomer(existingName);
                    if (customer != null) {
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Check balance");
                        System.out.print("Enter your choice: ");
                        int transactionChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (transactionChoice) {
                            case 1:
                                System.out.print("Enter amount to deposit: ");
                                double depositAmount = scanner.nextDouble();
                                scanner.nextLine(); // Consume newline
                                customer.getAccount().deposit(depositAmount);
                                break;

                            case 2:
                                System.out.print("Enter amount to withdraw: ");
                                double withdrawAmount = scanner.nextDouble();
                                scanner.nextLine(); // Consume newline
                                customer.getAccount().withdraw(withdrawAmount);
                                break;

                            case 3:
                                System.out.println("Current balance: " + customer.getAccount().getBalance());
                                break;

                            default:
                                System.out.println("Invalid choice.");
                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
