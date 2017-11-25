package AccountingService.OperationService;

import AccountingService.AbstractAccount;
import ReportService.ConcreteOperation;

public class AddMoneyOpeation implements OperationInterface {

    private AbstractAccount abstractAccount;
    private int cashUnits;

    public AddMoneyOpeation(AbstractAccount abstractAccount, int cashUnits) {
        this.abstractAccount = abstractAccount;
        this.cashUnits = cashUnits;
    }

    public boolean execute() {
        this.abstractAccount.setAmountOfMoney(this.abstractAccount.getAmountOfMoney() + cashUnits);
        this.abstractAccount.addHistoryOperation(new ConcreteOperation(this.abstractAccount.getAccountId(), "add Money: " + cashUnits));
        return true;
    }

}
