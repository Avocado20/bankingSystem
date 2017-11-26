package AccountingServiceTest.PeselValidatorTest;

import AccountingService.AbstractAccount;
import AccountingService.BasicAccount;
import AccountingService.CreditAccount;
import AccountingService.OperationService.AddMoneyOpeation;
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
        basicAccount = new BasicAccount(1, 2L, client, 500, null);
        client.addAccount(basicAccount);
        bank.addAccount(basicAccount);
    }

    //@Test
    public void closeNotPayedDebtTest() {
        AddMoneyOpeation addMoneyOpeation = new AddMoneyOpeation(basicAccount, 500);
        addMoneyOpeation.execute();
        creditAccount = new CreditAccount(1, 2L, client, 500,  null, new Date());
        basicAccount.addChildAccount(creditAccount);
        addMoneyOpeation = new AddMoneyOpeation(creditAccount, 500);
        addMoneyOpeation.execute();
        boolean isClosed = creditAccount.closeAccount(basicAccount);
        assertTrue(isClosed);

    }
}
