package AccountingService;

public interface TransferInterface {

    /**
     * Make payment of given cashUnits into given accountInterface.
     * TODO should we replace cashUnit with currency?
     * @param cashUnits
     * @return
     */
    boolean addMoney(long cashUnits);
    boolean withdrawMoney(long cashUnit);
    boolean makeTransfer(TransferInterface targetAccount, long cashUnit);
}
