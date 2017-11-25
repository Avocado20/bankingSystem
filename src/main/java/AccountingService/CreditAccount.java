package AccountingService;

import BankService.AbstractClient;
import InterestService.AbstractInterestMechanism;
import InterestService.InterestsMechanism;

import java.util.Date;

public class CreditAccount extends AbstractAccount {

    public CreditAccount(long id, AbstractClient owner, int initialAmountOfMoney, AbstractInterestMechanism interestsMechanism, Date correctCloseAccountDate) {
        super(id, owner, initialAmountOfMoney, interestsMechanism, correctCloseAccountDate);
    }

    public boolean validateInterestMechanism(AbstractInterestMechanism mechanism) {
        return (Double.compare(mechanism.getPercentage(), 0.0) == 1 ) ?  false :  true;
    }

    public boolean closeAccount(AbstractAccount parentAccount) {
        if (this.getAmountOfMoney() == 0.0) {
            parentAccount.removeChildAccount(this);
            this.isActive = false;
            return true;
        } else {
            return false;
        }
    }
}
