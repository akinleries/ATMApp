package BankProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    Bank elenuBank;
    Account bessieAccount;
    @BeforeEach
    void setUp() {
        elenuBank = new Bank();
        //account = new Account("jay", "jay", 1);
    }

    //    @AfterEach
//    void tearDown() {
//    }
//
    @Test
    void bankIsCreatedTest() {
        assertNotNull(elenuBank);

    }

    @Test
    void bankAccountCanBeCreated() {
        elenuBank.createAccount("salisu", "adams");
        elenuBank.createAccount("Bessie", "Jane");
        assertEquals(1, elenuBank.getTotalNumberOfAccounts());

    }

    @Test
    void bankCanCreateMultipleAccount() {

        elenuBank.createAccount("salisu", "adams");
        elenuBank.createAccount("lassis", "elenu");
        assertEquals(2, elenuBank.getTotalNumberOfAccounts());

    }


    @Test
    void bankAccountsHaveAccountNumbers(){

        elenuBank.createAccount("Salisu","Adam");
        ArrayList<Account> accountList = elenuBank.getAccounts();
        Account salisuAccount = accountList.get(0);
        assertNotNull(salisuAccount);
        assertTrue(salisuAccount.getAccountNumber()!=0);
    }
    @Test
    void userCanDepositMoney(){
        elenuBank.createAccount("john ","Ken ");
        elenuBank.deposit(1,2500);
        assertEquals(2500, elenuBank.getBalance(1));
    }
    @Test
    void userCanDepositTwice(){
        elenuBank.createAccount("john ","Ken ");
        elenuBank.deposit(1,2500);
        elenuBank.deposit(1,5400);
        assertEquals(7900, elenuBank.getBalance(1));

    }
    @Test
    void UserCantDepositZeroAmount(){
        elenuBank.createAccount("john ","Ken ");

        elenuBank.deposit(1,2500);
        elenuBank.deposit(1,-2500);
        assertEquals(2500, elenuBank.getBalance(1));

    }
    @Test
    void userMustHaveAValidAccountNumberToDepositMoney(){
        elenuBank.createAccount("john ","Ken ");

        elenuBank.deposit(45,2500);

        assertEquals(0.0, elenuBank.getBalance(45));
    }

    @Test
    void userCanWithdrawMoney(){
        elenuBank.createAccount("john ","Ken ");
        elenuBank.deposit(1,2500);
        elenuBank.withdrawMoney(1, 500,0);
        assertEquals(2000, elenuBank.getBalance(1));
    }
    @Test
    void userCantWithDrawAmountMoreThanItsBalance(){
//        bessieAccount.createPin(4573);
        elenuBank.createAccount("Bessie ","Jane");
        elenuBank.deposit(1,2000);
        elenuBank.withdrawMoney(1,200000.00, 0);
        assertEquals(2000.00, elenuBank.getBalance(1));
    }
    @Test
    void userCantWithdrawZeroAmount(){
        bessieAccount.createPin(4573);
        bessieAccount.depositMoney(3000.00);
        assertEquals(3000.00, bessieAccount.getAccountBalance());
        bessieAccount.withdrawMoney(-10.00, 4573);
        assertEquals(3000.00, bessieAccount.getAccountBalance());
    }
    @Test
    void userCanCreatePin(){
        bessieAccount.createPin(1234);
        assertEquals(1234, bessieAccount.getPin());
    }

    @Test
        void userCanWithdrawWithPin(){
        bessieAccount.createPin(1245);
        int pin = bessieAccount.getPin();
        bessieAccount.depositMoney(3000.00);
        assertEquals(3000.00, bessieAccount.getAccountBalance());
        bessieAccount.withdrawMoney(1000.00, pin);
        assertEquals(2000.00, bessieAccount.getAccountBalance());
    }

    @Test
    void userCantWithdrawWithIncorrectPin(){
        bessieAccount.createPin(1245);
        int pin = bessieAccount.getPin();
        bessieAccount.depositMoney(3000.00);
        assertEquals(3000.00, bessieAccount.getAccountBalance());
        bessieAccount.withdrawMoney(1000.00, 2323);
        assertEquals(3000.00, bessieAccount.getAccountBalance());
    }

    @Test
    void userCanMakeTransferPayment(){
       /* bank1.createAccount("Lasisi", "elenu", 1);
        bank1.createAccount("Babs", "Ishola", 2);

        assertEquals(2, bank1.getTotalNumberOfAccounts());
        assertEquals(1, bank1.getAccountNumber(0));
        assertEquals(2, bank1.getAccountNumber(1));
        bank1.deposit(1, 2000);
        bank1.deposit(1, 3000);
        assertEquals(5000, bank1.getBalance(1));
       // assertEquals(2000, bank1.getBalance(1));*/

    }

}
