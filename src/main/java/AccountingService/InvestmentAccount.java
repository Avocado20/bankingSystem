package AccountingService;

import AccountingService.OperationService.AddMoneyOpeation;
import AccountingService.OperationService.WithdrawMoneyOperation;
import BankService.AbstractClient;
import InterestService.AbstractInterestMechanism;
import InterestService.InterestsMechanism;

import java.util.Date;

public class InvestmentAccount extends AbstractAccount {


    public InvestmentAccount(long id, AbstractClient owner, int initialAmountOfMoney, AbstractInterestMechanism interestsMechanism, Date correctCloseAccountDate) {
        super(id, owner, initialAmountOfMoney, interestsMechanism, correctCloseAccountDate);
    }

    public boolean validateInterestMechanism(AbstractInterestMechanism mechanism) {
        return (Double.compare(mechanism.getPercentage(), 0.0) == 1 ) ?  true :  false;
    }

    public boolean closeAccount(AbstractAccount parentAccount) throws HasChildAccountException {
        if (parentAccount != null) {
            WithdrawMoneyOperation withdraw = new WithdrawMoneyOperation(this, (int)this.getAmountOfMoney());
            withdraw.execute();
            AddMoneyOpeation add = new AddMoneyOpeation(this, (int) this.getAmountOfMoney());
            add.execute();

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
