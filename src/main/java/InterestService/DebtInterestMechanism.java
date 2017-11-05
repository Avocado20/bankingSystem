package InterestService;

import java.util.Date;

public class DebtInterestMechanism extends AbstractInterestMechanism implements InterestsMechanism {

    public DebtInterestMechanism(double percentage, int howManyCapitalisations, Date correctCloseDate) {
        super(percentage, howManyCapitalisations, correctCloseDate);
    }

    public double generateInterest(int amountOfMoney, double percentage, int howManyCapitalisation) {
        return amountOfMoney * howManyCapitalisation * percentage;
    }

    public void setPercentage(double percentage) {
        super.setPercentage(percentage);
    }

    public void setNumberOfCapitalisations(short howManyCapitalisations) {
        this.setHowManyCapitalisations(howManyCapitalisations);
    }
}
