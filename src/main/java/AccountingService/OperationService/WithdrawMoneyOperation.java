package AccountingService.OperationService;

import AccountingService.AbstractAccount;
import ReportService.ConcreteOperation;

public class WithdrawMoneyOperation implements  OperationInterface {

    private AbstractAccount abstractAccount;
    private int cashUnits;

    public WithdrawMoneyOperation(AbstractAccount abstractAccount, int cashUnits) {
        this.abstractAccount = abstractAccount;
        this.cashUnits = cashUnits;
    }

    public boolean execute() {
        if ( cashUnits > this.abstractAccount.getAmountOfMoney()) {
           return false;
        } else {
            this.abstractAccount.setAmountOfMoney(this.abstractAccount.getAmountOfMoney() - cashUnits);
            this.abstractAccount.addHistoryOperation(new ConcreteOperation(this.abstractAccount.getAccountId(), "witdraw Money: " + cashUnits));
        }
        return true;
    }
}
