package AccountingService;

import BankService.AbstractClient;
import InterestService.InterestsMechanism;

public class InvestmentAccount extends AbstractAccount {

    public InvestmentAccount(AbstractClient owner, int initialAmountOfMoney, int initialDebit, InterestsMechanism interestsMechanism) {
        super(owner, initialAmountOfMoney, initialDebit, interestsMechanism);
    }
}
