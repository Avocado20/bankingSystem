package AccountingService;

import BankService.AbstractClient;
import InterestService.AbstractInterestMechanism;
import ProductReportService.AccountVisitor;

import java.util.Date;

public class CreditAccount extends AbstractAccount {

    public CreditAccount(int bankAccountId, long id, AbstractClient owner, int initialAmountOfMoney, AbstractInterestMechanism interestsMechanism, Date correctCloseAccountDate) {
        super(bankAccountId, id, owner, initialAmountOfMoney, interestsMechanism, correctCloseAccountDate);
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

    public String accept(AccountVisitor accountVisitor) {
        return accountVisitor.visit(this);
    }
}
