package Account;

import Cells.Currency;
import Cells.NotEnoughValuableException;

public class PercentAccount extends Account{

    private final int percent;

    //конструктор
    public PercentAccount(Currency currency, int percent) {
       super(currency);
        if(percent <= 0){ throw new IllegalArgumentException("Процент должен быть положительным");
        }
        this.percent = percent;
    }

    //снятипе денег со счета
    @Override
    public void removalMoney(double balance) {
        if (balance < 0){ throw new IllegalArgumentException("Сумма должна быть больше 0");
        }
        if (this.balance < balance){
            throw new NotEnoughValuableException();
        }
        this.balance -= balance;
    }

    //снятие процентов
    public void plus_fix_percent() {
        if (this.balance > 0){
            this.balance += percent * this.balance / 100;
        }
    }

    public String toString() {
        return String.format("Процентный счет: процент " + percent + " " + balance + this.getCurrency());
    }
}
