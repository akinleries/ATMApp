package BankProject;


public class Account {
    private String firstName;
    private String lastName;
    public int accountNumber;
    private double balance;
    private int pin;
    private double transferAmount;
    private double newBalance;

    public Account(String firstName, String lastName, int accountNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
    }
    public void createAccountNumber() {
        accountNumber++;
    }


    public int getAccountNumber() {
       return accountNumber;
    }

    public void depositMoney(double amount) {
        if (amount > 0)
        balance += amount;

    }

    public double getAccountBalance() {
        return balance;
    }

    public void withdrawMoney(double amount, int pin) {
        if(this.pin == pin){
            if (balance >= amount && amount > 0)

                balance -= amount;
        }

    }

    public void createPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public void transfer(double amount) {
        balance = balance - amount;
    }
//    public double getTransferAmount(){
//       return ;
//    }

//    public void receiveTransfer() {
//        balance = balance + getTransferAmount();
//    }


    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", pin=" + pin +
                ", transferAmount=" + transferAmount +
                ", newBalance=" + newBalance +
                '}';
    }
}
