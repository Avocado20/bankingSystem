package AccountingService;

import BankService.AbstractClient;
import InterestService.AbstractInterestMechanism;
import InterestService.InterestsMechanism;
import ReportService.AbstractAccountOperation;
import ReportService.ConcreteOperation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractAccount implements TransferInterface {

    protected long accountId;
    protected boolean isActive;
    protected long amountOfMoney;
    protected long debit;
    protected InterestsMechanism interestsMechanism;
    protected AbstractClient owner;
    protected List<AbstractAccountOperation> historyOperations;
    protected List<AbstractAccount> childAccounts;
    private Date correctCloseAccount;


    public AbstractAccount (long accountId, AbstractClient owner, int initialAmountOfMoney, int initialDebit, InterestsMechanism interestsMechanism, Date correctCloseAccount) {
        this.accountId = accountId;
        this.isActive = true;
        this.amountOfMoney = initialAmountOfMoney;
        this.debit = initialDebit;
        this.owner = owner;
        this.interestsMechanism = interestsMechanism;
        this.correctCloseAccount = correctCloseAccount;
        this.historyOperations = new ArrayList<AbstractAccountOperation>();
    }
    
    public abstract boolean closeAccount(AbstractAccount parentAccount) throws HasChildAccountException;

    public boolean addMoney(long cashUnits) {
        this.setAmountOfMoney(this.getAmountOfMoney() + cashUnits);
        this.historyOperations.add(new ConcreteOperation(this.accountId, "add Money: " + cashUnits));
        return true;
    };

    public boolean withdrawMoney(long cashUnits) throws NotEnoughMoneyException {
        if ( cashUnits > this.getAmountOfMoney()) {
            throw new NotEnoughMoneyException();
        } else {
            this.setAmountOfMoney(this.getAmountOfMoney() - cashUnits);
            this.historyOperations.add(new ConcreteOperation(this.accountId, "witdraw Money: " + cashUnits));
        }
        return true;
    };

    public boolean makeTransfer(TransferInterface targetAccount, long cashUnit) throws NotEnoughMoneyException{
        this.withdrawMoney(cashUnit);
        targetAccount.addMoney(cashUnit);
        this.historyOperations.add(new ConcreteOperation(this.accountId, "make Money transfer: " + cashUnit));
        return true;
    };

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
}
