package org.dreambig.designpattern;

public class Driver {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount.Builder("Nipur","420").sendNewsLetter(true).number("8197998808").emailOn("pk.go").build();
        System.out.println(bankAccount);
    }
}
