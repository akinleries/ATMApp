package chapterFive.ATM;

import java.util.Scanner;

public class ATM2Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ATM2 userAccount = new ATM2();
        int pin = userAccount.getPin();
        String prompt = """
                Welcome
                --> Press 1 to Deposit
                --> Press 2 to Withdraw
                --> Press 3 to check Balance
                --> Press 4 to Exit.
                """;


        int userInput = 0;
        int counter = 3;
        while(counter >= 1){
            counter--;
            System.out.println("Welcome to Elenu Bank, kindly enter your pin.");
            int myPin = input.nextInt();
            if(myPin == pin){
                System.out.println(prompt);
                while(userInput != 4){
                    System.out.println("->Perform A Transaction");
                    userInput = input.nextInt();

                    switch (userInput){

                        case 1:
                            System.out.println("Deposit");
                            double amount = input.nextDouble();
                                if(amount < 0){
                                    System.out.println(" Please Enter A Valid Amount");
                                    break; }
                                  else
                            userAccount.deposit(amount);
                            break;
                        case 2:
                            System.out.println("Enter Pin to Continue");
                            pin = input.nextInt();
                                if(pin != userAccount.getPin()){
                                    System.out.println("Please Enter A Valid Pin");
                               break;  }
                                else
                                    System.out.println("Enter Amount To Withdraw");
                            double amountToWithdraw = input.nextDouble();
                                if(amountToWithdraw < 0){
                                    System.out.println("Enter A Valid Amount");
                                break; }
                                else
                            userAccount.withdraw(amountToWithdraw, pin);
                           break;
                        case 3:
                            System.out.println("Dear Customer Your Account Balance is "+ userAccount.getBalance());
                            break;

                        case 4:
                            System.out.println("Thank You For Banking With US");
                            System.out.println(" Elenu Commercial Bank ");



                    }


                }
            }else if(counter == 0){
                System.out.println("Ole ni e,  you be 419, get out of the system");
            } else{
                System.out.println("You have " + counter + " chances to try again");

            }


        }





    }

}
