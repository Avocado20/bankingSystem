package AccountingService;

import BankService.AbstractClient;
import InterestService.InterestsMechanism;

public class CreditAccount extends AbstractAccount {

    public CreditAccount(long id, AbstractClient owner, int initialAmountOfMoney, int initialDebit, InterestsMechanism interestsMechanism) {
        super(id, owner, initialAmountOfMoney, initialDebit, interestsMechanism);
    }
}
