package ProductReportService;

import AccountingService.BasicAccount;
import AccountingService.CreditAccount;
import AccountingService.InvestmentAccount;

 public interface AccountVisitor {

     void visit(BasicAccount account);

     void visit(CreditAccount account);

     void visit(InvestmentAccount account);

     String getReport();
}
