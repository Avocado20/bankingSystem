# Bank system

## Zastosowane wzorce projektowe:

* ### Command
  AccountingService->OperationService wszystkie operacje implementują interfejs OperationInterface
* ### State
  InterestService -> AbstractInterestMechanism jest wrzucony do każdego typu konta i można go dowolnie podmieniać w każdym koncie.
* ### Dekorator
  AccountingService-> DebitAccount jest dekoratorem zwykłego konta. Uzupełnia jego działanie o debet
* ### Mediator
  OperationService -> InterbankTransferOperation wykorzystuje klasę KIR, aby dokonać przelewu na konto z innego banku.
* ### Visitor
  ProductReportService -> ReportAccountGenerator wykorzystuje Visitora do wygenerowania dwóch rodzajów raportów: AccountAgregableReport oraz AccountSelectibleReport.
