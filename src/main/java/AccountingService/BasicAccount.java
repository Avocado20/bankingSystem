package AccountingService;

import BankService.AbstractClient;
import InterestService.AbstractInterestMechanism;


public class BasicAccount extends AbstractAccount {

    public BasicAccount (long id, AbstractClient owner, int initialAmountOfMoney, AbstractInterestMechanism interestsMechanism) {
        super(id, owner, initialAmountOfMoney, interestsMechanism, null);
    }

    public boolean closeAccount(AbstractAccount parentAccount) throws HasChildAccountException{
        if (this.childAccounts != null) {
            throw new HasChildAccountException();
        }
        this.isActive = false;
        return true;
    }

    public boolean validateInterestMechanism(AbstractInterestMechanism mechanism) {
        return true;
    }




}
