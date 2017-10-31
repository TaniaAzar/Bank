package Account;

public class KreditAccount extends Account implements PercentСredit{

    //конструктор
    public KreditAccount(double balance,Enum currency) {
       super(balance,currency);
        if(balance > 0){
            throw new IllegalArgumentException("Баланс не может быть положительным");
        }
    }

    //снятие денег со счета
    @Override
    public void removalMoney(float summa) {
        if (getBalance() < summa){ throw new IllegalArgumentException("Недостаточно средств");
        }else { setBalance(getBalance() - summa - forStorage(summa));
            System.out.println("Выш остаток: " + getBalance()); }
    }

    //положить деньги на счет
    @Override
    public void replenishmentMoney(float summa) {
        if (summa > Math.abs(getBalance())){
            throw new IllegalArgumentException("Баланс не может быть положительным");
        } else { setBalance(getBalance()+summa);
            System.out.println("Ваш остаток: " + getBalance()); }
    }

    @Override
    public double forStorage(float summa) {
        return knowCommision() * summa;
    }

    //проценты + счетом
    @Override
    public void plus_fix_percent() {
        setBalance(getBalance() + FIX_PERCENT / 100 * getBalance());
        System.out.println("Ваша задолжность: " + getBalance());
    }
    public String toString() {
        return String.format("Кредитный счет " + getBalance() + getCurrency());
    }
}
