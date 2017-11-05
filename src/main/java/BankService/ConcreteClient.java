package BankService;

public class ConcreteClient extends AbstractClient {

    public ConcreteClient(long clientId, String name, String surname, String pesel, String adres) {
        super(clientId, name, surname, pesel, adres);
    }
}
