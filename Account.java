package BankApplicationClass;

public class Account {
    private String accountNumber;
    private double balance ;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;
    public int pin = 2222 ;

    public Account(String accountNumber, double balance, String customerName, String customerEmail, String customerPhoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;

    }
    public Account(){
        this("123456", 0.0, "bob", "myemail@gmai.com ", "090334566");
    }

    private void setPin(int pin) {
        this.pin = pin;

    }

    private int getPin() {
        return pin;
    }



    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
   }
   public void setBalance(double balance) {
       this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public double customerCanDepositMoney(double depositMoney){

        if (depositMoney > 0){
            balance += depositMoney;
            System.out.println("Transaction Successful");
        }
        return balance;
    }
    public double customerCanWithdrawMoney(double withdrawMoney, int customerPin) {
        if (balance < withdrawMoney) {
            System.out.println("insufficient Funds" + "\n" + "Transaction Not Processed");

            return balance;
        }
        else if (balance >= withdrawMoney && customerPin == getPin()) {
                balance -= withdrawMoney;
                System.out.println("Transaction Successful");
                return balance;
            }
        else if(customerPin != getPin()) {
            System.out.println("invalid pin");
        }

        return balance;
    }
}
