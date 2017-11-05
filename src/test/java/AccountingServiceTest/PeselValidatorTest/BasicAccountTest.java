package AccountingServiceTest.PeselValidatorTest;

import AccountingService.*;
import BankService.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BasicAccountTest {

    private AbstractBank bank = Mockito.mock(ConcreteBank.class);
    private AbstractClient client = Mockito.mock(ConcreteClient.class);
    private AbstractAccount basicAccount;

    @Before
    public void setup() {
        bank.addClient(client);
        basicAccount = new BasicAccount(2L, client, 500, 0, null);
        client.addAccount(basicAccount);
        bank.addAccount(basicAccount);
    }

    @Test
    public void addMoneyToExistingBasicAccountTest() throws NotEnoughMoneyException {
        basicAccount.addMoney(800L);
        assertEquals(1300L, basicAccount.getAmountOfMoney());
    }

    @Test
    public void withdrawMoneyFromAccountTest() throws NotEnoughMoneyException {
        basicAccount.withdrawMoney(300L);
        assertEquals(200L, basicAccount.getAmountOfMoney());
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void withdrawMoreMoneyThanInAccountTest() throws NotEnoughMoneyException {
        basicAccount.withdrawMoney(800L);
    }

    @Test
    public void closeOpenedBasicAccountTest() throws HasChildAccountException {
        basicAccount.closeAccount(null);
    }

    @Test(expected = HasChildAccountException.class)
    public void closeAccountWithChildTest() throws HasChildAccountException {
        AbstractAccount childAccount = new InvestmentAccount(2l, client, 1000, 0, null, new Date());
        basicAccount.addChildAccount(childAccount);
        basicAccount.closeAccount(null);
    }

}
