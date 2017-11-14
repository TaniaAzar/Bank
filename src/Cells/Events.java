package Cells;

//класс акции
public class Events{

    //какая компания и стоимость акций
    private final String company;
    private double cost;


    public Events(String company, double cost) {
        if (company == null || company.isEmpty()){
            throw new IllegalArgumentException("Название компании не должно быть пустым");
        }
        this.company = company;
        this.setCost(cost);
    }

    public String getCompany() {
        return company;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        if (cost <= 0){
            throw new IllegalArgumentException("Цена должна быт положительной");
        }
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o){
        if (o == null){ return false; }
        if (o == this){ return true; }
        if (o.getClass() != this.getClass()){ return false; }

        Events other = (Events) o;
        return this.company.equals(other.company);
    }

    @Override
    public String toString(){
        return String.format("У компании: " + getCompany() + " акций стоимостью " + cost);
    }
}
