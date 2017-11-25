package InterestService;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

public class InvestInterestMechanism extends AbstractInterestMechanism {

    public InvestInterestMechanism(double percentage, int howManyCapitalisations, Date correctCloseDate) {
        super(percentage, howManyCapitalisations, correctCloseDate);
    }

    public double generateInterest(long amountOfMoney, double percentage, int howManyCapitalisation) {
        double amountOfInterestNotRounded = amountOfMoney * (percentage / howManyCapitalisation);
        try {
            DecimalFormat df=new DecimalFormat("0.00");
            String formate = df.format(amountOfInterestNotRounded);
            return (Double)df.parse(formate) ;
        } catch (ParseException e ) {
            return amountOfInterestNotRounded;
        }
    }


    public void setPercentage(double percentage) {
        super.setPercentage(percentage);
    }

    public void setNumberOfCapitalisations(short howManyCapitalisations) {
        this.setHowManyCapitalisations(howManyCapitalisations);
    }
}
