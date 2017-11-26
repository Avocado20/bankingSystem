package AccountingServiceTest.PeselValidatorTest;

import AccountingService.*;
import AccountingService.OperationService.AddMoneyOpeation;
import AccountingService.OperationService.WithdrawMoneyOperation;
import BankService.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BasicAccountTest {

    private AbstractBank bank = Mockito.mock(ConcreteBank.class);
    private AbstractClient client = Mockito.mock(ConcreteClient.class);
    private AbstractAccount basicAccount;

    @Before
    public void setup() {
        bank.addClient(client);
        basicAccount = new BasicAccount(1, 2L, client, 500, null);
        client.addAccount(basicAccount);
        bank.addAccount(basicAccount);
    }

    @Test
    public void addMoneyToExistingBasicAccountTest() throws NotEnoughMoneyException {
        AddMoneyOpeation addMoneyOpeation = new AddMoneyOpeation(basicAccount, 800);
        addMoneyOpeation.execute();
        assertEquals(1300L, basicAccount.getAmountOfMoney());
    }

    @Test
    public void withdrawMoneyFromAccountTest() throws NotEnoughMoneyException {
        WithdrawMoneyOperation withdrawMoneyOperation = new WithdrawMoneyOperation(basicAccount, 300);
        withdrawMoneyOperation.execute();
        assertEquals(200L, basicAccount.getAmountOfMoney());
    }

    @Test
    public void withdrawMoreMoneyThanInAccountTest() {
        WithdrawMoneyOperation withdrawMoneyOperation = new WithdrawMoneyOperation(basicAccount, 800);
        assertFalse(withdrawMoneyOperation.execute());
    }

    @Test
    public void closeOpenedBasicAccountTest() throws HasChildAccountException {
        basicAccount.closeAccount(null);
    }

    @Test(expected = HasChildAccountException.class)
    public void closeAccountWithChildTest() throws HasChildAccountException {
        AbstractAccount childAccount = new InvestmentAccount(1,2l, client, 1000,  null, new Date());
        basicAccount.addChildAccount(childAccount);
        basicAccount.closeAccount(null);
    }

}
