package AccountingService.OperationService;

import AccountingService.AbstractAccount;
import ReportService.ConcreteOperation;

public class TransferOperation implements OperationInterface {

    private AbstractAccount accountSource;
    private AbstractAccount accountTarget;
    private int cashUnits;

    public TransferOperation (AbstractAccount accountSource, AbstractAccount accountTarget, int cashUnits) {
        this.accountSource = accountSource;
        this.accountTarget = accountTarget;
        this.cashUnits = cashUnits;
    }

    public boolean execute() {
        if ( cashUnits > this.accountSource.getAmountOfMoney()) {
            return false;
        } else {
            this.accountSource.setAmountOfMoney(this.accountSource.getAmountOfMoney() - cashUnits);
            this.accountTarget.setAmountOfMoney(this.accountTarget.getAmountOfMoney() + cashUnits);
            this.accountSource.addHistoryOperation(new ConcreteOperation(this.accountSource.getAccountId(), "witdraw Money: " + cashUnits));
            this.accountTarget.addHistoryOperation(new ConcreteOperation(this.accountTarget.getAccountId(), "add Money: " + cashUnits));
        }
        return true;
    };
}
