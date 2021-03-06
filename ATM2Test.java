package chapterFive.ATM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATM2Test {
    ATM2 userAccount;

    @BeforeEach
    void startWith(){
        userAccount =  new ATM2();
    }

    @Test
    @DisplayName("check Customer can deposit")
    void depositMoney(){
        userAccount.deposit(6000);
        double balance = 6000;
        assertEquals(balance, userAccount.getBalance());
    }

    @Test
    @DisplayName("check user cannot deposit less than zero")
    void depositCantBeLessThanZeroTest(){
        userAccount.deposit(-6000);
        double balance = 0.00;
        assertEquals(balance, userAccount.getBalance());
    }

    @Test
    @DisplayName("check Customer can deposit Twice")
    void depositMoneyTwice(){
        userAccount.deposit(6000);
        userAccount.deposit(6000);
        double balance = 12000;
        assertEquals(balance, userAccount.getBalance());
    }

    @Test
    @DisplayName("check customer can withdraw")
    void withdrawMoney(){
        userAccount.deposit(15000);
        double balance = 11000;
        userAccount.withdraw(4000, userAccount.getPin());
        assertEquals(balance, userAccount.getBalance());
    }
    @Test
    @DisplayName("check customer can withdraw within balance")
    void withdrawWithinBalance(){
        int pin = 2333;
        userAccount.deposit(15000);
        double balance = 15000;
        userAccount.withdraw(18000, pin);
        assertEquals(balance, userAccount.getBalance());
    }
    @Test
    @DisplayName("check customer cannot withdraw negative value")
    void withdraw_noNegativeValue(){
        int pin = 3455;
        userAccount.deposit(15000);
        double balance = 15000;
        userAccount.withdraw(-4000, pin);
        assertEquals(balance, userAccount.getBalance());
    }
    @Test
    @DisplayName("Customer can login with pin")
    void loginWithPin(){
        userAccount.setPin(1236);
        assertEquals(1236, userAccount.getPin());

    }

    @Test
    @DisplayName("Customer can withdraw with pin")
    void withdrawWithPin(){
        userAccount.deposit(15000);
        userAccount.setPin(1236);
        userAccount.withdraw(5000, userAccount.getPin());
        double balance = 10000;
        assertEquals(balance, userAccount.getBalance());
    }
    @Test
    @DisplayName("Customer cannot withdraw with incorrect pin")
    void withdraw_incorrectPin(){
        userAccount.deposit(15000);
        userAccount.setPin(1235);
        userAccount.withdraw(5000, 1237);
        double balance = 15000;
        assertEquals(balance, userAccount.getBalance());
    }



}