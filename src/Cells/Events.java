package Cells;

public class Events{

    private String company;
    private int cost;
    private int count;

    public Events(String company, int cost, int count) {
        try {
            this.setCompany(company);
        }catch (NumberFormatException e){
            System.out.println("Неправильный формат ввода");
        }
        this.setCost(cost);
        this.setCount(count);
    }

    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o){
        if (o == null){ return false; }
        if (o == this){ return true; }
        if (o.getClass() != this.getClass()){ return false; }

        Events other = (Events) o;
        if (this.company != other.company){ return true; }
        else { return false; }
    }

    @Override
    public String toString(){
        return String.format("У компании: " + getCompany() + ", акций " + count + " на сумму " + cost);
    }
}
