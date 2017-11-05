package ReportService;

import AccountingService.AbstractAccount;

import java.util.List;

public class ConcreteReportClassGenerator implements ReportGeneratorInterface {

    public Report createReport(List<AbstractAccount> accounts) {
        String reportBody = "";
        for (AbstractAccount account : accounts) {
            for (AccountOperation operation : account.getHistoryOperations()) {
                reportBody += operation.toString() + "\n, ";
            }
        }
        return new Report(reportBody);
    }
}
