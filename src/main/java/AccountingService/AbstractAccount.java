package AccountingService;

import BankService.AbstractClient;
import InterestService.InterestsMechanism;
import ReportService.AccountOperation;
import ReportService.ConcreteOperation;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractAccount implements TransferInterface {

    protected long accountId;
    protected boolean isActive;
    protected long amountOfMoney;
    protected long debit;
    protected InterestsMechanism interestsMechanism;
    protected AbstractClient owner;
    protected List<AccountOperation> historyOperations;


    public AbstractAccount (long accountId, AbstractClient owner, int initialAmountOfMoney, int initialDebit, InterestsMechanism interestsMechanism) {
        this.accountId = accountId;
        this.isActive = true;
        this.amountOfMoney = initialAmountOfMoney;
        this.debit = initialDebit;
        this.owner = owner;
        this.interestsMechanism = interestsMechanism;
        System.out.println("Account: " + accountId + " " + amountOfMoney + " " + debit + " " + owner.getClientId());
    }
    
    public boolean closeAccount() {
        this.isActive = false;
        return true;
    };

    public boolean addMoney(long cashUnits) {
        this.amountOfMoney += cashUnits;
        this.historyOperations.add(new ConcreteOperation(this.accountId, "add Money: " + cashUnits));
        return true;
    };

    public boolean withdrawMoney(long cashUnits) {
        this.amountOfMoney -= cashUnits;
        this.historyOperations.add(new ConcreteOperation(this.accountId, "witdraw Money: " + cashUnits));
        return true;
    };

    public boolean makeTransfer(TransferInterface targetAccount, long cashUnit) {
        this.withdrawMoney(cashUnit);
        targetAccount.addMoney(cashUnit);
        this.historyOperations.add(new ConcreteOperation(this.accountId, "make Money transfer: " + cashUnit));
        return true;
    };

    public List<AccountOperation> getHistoryOperations() {
        return this.historyOperations;
    }

}
