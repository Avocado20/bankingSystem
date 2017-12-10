package AccountingService;

import BankService.AbstractClient;
import InterestService.AbstractInterestMechanism;
import ProductReportService.AccountSelectibleVisitor;
import ProductReportService.AccountVisitor;


public class BasicAccount extends AbstractAccount {

    public BasicAccount (int bankAccountId, long id, AbstractClient owner, int initialAmountOfMoney, AbstractInterestMechanism interestsMechanism) {
        super(bankAccountId, id, owner, initialAmountOfMoney, interestsMechanism, null);
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

    public void accept(AccountVisitor accountSelectibleVisitor) {
        accountSelectibleVisitor.visit(this);
    }

}
