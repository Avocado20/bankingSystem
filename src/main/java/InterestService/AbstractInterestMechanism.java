package InterestService;

import java.util.Date;

public abstract class AbstractInterestMechanism implements InterestsMechanism {

    private double percentage;
    private int howManyCapitalisations;
    private Date correctCloseDate;


    AbstractInterestMechanism(double percentage, int howManyCapitalisations, Date correctCloseDate) {
        this.setPercentage(percentage);
        this.setHowManyCapitalisations(howManyCapitalisations);
        this.correctCloseDate =correctCloseDate;
        System.out.println("Mechanism: " + percentage + " " + howManyCapitalisations);
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getHowManyCapitalisations() {
        return howManyCapitalisations;
    }

    public void setHowManyCapitalisations(int howManyCapitalisations) {
        this.howManyCapitalisations = howManyCapitalisations;
    }

    public Date getCorrectCloseDate() {
        return correctCloseDate;
    }
}
