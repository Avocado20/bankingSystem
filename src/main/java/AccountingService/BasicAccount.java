package AccountingService;

import BankService.AbstractClient;
import InterestService.InterestsMechanism;

public class BasicAccount extends AbstractAccount {

    public BasicAccount (long id, AbstractClient owner, int initialAmountOfMoney, int initialDebit, InterestsMechanism interestsMechanism) {
        super(id, owner, initialAmountOfMoney, initialDebit, interestsMechanism);
    }

}
