package InterestService;

public class InvestInterestMechanism extends AbstractInterestMechanism {

    public InvestInterestMechanism(double percentage, int howManyCapitalisations) {
        super(percentage, howManyCapitalisations);
    }


    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setNumberOfCapitalisations(short howManyCapitalisations) {
        this.howManyCapitalisations = howManyCapitalisations;
    }
}
