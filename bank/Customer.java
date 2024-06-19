public class Customer {
    private String name;
    private Account account;

    public Customer(String name, double initialDeposit) {
        this.name = name;
        this.account = new Account(initialDeposit);
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }
}
