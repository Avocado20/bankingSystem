package AccountingService.OperationService;

import java.util.Date;

public abstract class AbstractAccountOperation {

    private long productId;
    private Date operationDate;
    private String operationDescription;

    public AbstractAccountOperation(long productId, String operationDescription) {
        this.productId = productId;
        this.operationDate = new Date();
        this.operationDescription = operationDescription;
    }

    @Override
    public String toString() {
        return "Product: " + productId + ", date: " + operationDate.toString() + ", operation description: " + operationDescription;
    }

}
