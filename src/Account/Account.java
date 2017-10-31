package Account;

import Account.Client;
import Commision.Currency;
import Commision.AccountCommision;

public abstract class Account {

    private double balance;
    private Enum currency;

    //конструктор
    public Account(double balance, Enum currency){
        this.balance = balance;
        this.currency = currency;
    }

    //getter,setter
    public double getBalance() {
        return balance;
    }
    protected void setBalance(double balance){this.balance = balance;}
    public Enum getCurrency(){ return currency; }

    //метод снятия денег со счета
    public abstract void removalMoney(float summa);

    //метод, чтобы положить деньги на счет
    public abstract void replenishmentMoney(float summa);

    //взятие комиссии за снятие со счета
    public abstract double forStorage(float summa);

    //метод взятия комиссии
    public double knowCommision(){
        double rez = 0;
        if (getCurrency() == Currency.BYN){
            rez = AccountCommision.BYN.getMean();
        }
        if (getCurrency() == Currency.RUS){
            rez = AccountCommision.RUS.getMean();
        }
        if (getCurrency() == Currency.USD){
            rez = AccountCommision.USD.getMean();
        }
        if (getCurrency() == Currency.EUR){
            rez = AccountCommision.EUR.getMean();
        }
        return getBalance() * rez;
    }

    @Override
    public String toString() {
        return String.format("счёт %.2f валюта %s",getBalance(),getCurrency());
    }
}
