package ReportService;

import AccountingService.AbstractAccount;

import java.util.List;

public class ConcreteReportClassGenerator implements ReportGeneratorInterface {

    public Report createReport(List<AbstractAccount> accounts) {
        Report report  = new Report();
        for (AbstractAccount account : accounts) {
            report.addListOperation(account.getHistoryOperations());
        }
        return report;
    }
}
