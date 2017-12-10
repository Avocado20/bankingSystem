package ProductReportService;

import AccountingService.*;

import java.util.ArrayList;
import java.util.List;

public class ReportAccountGenerator {

    private List<AbstractAccount> basicAccounts = new ArrayList<AbstractAccount>();

    public ReportAccountGenerator() {

    }

    public void addAccount(AbstractAccount account) {
        if (account != null) {
            this.basicAccounts.add(account);
        }
    }

    public String generateSelectReport() {
        AccountSelectibleVisitor accountSelectibleVisitor = new AccountSelectibleVisitor();
        for(AbstractAccount account: basicAccounts) {
            account.accept(accountSelectibleVisitor);
        }
        return accountSelectibleVisitor.getReport();
    }

    public String generateAgregateReport() {
        AccountAgregableVisitor accountAgregableVisitor = new AccountAgregableVisitor();

        for (AbstractAccount account: basicAccounts) {
            account.accept(accountAgregableVisitor);
        }
        return accountAgregableVisitor.getReport();
    }

}
