package BankProject;


import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts= new ArrayList<>();
    private int accountID = 0;
    private double balance;
    private double amount;

    public void createAccount(String firstName, String lastName) {
       int accountNumber = ++accountID;
        Account account = new Account(firstName, lastName, accountNumber);
        accounts.add(account);
    }


    public int getTotalNumberOfAccounts() {
        return accounts.size();
    }

    public int getAccountNumber(int customerID) {
     return   accounts.get(customerID).getAccountNumber();
    }

    @Override
    public String toString() {
        String toString = "";
        for(var account: accounts){
            toString+=account+"\n";
        }
 return toString;


    }

    public void deposit(int accountNumber, double amount) {
//        this.amount = amount;
        Account depositorsAccount = findAccountByAccountNumber(accountNumber);
            depositorsAccount.depositMoney(amount);



//        for (int i = 0; i < accounts.size(); i++) {
//            if(accounts.get(i).getAccountNumber() == accountNumber) {
//                accounts.get(i).depositMoney(amount);
//                break;
//            }
//
//        }
    }

    public void withdrawMoney(int accountNumber, double amount, int pin) {
        // if(this.pin == pin){
        Account accountToWithdrawFrom = findAccountByAccountNumber(accountNumber);
        accountToWithdrawFrom.withdrawMoney(amount, pin);

    }
//        this.amount = amount;
//            if (balance >= amount && amount > 0)
//
//                balance -= amount;
//        }

public Account findAccountByAccountNumber(int accountNumber){
        try{
        return accounts.get(accountNumber-1);}
        catch (IndexOutOfBoundsException ex){
            System.out.println("Account does not exist");
            return null;
        }
}

    public double getBalance(int accountNumber) {
//        double accountBalance = 0;
      Account accountToCheck = findAccountByAccountNumber(accountNumber);
                  return accountToCheck.getAccountBalance();
//        for (int i = 0; i < accounts.size(); i++) {
//            if(accounts.get(i).getAccountNumber() == accountNumber) {
//              accountBalance =  accounts.get(i).getAccountBalance();
//                break;
//            }
//
//        }
//        return accountBalance;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

//    public void makeTransferPayment(Account account1, double amount1, Account account2) {
//        account1.transfer(amount1);
//        account2.receiveTransfer();
//
//    }
}
