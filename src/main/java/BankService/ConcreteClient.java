package BankService;

public class ConcreteClient extends AbstractClient {

    public ConcreteClient(long clientId, String name, String surname, long pesel, String adres) throws InvalidPeselException{
        super(clientId, name, surname, pesel, adres);
    }
}
