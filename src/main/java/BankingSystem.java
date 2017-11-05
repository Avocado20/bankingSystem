import AccountingService.BasicAccount;
import BankService.AbstractBank;
import BankService.AbstractClient;
import BankService.ConcreteBank;
import BankService.ConcreteClient;
import InterestService.AbstractInterestMechanism;
import InterestService.DebtInterestMechanism;
import InterestService.InvestInterestMechanism;

public class BankingSystem {

    public static void main(String [] args) {
        System.out.println("Hello");
        AbstractBank bank = new ConcreteBank(1L);
        AbstractClient firstClient = new ConcreteClient(2L,"Karolina", "Dyndul", "nieMaTakiegoPisania", "nieMieszkamPodAdresemZameldowania");
        AbstractClient secondClient = new ConcreteClient(3L,"Robert", "Galewski", "nieMaTakiegoPisania", "nieMieszkamPodAdresemZameldowania");
        AbstractInterestMechanism mechanism1 = new InvestInterestMechanism(30.0, 12);
        AbstractInterestMechanism mechanism2 = new DebtInterestMechanism(-30.0, 12);
        firstClient.addAccount(new BasicAccount(4L,firstClient, 500, 300, mechanism1));
        secondClient.addAccount(new BasicAccount(5L, firstClient, 500, 300, mechanism2));
        bank.addClient(firstClient);
        bank.addClient(secondClient);
    }
}
