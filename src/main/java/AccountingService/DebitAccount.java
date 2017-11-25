package AccountingService;

public class DebitAccount extends BasicAccount {

    private long debit;

    public DebitAccount(AbstractAccount account, long debit) {
        super(account.getAccountId(), account.getOwner(), account.getAmountOfMoney(), account.getInterestsMechanism());
        this.debit = debit;
    }

    @Override
    public int getAmountOfMoney() {
        return super.getAmountOfMoney() + this.getDebit();
    }

    @Override
    public void setAmountOfMoney(int cashUnits) {
//        if (cashUnits < super.getAmountOfMoney()) {
//            super.setAmountOfMoney(cashUnits);
//        } else {
//            int howMuchDebit = cashUnits - super.getAmountOfMoney();
//            super.setAmountOfMoney(0);
//            this.setDebit(this.getDebit() - howMuchDebit);
//        }

        super.setAmountOfMoney(cashUnits-this.getDebit());
    }

    public int getDebit() {
        return (int) debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }
}
