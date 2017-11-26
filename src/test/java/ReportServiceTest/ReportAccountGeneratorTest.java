package ReportServiceTest;

import AccountingService.BasicAccount;
import AccountingService.CreditAccount;
import AccountingService.InvestmentAccount;
import BankService.ConcreteClient;
import ProductReportService.ReportAccountGenerator;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class ReportAccountGeneratorTest {

    String expectedReport = "CreditAccout : money to pay: 1500 clientId: 1BasicAccount: money: 1500 clientId: 1Investment: money invested: 1500 clientId: 1";
    @Test
    public void generateReportFromEveryTypeOfAccounts() {
        ConcreteClient concreteClient = new ConcreteClient(1, "R", "G", 9234525, "");
        BasicAccount basicAccount = new BasicAccount(1,2, concreteClient, 1500, null);
        CreditAccount creditAccount = new CreditAccount(2,3, concreteClient, 1500, null, new Date());
        InvestmentAccount investmentAccount = new InvestmentAccount(1,2, concreteClient, 1500, null, new Date());
        ReportAccountGenerator reportGenerator = new ReportAccountGenerator();
        reportGenerator.addAccount(creditAccount);
        reportGenerator.addAccount(basicAccount);
        reportGenerator.addAccount(investmentAccount);
        String report = reportGenerator.generateReport();
        assertEquals(expectedReport, report);
    }
}
