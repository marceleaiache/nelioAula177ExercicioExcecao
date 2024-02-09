package application;

import model.entities.Account;
import model.exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data ");
        System.out.println("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.println("Holder: ");
        String holder = sc.nextLine();
        System.out.println("Initial balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();
        System.out.println("Withdraw limit: ");
        double withDrawLimit = sc.nextDouble();
        sc.nextLine();

        //INSTANCIANDO UM OBJETO ACCOUNT
        Account acc = new Account(number, holder, balance, withDrawLimit);

        System.out.println();
        System.out.println("Enter amount for withdraw: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        //UTILIZANDO TRATAMENTO DE EXCEÇÃO PARA PARTE DO CÓDIGO QUE PODE GERAR EXCEÇÃO
        try {
            acc.withdraw(amount);
            System.out.printf("New balance: %.2f%n", acc.getBalance());
        }

        catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
