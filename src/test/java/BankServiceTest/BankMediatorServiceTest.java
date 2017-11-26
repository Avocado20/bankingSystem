package BankServiceTest;

import AccountingService.BasicAccount;
import AccountingService.OperationService.InterbankTransferOperation;
import AccountingService.OperationService.TransferOperation;
import BankService.ConcreteBank;
import BankService.ConcreteClient;
import BankService.KIR;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class BankMediatorServiceTest {

    ConcreteClient client1 = Mockito.mock(ConcreteClient.class);
    ConcreteClient client2 = Mockito.mock(ConcreteClient.class);
    BasicAccount account1 = Mockito.mock(BasicAccount.class);
    BasicAccount account2 = Mockito.mock(BasicAccount.class);



    @Test
    public void interBankTransfer() {
        ConcreteBank bank1 = new ConcreteBank(1);
        ConcreteBank bank2 = new ConcreteBank(2);
        account1 = new BasicAccount(1, 2L, client1, 500, null);
        account2 = new BasicAccount(2, 2L, client2, 1500, null);
        int toTransfer = 300;
        InterbankTransferOperation operation = new InterbankTransferOperation(account1, account2, toTransfer);
        operation.execute();
        assertEquals(200, account1.getAmountOfMoney());
        assertEquals(1800, account2.getAmountOfMoney());
    }

    @Test
    public void interBankTransfernotEnoughMoney() {
        ConcreteBank bank1 = new ConcreteBank(1);
        ConcreteBank bank2 = new ConcreteBank(2);
        account1 = new BasicAccount(1, 2L, client1, 500, null);
        account2 = new BasicAccount(2, 2L, client2, 1500, null);
        int toTransfer = 800;
        InterbankTransferOperation operation = new InterbankTransferOperation(account1, account2, toTransfer);
        operation.execute();
        assertEquals(500, account1.getAmountOfMoney());
        assertEquals(1500, account2.getAmountOfMoney());
    }
}
