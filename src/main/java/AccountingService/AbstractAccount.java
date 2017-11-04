package AccountingService;

import BankService.AbstractClient;
import InterestService.InterestsMechanism;
import ReportService.AccountOperation;

import java.util.LinkedList;

public abstract class AbstractAccount implements TransferInterface {

    protected long accountId;
    protected boolean isActive;
    protected long amountOfMoney;
    protected long debit;
    protected InterestsMechanism interestsMechanism;
    protected AbstractClient owner;
    protected LinkedList<AccountOperation> historyOperations;


    public AbstractAccount (AbstractClient owner, int initialAmountOfMoney, int initialDebit, InterestsMechanism interestsMechanism) {
        this.accountId = (long) Math.random();
        this.isActive = true;
        this.amountOfMoney = initialAmountOfMoney;
        this.debit = initialDebit;
        this.owner = owner;
        this.interestsMechanism = interestsMechanism;
    }
    
    public boolean closeAccount() {
        this.isActive = false;
        return true;
    };

    public boolean addMoney(long cashUnits) {
        this.amountOfMoney += cashUnits;
        return true;
    };

    public boolean withdrawMoney(long cashUnits) {
        this.amountOfMoney -= cashUnits;
        return true;
    };

    public boolean makeTransfer(TransferInterface targetAccount, long cashUnit) {
        this.withdrawMoney(cashUnit);
        targetAccount.addMoney(cashUnit);
        return true;
    };


}
