package ProductReportService;

import AccountingService.BasicAccount;
import AccountingService.CreditAccount;
import AccountingService.InvestmentAccount;

public class AccountAgregableVisitor implements AccountVisitor {

    int totalAmountOfMoney = 0;
    int amountOfAccount = 0;

    public void visit(BasicAccount account) {
        totalAmountOfMoney += account.getAmountOfMoney();
        amountOfAccount+=1;
    }

    public void visit(CreditAccount account) {
        totalAmountOfMoney += account.getAmountOfMoney();
        amountOfAccount+=1;
    }

    public void visit(InvestmentAccount account) {
        totalAmountOfMoney += account.getAmountOfMoney();
        amountOfAccount+=1;
    }

    public String getReport() {
        return "Amount of Accounts: " + String.valueOf(amountOfAccount) + ", Total amount of money: " + String.valueOf(totalAmountOfMoney);
    }

}
