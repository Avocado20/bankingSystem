package BankService;

import AccountingService.AbstractAccount;

import java.util.List;

public class AbstractClient {

    private long clientId;
    private String name;
    private String surname;
    private String pesel;
    private String adres;
    private List<AbstractAccount> accounts;

    public AbstractClient(String name, String surname, String pesel, String adres) {
        this.clientId = (long) Math.random();
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.adres = adres;
    };
}
