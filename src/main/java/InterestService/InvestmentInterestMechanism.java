package InterestService;

public class InvestmentInterestMechanism implements InterestsMechanism {

    public double generateInterest(int amountOfMoney, double percentage, short howManyCapitalisation) {
        return amountOfMoney * howManyCapitalisation * percentage;
    }
}
