package Cells;

public class Metals {

    private float weight;
    private float cost;
    private MetalsEnum metal;

    //конструктор с параметрами
    public Metals(float weight, float cost, MetalsEnum metal) {
        this.setWeight(weight);
        if (weight > 3.0){
            System.out.println("Ячейка должна хранить не больше 3 кг металла");
        }
        this.cost = cost;
        this.metal = metal;
    }
    //getter and setter
    public float getWeight() { return weight; }
    public void setWeight(float weight) { this.weight = weight; }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public Enum getMetal() { return metal; }
    public void setMetal(MetalsEnum metal) { this.metal = metal; }

    @Override
    public String toString(){
        return String.format(getMetal() + " весом " + getWeight() +" кг" + " на сумму " + cost);
    }
}
enum MetalsEnum{
    SEREBRO,
    ZOLOTO,
    PLATINA,
    PALLADI;
}