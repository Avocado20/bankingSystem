package AccountingService.OperationService;

import AccountingService.AbstractAccount;
import BankService.KIR;
import ReportService.ConcreteOperation;

public class InterbankTransferOperation implements OperationInterface {

    private AbstractAccount accountSource;
    private AbstractAccount accountTarget;
    private int cashUnits;

    public InterbankTransferOperation (AbstractAccount accountSource, AbstractAccount accountTarget, int cashUnits) {
        this.accountSource = accountSource;
        this.accountTarget = accountTarget;
        this.cashUnits = cashUnits;
    }

    public boolean execute() {
        KIR kir = new KIR();
        if ( !new WithdrawMoneyOperation(accountSource, this.cashUnits).execute()) {
            return false;
        } else { //można rozwiazać problem rozliczania przelewów usypiając wątek i sprawdzać o pełnych godzinach i wtedy finalizować, lub kończyć operację
            boolean isSuccessTransfer = kir.makeTransfer(accountTarget, this.cashUnits);
            if (!isSuccessTransfer) {
                new AddMoneyOpeation(accountSource, this.cashUnits).execute();
                return false;
            } return true;
        }
    };
}