package InterestService;

public class InvestInterestMechanism extends AbstractInterestMechanism implements InterestsMechanism{

    public InvestInterestMechanism(double percentage, short howManyCapitalisations) {
        super(percentage, howManyCapitalisations);
    }


    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setNumberOfCapitalisations(short howManyCapitalisations) {
        this.howManyCapitalisations = howManyCapitalisations;
    }
}
