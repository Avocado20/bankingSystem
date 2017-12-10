package ProductReportService;

import AccountingService.BasicAccount;
import AccountingService.CreditAccount;
import AccountingService.InvestmentAccount;

public class AccountSelectibleVisitor implements AccountVisitor {

    String report = "";

    public void visit(BasicAccount account) {
        report += "BasicAccount : money: " + account.getAmountOfMoney() + " clientId: " +account.getOwner().getClientId();
    }

    public void visit(CreditAccount account) {
        report += "CreditAccount : money to pay: " + account.getAmountOfMoney() + " clientId: " +account.getOwner().getClientId();
    }

    public void visit(InvestmentAccount account) {
        report += "Investment: money invested: " + account.getAmountOfMoney() + " clientId: " +account.getOwner().getClientId();
    }

    public String getReport() {
        return report;
    }

}
