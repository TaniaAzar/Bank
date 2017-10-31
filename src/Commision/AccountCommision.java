package Commision;

public enum AccountCommision{

    BYN(0.01),
    EUR(0.02),
    USD(0.02),
    RUS(0.5),
    EVENT(0.1),
    METAL(0.2);

    private double mean;

    AccountCommision(double mean){
        this.mean = mean;
    }

    public double getMean() {
        return mean;
    }
}
