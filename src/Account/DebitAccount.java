package Account;

import Cells.NotEnoughValuableException;
import Cells.Currency;

public class DebitAccount extends Account{

    public DebitAccount(Currency currency){
        super(currency);
    }

    //снятие денег со счета
    @Override
    public void removalMoney(double balance) {
        if (balance < 0){ throw new IllegalArgumentException("Недостаточно средств");
        }
        if (this.balance < balance){
            throw new NotEnoughValuableException();
        }
        this.balance -= balance;
    }

    @Override
    public String toString() {
        return String.format("Дебетовый счет " + balance + this.getCurrency());
    }
}
