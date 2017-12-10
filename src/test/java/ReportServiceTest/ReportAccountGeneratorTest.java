package ReportServiceTest;

import AccountingService.BasicAccount;
import AccountingService.CreditAccount;
import AccountingService.InvestmentAccount;
import BankService.ConcreteClient;
import ProductReportService.ReportAccountGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class ReportAccountGeneratorTest {

    private ConcreteClient concreteClient = new ConcreteClient(1, "R", "G", 9234525, "");
    private BasicAccount basicAccount = new BasicAccount(1,2, concreteClient, 1500, null);
    private CreditAccount creditAccount = new CreditAccount(2,3, concreteClient, 1500, null, new Date());
    InvestmentAccount investmentAccount = new InvestmentAccount(1,2, concreteClient, 1500, null, new Date());
    private ReportAccountGenerator reportAccountGenerator;
    @Before
    public void setup() {
        reportAccountGenerator = new ReportAccountGenerator();
        reportAccountGenerator.addAccount(creditAccount);
        reportAccountGenerator.addAccount(basicAccount);
        reportAccountGenerator.addAccount(investmentAccount);
    }

    private String expectedSelectableReport = "CreditAccount : money to pay: 1500 clientId: 1BasicAccount : money: 1500 clientId: 1Investment: money invested: 1500 clientId: 1";
    @Test
    public void generateSelectableReportTest() {
        String report = reportAccountGenerator.generateSelectReport();
        assertEquals(expectedSelectableReport, report);
    }

    private String agregableReport = "Amount of Accounts: 3, Total amount of money: 4500";
    @Test
    public void generateAgregableReportTest() {
        String report = reportAccountGenerator.generateAgregateReport();
        assertEquals(agregableReport, report);
    }

    private String agregableWithNullReport = "Amount of Accounts: 3, Total amount of money: 4500";
    @Test
    public void generateAgregableReportWithnullTest() {
        reportAccountGenerator.addAccount(null);
        String report = reportAccountGenerator.generateAgregateReport();
        assertEquals(agregableWithNullReport, report);
    }
}
