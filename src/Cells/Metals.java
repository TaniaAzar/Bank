package Cells;

public enum Metals implements Cell{

    SEREBRO(1.01),
    ZOLOTO(77.30),
    PLATINA(55.47),
    PALLADI(56.18);

    private double price;

    //конструктор с параметрами
    Metals(double price) {
        this.price = price;
    }
    //getter and setter
    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        if (price <= 0){
            throw new IllegalArgumentException("Неверное значение стоимости металла");
        }
        this.price = price;
    }
    @Override
    public String toString(){
        return String.format(this.name() + " цена = " + price);
    }

    private final static int MAX_GRAMS_IN_STORAGE = 3000;

    @Override
    public int getMaxSum(){
        return MAX_GRAMS_IN_STORAGE;
    }

}
