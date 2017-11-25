package AccountingService.OperationService;

import AccountingService.AbstractAccount;
import ReportService.ConcreteOperation;

public class WithdrawMoneyOperation implements OperationInterface{

    private AbstractAccount abstractAccount;
    private int cashUnits;

    public WithdrawMoneyOperation(AbstractAccount abstractAccount, int cashUnits) {
        this.abstractAccount = abstractAccount;
        this.cashUnits = cashUnits;
    }

    public boolean execute() {

        if ( cashUnits > this.getAbstractAccount().getAmountOfMoney()) {
            return false;
        } else {
            this.getAbstractAccount().setAmountOfMoney(this.getAbstractAccount().getAmountOfMoney() - cashUnits);
            this.getAbstractAccount().addHistoryOperation(new ConcreteOperation(this.getAbstractAccount().getAccountId(), "witdraw Money: " + cashUnits));
        }
        return true;
    }

    public AbstractAccount getAbstractAccount() {
        return abstractAccount;
    }
}
