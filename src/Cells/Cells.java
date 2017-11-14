package Cells;

//класс ячейки
public class Cells implements Cell{

    private Cell value;//значение для ячейки
    private int sum;//вносимая сумма

    public Cells(Cell value){
        if (value == null){
            throw new IllegalArgumentException("Ячейка не должна быть пустой");
        }this.value = value;
    }

    //снятие суммы
    public void withdraw(int sum){
        if (sum <= 0){
            throw new IllegalArgumentException("Снимаемое количество должно быть положительным");
        }
        if (this.getSum() < sum){
            throw new NotEnoughValuableException();
        }
        this.sum = this.getSum() - sum;
    }

    //перевести сумму на счет
    public void deposit(int sum){
        if (sum <= 0){
            throw new IllegalArgumentException("Сумма должна быть положительной");
        }
        if (getValue().getMaxSum() != 0){
            if (getValue().getMaxSum() < this.getSum() + sum){
                throw new CellsFullExeption();
            }
            this.sum = this.getSum() + sum;
        }
        this.sum = this.getSum() + sum;
    }

    public boolean changeCellType(Cell newType){
        if (getSum() == 0){
            this.value = newType;
            return true;
        }else {
            return false;
        }
    }


    public Cell getValue() {
        return value;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Ячейка " + value + " " + sum;
    }

    @Override
    public int getMaxSum() {
        return 0;
    }
}
