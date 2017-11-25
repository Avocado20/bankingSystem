package AccountingServiceTest.PeselValidatorTest;

import AccountingService.AbstractAccount;
import AccountingService.BasicAccount;
import AccountingService.CreditAccount;
import AccountingService.DebitAccount;
import AccountingService.OperationService.WithdrawMoneyOperation;
import BankService.AbstractBank;
import BankService.AbstractClient;
import BankService.ConcreteBank;
import BankService.ConcreteClient;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertEquals;

public class DebitAccountTest {

    private AbstractBank bank = Mockito.mock(ConcreteBank.class);
    private AbstractClient client = Mockito.mock(ConcreteClient.class);
    private DebitAccount debitAccount;

    @Test
    public void debitAccountOperationTest() {
        debitAccount = new DebitAccount(new BasicAccount(4l, client,1000, null), 500);
        WithdrawMoneyOperation withdrawMoneyOperation = new WithdrawMoneyOperation(debitAccount, 1200);
        withdrawMoneyOperation.execute();
        assertEquals(0, debitAccount.getAmountOfMoney());
        assertEquals(300, debitAccount.getDebit());
        //popraw tę wypłatę!
    }
}
