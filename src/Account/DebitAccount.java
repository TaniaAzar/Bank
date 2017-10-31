package Account;

import Account.NegativeNumberException;

public class DebitAccount extends Account{

    //конструктор
    public DebitAccount(double balance, Enum currency) {
        super(balance,currency);
        if(balance < 0){ throw new NegativeNumberException("Счет не может быть в минусе",""); }
    }

    //снятие денег со счета
    @Override
    public void removalMoney(float summa) {
        if (getBalance() < summa){ throw new IllegalArgumentException("Недостаточно средств");
        }else {
            setBalance(getBalance() - summa - forStorage(summa));
            System.out.println("Ваш остаток: " + getBalance()); }
    }

    //положить деньги на счет
    @Override
    public void replenishmentMoney(float summa) {
        setBalance(getBalance()+summa);
        System.out.println("Ваш остаток: " + getBalance());
    }

    @Override
    public double forStorage(float summa) {
        return knowCommision() * summa;
    }

    @Override
    public String toString() {
        return String.format("Дебетовый счет " + getBalance() + getCurrency());
    }
}
