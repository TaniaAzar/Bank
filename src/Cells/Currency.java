package Cells;

public enum Currency {
    BYN(1.0),
    USD(1.9740),
    EUR(2.2950),
    RUS(0.033810);

    private double price;
    Currency(double price){
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0){
            throw new IllegalArgumentException("Неверное значение для валюты");
        }
        this.price = price;
    }


    @Override
    public String toString() {
        return "Валюта " + this.name() + " = " + price;
    }
}
