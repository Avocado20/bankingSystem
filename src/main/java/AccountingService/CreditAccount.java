package AccountingService;

import BankService.AbstractClient;
import InterestService.InterestsMechanism;

public class CreditAccount extends AbstractAccount {

    public CreditAccount(AbstractClient owner, int initialAmountOfMoney, int initialDebit, InterestsMechanism interestsMechanism) {
        super(owner, initialAmountOfMoney, initialDebit, interestsMechanism);
    }
}
