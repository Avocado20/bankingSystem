package InterestServiceTest;


import AccountingService.*;
import BankService.*;
import InterestService.AbstractInterestMechanism;
import InterestService.DebtInterestMechanism;
import InterestService.InterestsMechanism;
import InterestService.InvestInterestMechanism;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class InterestMechanismTest {

    private AbstractBank bank = Mockito.mock(ConcreteBank.class);
    private AbstractClient client = Mockito.mock(ConcreteClient.class);
    private InvestmentAccount investmentAccount;
    private CreditAccount creditAccount;


    @Test
    public void countDebtInterestTest() throws NotEnoughMoneyException {
        bank.addClient(client);
        DebtInterestMechanism debtInterestMechanism = new DebtInterestMechanism(0.1, 12, new Date());
        creditAccount = new CreditAccount(2L, client, 800,  debtInterestMechanism, new Date());
        bank.addAccount(creditAccount);
        AbstractInterestMechanism interestsMechanism = creditAccount.getInterestsMechanism();
        long amountOfMoney = creditAccount.getAmountOfMoney();
        double percentage = interestsMechanism.getPercentage();
        int howManyCaps = interestsMechanism.getHowManyCapitalisations();
        double interest =  interestsMechanism.generateInterest(amountOfMoney, percentage,howManyCaps);
        assertEquals(-6.67, interest, 0.00);
    }

    @Test
    public void countInvestInterestTest() throws NotEnoughMoneyException {
        bank.addClient(client);
        InvestInterestMechanism interestsMechanism = new InvestInterestMechanism(0.1, 12, new Date());
        investmentAccount = new InvestmentAccount(2L, client, 800,  interestsMechanism, new Date());
        bank.addAccount(investmentAccount);
        long amountOfMoney = investmentAccount.getAmountOfMoney();
        double percentage = interestsMechanism.getPercentage();
        int howManyCaps = interestsMechanism.getHowManyCapitalisations();
        double interest =  interestsMechanism.generateInterest(amountOfMoney, percentage,howManyCaps);
        assertEquals(6.67, interest, 0.00);
    }
}
