package ProductReportService;

import AccountingService.*;

import java.util.ArrayList;
import java.util.List;

public class ReportAccountGenerator {

    private List<AbstractAccount> basicAccounts = new ArrayList<AbstractAccount>();

    public ReportAccountGenerator() {

    }

    public void addAccount(AbstractAccount account) {
        this.basicAccounts.add(account);
    }

    public String generateReport() {
        AccountVisitor accountVisitor = new AccountVisitor();
        String report = "";

        for(AbstractAccount account: basicAccounts) {
            report += account.accept(accountVisitor);
        }
        System.out.println(report);
        return report;
    }

}
