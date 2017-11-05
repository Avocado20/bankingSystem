package InterestService;

public abstract class AbstractInterestMechanism implements InterestsMechanism{

    protected double percentage;
    protected int howManyCapitalisations;

    public double generateInterest(int amountOfMoney, double percentage, int howManyCapitalisation) {
        return amountOfMoney * howManyCapitalisation * Math.abs(percentage);
    }

    AbstractInterestMechanism(double percentage, int howManyCapitalisations) {
        this.percentage = percentage;
        this.howManyCapitalisations = howManyCapitalisations;
        System.out.println("Mechanism: " + percentage + " " + howManyCapitalisations);
    }
}
