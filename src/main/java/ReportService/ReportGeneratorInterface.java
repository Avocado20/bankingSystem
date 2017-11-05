package ReportService;

import AccountingService.AbstractAccount;

import java.util.List;

public interface ReportGeneratorInterface {

    Report createReport(List<AbstractAccount> accounts);
}
