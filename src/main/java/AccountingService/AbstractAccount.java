package AccountingService;

import AccountingService.OperationService.OperationInterface;
import BankService.AbstractClient;
import InterestService.AbstractInterestMechanism;
import ReportService.AbstractAccountOperation;
import ReportService.ConcreteOperation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractAccount {

    private long accountId;
    protected boolean isActive;
    protected long amountOfMoney;
    protected long debit;
    private AbstractInterestMechanism interestsMechanism;
    protected AbstractClient owner;
    protected List<AbstractAccountOperation> historyOperations;
    protected List<AbstractAccount> childAccounts;
    private Date correctCloseAccount;


    public AbstractAccount (long accountId, AbstractClient owner, int initialAmountOfMoney, int initialDebit, AbstractInterestMechanism interestsMechanism, Date correctCloseAccount) {
        this.accountId = accountId;
        this.isActive = true;
        this.amountOfMoney = initialAmountOfMoney;
        this.debit = initialDebit;
        this.owner = owner;
        this.setInterestsMechanism(interestsMechanism);
        this.correctCloseAccount = correctCloseAccount;
        this.historyOperations = new ArrayList<AbstractAccountOperation>();
    }
    
    public abstract boolean closeAccount(AbstractAccount parentAccount) throws HasChildAccountException;


    public List<AbstractAccountOperation> getHistoryOperations() {
        return this.historyOperations;
    }

    public boolean addChildAccount(AbstractAccount account) {
        if (this.childAccounts == null) {
            this.childAccounts = new ArrayList<AbstractAccount>();
        }
        this.childAccounts.add(account);
        return true;
    }

    public boolean removeChildAccount(AbstractAccount account) {
        if (this.childAccounts != null) {
            this.childAccounts.remove(account);
        }
        return true;
    }

    public abstract boolean validateInterestMechanism(AbstractInterestMechanism mechanism);

    public long getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public AbstractInterestMechanism getInterestsMechanism() {
        return interestsMechanism;
    }

    public void setInterestsMechanism(AbstractInterestMechanism interestsMechanism) {
        this.interestsMechanism = interestsMechanism;
    }

    public void addHistoryOperation(AbstractAccountOperation operation) {
        this.historyOperations.add(operation);
    }

    public long getAccountId() {
        return accountId;
    }
}
