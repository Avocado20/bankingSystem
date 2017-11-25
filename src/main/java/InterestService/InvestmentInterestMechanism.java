package InterestService;

import java.text.DecimalFormat;
import java.text.ParseException;

public class InvestmentInterestMechanism implements InterestsMechanism {

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
}
