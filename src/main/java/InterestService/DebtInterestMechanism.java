package InterestService;

public class DebtInterestMechanism extends AbstractInterestMechanism implements InterestsMechanism {

    public DebtInterestMechanism(double percentage, int howManyCapitalisations) {
        super(percentage, howManyCapitalisations);
    }


    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setNumberOfCapitalisations(short howManyCapitalisations) {
        this.howManyCapitalisations = howManyCapitalisations;
    }
}
