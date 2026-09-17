package encapsulamento.exercicios.exerc01.entities;

public class Account {
    private int accountNumber; // Nunca poderá ser alterado
    private String accountHolderName;
    private double accountBalance; // Não pode ser alterado livremente
    private static final double BANK_FEE = 5.00;

    public Account(int accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = 0.00;
    }

    public Account(int accountNumber, String accountHolderName, double initialDepositAmount) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = initialDepositAmount;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public double withdraw(double amount) {
        return accountBalance -= amount + BANK_FEE;
    }

    @Override
    public String toString() {
        return String.format("Account %d, Holder: %s, Balance: $ %.2f", accountNumber, accountHolderName, accountBalance);
    }
}
