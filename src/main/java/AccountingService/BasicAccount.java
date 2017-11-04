package AccountingService;

import BankService.AbstractClient;
import InterestService.InterestsMechanism;

public class BasicAccount extends AbstractAccount {

    public BasicAccount (AbstractClient owner, int initialAmountOfMoney, int initialDebit, InterestsMechanism interestsMechanism) {
        super(owner, initialAmountOfMoney, initialDebit, interestsMechanism);
    }

}
