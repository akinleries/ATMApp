package chapterFive.ATM;

public class ATM2 {

    private double balance;
    private int pin = 2021;

    public void deposit(double amount) {
        if (amount > 0)
            balance = balance + amount;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount, int pin) {
        if(pin == this.pin){
            if (balance > amount && amount > 0)
            balance = balance - amount;}
    }

    public void setPin(int pin) {
            this.pin = pin;
    }

    public int getPin() {
        return pin;
    }
}
