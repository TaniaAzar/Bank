package Account;

public class PercentAccount extends Account implements PercentСredit{

    private int count_month;

    //конструктор
    public PercentAccount(double balance,Enum currency) {
       super(balance,currency);
        if(balance < 0){ throw new NegativeNumberException("Счет не может быть в минусе",""); }
    }

    //getter и setter
    public int getCount_month() {
        return count_month;
    }
    public void setCount_month(int count_month) {
        this.count_month = count_month;
    }

    //снятипе денег со счета
    @Override
    public void removalMoney(float summa) {
        if (getBalance() < summa){ throw new IllegalArgumentException("Недостаточно средств");
        }else { setBalance(getBalance()-summa - forStorage(summa));
            System.out.println("Выш остаток: " + getBalance()); }
    }

    //положить деньги на счет
    @Override
    public void replenishmentMoney(float summa) { setBalance(getBalance()+summa);
        System.out.println("Выш остаток: " + getBalance());
    }

    //взятие комиссии
    @Override
    public double forStorage(float summa) {
        return knowCommision() * summa;
    }

    //проценты + счет
    @Override
    public void plus_fix_percent() {
        setBalance(getBalance() + FIX_PERCENT / 100 * getBalance());
        System.out.println("Ваша задолжность: " + getBalance());
    }
    public String toString() {
        return String.format("Процентный счет " + getBalance() + getCurrency());
    }
}
