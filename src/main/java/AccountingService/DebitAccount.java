package AccountingService;

import ProductReportService.AccountSelectibleVisitor;
import ProductReportService.AccountVisitor;
import ProductReportService.Visitorable;

public class DebitAccount extends BasicAccount {

    private int debit;

    public DebitAccount(AbstractAccount account, int debit) {
        super(account.getBankAccountId(), account.getAccountId(), account.getOwner(), account.getAmountOfMoney(), account.getInterestsMechanism());
        this.debit = debit;
    }

    @Override
    public int getAmountOfMoney() {
        return super.getAmountOfMoney() + this.getDebit();
    }

    @Override
    public boolean setAmountOfMoney(int cashUnits) {
        if (cashUnits < this.getDebit()) {
            super.setAmountOfMoney(0);
            this.setDebit(cashUnits);
        }
        return true;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public void accept(AccountVisitor accountSelectibleVisitor) {
        accountSelectibleVisitor.visit(this);
    }
}
