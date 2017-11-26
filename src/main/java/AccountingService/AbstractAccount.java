package AccountingService;

import BankService.AbstractClient;
import InterestService.AbstractInterestMechanism;
import ProductReportService.AccountVisitor;
import ReportService.AbstractAccountOperation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractAccount {

    private int bankAccountId;
    private long accountId;
    protected boolean isActive;
    protected int amountOfMoney;
    private AbstractInterestMechanism interestsMechanism;
    private AbstractClient owner;
    protected List<AbstractAccountOperation> historyOperations;
    protected List<AbstractAccount> childAccounts;
    private Date correctCloseAccount;


    public AbstractAccount (int bankAccountId, long accountId, AbstractClient owner, int initialAmountOfMoney, AbstractInterestMechanism interestsMechanism, Date correctCloseAccount) {
        this.bankAccountId = bankAccountId;
        this.accountId = accountId;
        this.isActive = true;
        this.amountOfMoney = initialAmountOfMoney;
        this.setOwner(owner);
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

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public boolean  setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
        return true;
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


    public AbstractClient getOwner() {
        return owner;
    }

    public void setOwner(AbstractClient owner) {
        this.owner = owner;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public abstract String accept(AccountVisitor accountVisitor);

}
