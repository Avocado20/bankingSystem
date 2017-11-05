package AccountingService;

import BankService.AbstractClient;
import InterestService.InterestsMechanism;

public class InvestmentAccount extends AbstractAccount {

    public InvestmentAccount(long id, AbstractClient owner, int initialAmountOfMoney, int initialDebit, InterestsMechanism interestsMechanism) {
        super(id, owner, initialAmountOfMoney, initialDebit, interestsMechanism);
    }
}
