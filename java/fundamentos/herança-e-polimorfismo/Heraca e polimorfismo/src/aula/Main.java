package aula;

import aula.entities.Account;
import aula.entities.BusinessAccount;
import aula.entities.SavingsAccount;

public class Main {
    public static void main(String[] args) {

        Account acc = new Account(1001, "José", 100.00);
        BusinessAccount bacc = new BusinessAccount(999, "João", 700.0, 3000.0);


        //UPCASTING
        Account acc1 = new Account(1002, "Maria", 20.0);
        Account acc2 = new BusinessAccount(1003, "Alfredo", 90.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Fatima", 0.0, 0.02);

        //DOWNCASTING
        BusinessAccount bacc2 = (BusinessAccount) acc2;
        bacc2.loan(150.0);

//        BusinessAccount bacc3 = (BusinessAccount)acc3; //ERRO
        if (acc3 instanceof BusinessAccount) {
            BusinessAccount bacc3 = (BusinessAccount) acc3;
            bacc3.loan(200.0);
            System.out.println("Loan!");
        }

        if (acc3 instanceof SavingsAccount) {
            SavingsAccount sacc = (SavingsAccount) acc3;
            sacc.updateBalance();
            System.out.println("Update!");
        }


        //POLIMORFISMO

        Account account1 = new Account(5000, "Alex", 1000.0);
        Account account2 = new SavingsAccount(5001, "Nicole", 1000.0, 0.02);

        account1.withdraw(50.0);
        System.out.println("Account: " + account1.getBalance());
        account2.withdraw(50.0);
        System.out.println("SavingAccount: " + account2.getBalance());
    }
}