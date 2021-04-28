package BankApplicationClass;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
    account.customerCanDepositMoney(20000.00);
    System.out.println("Bal :  $" + account.getBalance() + "\n");
    account.customerCanWithdrawMoney(20000.00, 2222);
    System.out.println("Bal :  $" + account.getBalance());
    System.out.println("Have nice day " + account.getCustomerName());

    }
}
