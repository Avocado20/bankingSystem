package InterestService;

import java.util.Date;

public class InvestInterestMechanism extends AbstractInterestMechanism {

    public InvestInterestMechanism(double percentage, int howManyCapitalisations, Date correctCloseDate) {
        super(percentage, howManyCapitalisations, correctCloseDate);
    }

    public double generateInterest(int amountOfMoney, double percentage, int howManyCapitalisation) {
        return amountOfMoney * howManyCapitalisation * Math.abs(percentage);
    }


    public void setPercentage(double percentage) {
        super.setPercentage(percentage);
    }

    public void setNumberOfCapitalisations(short howManyCapitalisations) {
        this.setHowManyCapitalisations(howManyCapitalisations);
    }
}
