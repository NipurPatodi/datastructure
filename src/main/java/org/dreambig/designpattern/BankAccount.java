package org.dreambig.designpattern;


public class BankAccount {
    private String name;
    private String accNumber;
    private String email;
    private String number;
    private boolean sendNewsLetter;

    private  BankAccount(String name, String accNumber, String  email, String number, boolean sendNewsLetter){
        this.name=name;
        this.accNumber=accNumber;
        this.number=number;
        this.email=email;
        this.sendNewsLetter =sendNewsLetter;
    }
    public  String toString(){
        return String.format("%s %s %s %s %s", this.accNumber , this.number , this.name, this.email, this.sendNewsLetter);
    }
    public static class Builder{
        private String name;
        private String accNumber;
        private String email;
        private String number;
        private boolean sendNewsLetter;

        public Builder(String name, String accNumber){
            this.name=name;
            this.accNumber=accNumber;
        }
        public Builder emailOn(String email){
            this.email=email;
            return  this;
        }
        public Builder sendNewsLetter(boolean send){
            this.sendNewsLetter =send;
            return this;
        }

        public Builder number(String number){
            this.number =number;
            return this;
        }

        public  BankAccount build(){
            return  new BankAccount(this.name, this.accNumber,this.email, this.number,this.sendNewsLetter);
        }
    }
}
