package BankService;

import AccountingService.AbstractAccount;

import java.util.ArrayList;
import java.util.List;

public class AbstractClient {

    private long clientId;
    private String name;
    private String surname;
    private String pesel;
    private String adres;
    private List<AbstractAccount> accounts;

    public AbstractClient(long clientId, String name, String surname, String pesel, String adres) {
        this.setClientId(clientId);
        this.setName(name);
        this.surname = surname;
        this.setPesel(pesel);
        this.setAdres(adres);
        this.accounts = new ArrayList<AbstractAccount>();
        System.out.println("Client created: " + clientId + " " + name + " " + surname + " " + pesel + " " + adres);
    };

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public List<AbstractAccount> getAccounts() {
        return accounts;
    }

    public void addAccount(AbstractAccount accounts) {
        this.accounts.add(accounts);
    }
}
