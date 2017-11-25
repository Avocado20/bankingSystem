package AccountingService;

import BankService.AbstractClient;
import InterestService.AbstractInterestMechanism;
import InterestService.InterestsMechanism;

import java.util.Date;

public class InvestmentAccount extends AbstractAccount {


    public InvestmentAccount(long id, AbstractClient owner, int initialAmountOfMoney, int initialDebit, AbstractInterestMechanism interestsMechanism, Date correctCloseAccountDate) {
        super(id, owner, initialAmountOfMoney, initialDebit, interestsMechanism, correctCloseAccountDate);
    }

    public boolean validateInterestMechanism(AbstractInterestMechanism mechanism) {
        return (Double.compare(mechanism.getPercentage(), 0.0) == 1 ) ?  true :  false;
    }

    public boolean closeAccount(AbstractAccount parentAccount) throws HasChildAccountException {
        if (parentAccount != null) {
            try {
                this.withdrawMoney(this.getAmountOfMoney());
                parentAccount.addMoney(this.getAmountOfMoney());
            } catch (NotEnoughMoneyException e) {
                //do nothing
            }
            parentAccount.removeChildAccount(this);
            this.isActive = false;
            return true;
        } else {
            if (!this.childAccounts.isEmpty()) {
                throw new HasChildAccountException();
            }
            this.isActive = false;
            return true;
        }
    }
}
