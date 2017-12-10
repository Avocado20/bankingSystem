package ProductReportService;

public interface Visitorable {
    void accept(AccountVisitor accountSelectibleVisitor);
}
