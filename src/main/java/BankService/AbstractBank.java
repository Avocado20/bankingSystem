package BankService;

import AccountingService.AbstractAccount;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBank {

    private long bankId;
    private List<AbstractClient> clients;
    private List<AbstractAccount> accounts;

    public AbstractBank(long bankId) {
        this.bankId = bankId;
        System.out.println("Bank: " + bankId + " created");
        clients = new ArrayList<AbstractClient>();
    }

    public boolean addClient (AbstractClient client) {
        this.clients.add(client);
        return true;
    }

    public boolean addAccount(AbstractAccount account) {
        this.accounts.add(account);
        return true;
    }

}
