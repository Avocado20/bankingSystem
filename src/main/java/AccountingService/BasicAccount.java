package AccountingService;

import BankService.AbstractClient;
import InterestService.AbstractInterestMechanism;
import InterestService.InterestsMechanism;


public class BasicAccount extends AbstractAccount {

    public BasicAccount (long id, AbstractClient owner, int initialAmountOfMoney, int initialDebit, InterestsMechanism interestsMechanism) {
        super(id, owner, initialAmountOfMoney, initialDebit, interestsMechanism, null);
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
