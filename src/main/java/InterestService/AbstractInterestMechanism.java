package InterestService;

public abstract class AbstractInterestMechanism {

    protected double percentage;
    protected short howManyCapitalisations;

    public double generateInterest(int amountOfMoney, double percentage, short howManyCapitalisation) {
        return amountOfMoney * howManyCapitalisation * Math.abs(percentage);
    }

    AbstractInterestMechanism(double percentage, short howManyCapitalisations) {
        this.percentage = percentage;
        this.howManyCapitalisations = howManyCapitalisations;
    }
}
