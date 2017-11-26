package BankService;

import AccountingService.AbstractAccount;
import AccountingService.OperationService.AddMoneyOpeation;
import AccountingService.OperationService.TransferOperation;

public class KIR {

    public boolean makeTransfer(AbstractAccount targetAccount, int cashUnit) {
        if (targetAccount != null) { //tutaj mogą być dodane inne warunki, które muszą być spełnione, aby zrobić przelew
            return new AddMoneyOpeation(targetAccount, cashUnit).execute();
        } else {
            return false;
        }
    }
}
