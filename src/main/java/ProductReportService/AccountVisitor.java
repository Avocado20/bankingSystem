package ProductReportService;

import AccountingService.BasicAccount;
import AccountingService.CreditAccount;
import AccountingService.InvestmentAccount;

public class AccountVisitor {

    public String visit(BasicAccount account) {
        return "BasicAccount: money: " + account.getAmountOfMoney() + " clientId: " +account.getOwner().getClientId();
    }

    public String visit(CreditAccount account) {
        return "CreditAccout : money to pay: " + account.getAmountOfMoney() + " clientId: " +account.getOwner().getClientId();
    }

    public String visit(InvestmentAccount account) {
        return "Investment: money invested: " + account.getAmountOfMoney() + " clientId: " +account.getOwner().getClientId();
    }

}
