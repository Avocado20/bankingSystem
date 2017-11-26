package ProductReportService;

import AccountingService.AbstractAccount;
import AccountingService.BasicAccount;
import AccountingService.CreditAccount;
import AccountingService.InvestmentAccount;

import java.util.ArrayList;
import java.util.List;

public class AccountVisitor {

    List<AbstractAccount> accounts = new ArrayList<AbstractAccount>();

    public String visit(BasicAccount account) {
        return account.accept(this);

//        return "BasicAccount: money: " + account.getAmountOfMoney() + " clientId: " +account.getOwner().getClientId();
    }

    public  visit(CreditAccount account) {
        return account;
        return "CreditAccout : money to pay: " + account.getAmountOfMoney() + " clientId: " +account.getOwner().getClientId();
    }

    public InvestmentAccount visit(InvestmentAccount account) {
        return account;
//        return "Investment: money invested: " + account.getAmountOfMoney() + " clientId: " +account.getOwner().getClientId();
    }

}
