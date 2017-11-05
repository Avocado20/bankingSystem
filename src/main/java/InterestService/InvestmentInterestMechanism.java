package InterestService;

public class InvestmentInterestMechanism implements InterestsMechanism {

    public double generateInterest(int amountOfMoney, double percentage, int howManyCapitalisation) {
        return amountOfMoney * howManyCapitalisation * percentage;
    }
}
