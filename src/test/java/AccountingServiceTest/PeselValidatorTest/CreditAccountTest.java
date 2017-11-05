package AccountingServiceTest.PeselValidatorTest;

import AccountingService.AbstractAccount;
import AccountingService.BasicAccount;
import AccountingService.CreditAccount;
import BankService.AbstractBank;
import BankService.AbstractClient;
import BankService.ConcreteBank;
import BankService.ConcreteClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class CreditAccountTest {

    private AbstractBank bank = Mockito.mock(ConcreteBank.class);
    private AbstractClient client = Mockito.mock(ConcreteClient.class);
    private AbstractAccount basicAccount;
    private CreditAccount creditAccount;

    @Before
    public void setup() {
        bank.addClient(client);
        basicAccount = new BasicAccount(2L, client, 500, 0, null);
        client.addAccount(basicAccount);
        bank.addAccount(basicAccount);
    }

    @Test
    public void closeNotPayedDebtTest() {
        basicAccount.addMoney(500l);
        creditAccount = new CreditAccount(2L, client, 500, 0, null, new Date());
        basicAccount.addChildAccount(creditAccount);
        creditAccount.addMoney(500l);
        boolean isClosed = creditAccount.closeAccount(basicAccount);
        assertTrue(isClosed);

    }
}
