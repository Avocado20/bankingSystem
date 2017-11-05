package AccountingService;

import BankService.AbstractClient;
import InterestService.AbstractInterestMechanism;
import InterestService.InterestsMechanism;

import java.util.Date;

public class BasicAccount extends AbstractAccount {

    public BasicAccount (long id, AbstractClient owner, int initialAmountOfMoney, int initialDebit, InterestsMechanism interestsMechanism) {
        super(id, owner, initialAmountOfMoney, initialDebit, interestsMechanism, null);
    }

    public boolean closeAccount(AbstractAccount parentAccount) throws HasChildAccountException{
        if (parentAccount == null) {
            //doNothing
        }
        this.isActive = false;
        return true;
    }

    public boolean validateInterestMechanism(AbstractInterestMechanism mechanism) {
        return true;
    }




}
