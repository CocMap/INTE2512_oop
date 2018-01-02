package week4;

import java.util.Date;

public class ex5_Account {
    public static void main(String[] args) {
        Account TestAccount = new Account(1122, 20000, 4.5/100, null);
        TestAccount.withdraw(2500);
        TestAccount.deposit(3000);
    }
}

class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;

    public Account (int id, double balance, double annualInterestRate, Date dateCreated){

    }

    public Account (int id, double balance){
        this.id = 3533562;
        this.balance = 100;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double amount) {
        balance = balance - amount;
    }

    public void deposit(double amount){
        System.out.println("Account balance = " + balance + "\n"
                        + "Monthly Interest = " + getMonthlyInterestRate() + "\n"
                        + "Date account is created = " + dateCreated);
    }
}
