package Account;

import Cells.Currency;

public abstract class Account {

    double balance;
    private final Currency currency;

    //конструктор
    public Account(Currency currency){
        this.currency = currency;
        this.balance = 0.0;
    }

    //getter,setter
    public double getBalance(){
        return balance;
    }
    public Currency getCurrency(){ return currency; }

    //метод снятия денег со счета
    public abstract void removalMoney(double balance);

    //метод, чтобы положить деньги на счет
    public void replenishmentMoney(double balance){
        if (balance <= 0){
            throw new IllegalArgumentException("Сумма должна быть положительной");
        }
        this.balance += balance;
    }

    //перевод со счета на счет
    public void transfer(Account other, double balance){
        if (other == null){
            throw new IllegalArgumentException("Счет не может быть пустым");
        }
        this.removalMoney(balance);
        double result = balance * this.currency.getPrice() / other.getCurrency().getPrice();
        this.replenishmentMoney(result);
    }
}
