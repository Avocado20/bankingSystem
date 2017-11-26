package ReportService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Teraz ta klasa jest do wyrzucenia, bo nie można sporządzić raportów z kont, a jedynie z operacji.
public class Report {

    private Date preparationDate;
    private List<AbstractAccountOperation> listOfOperations;

    public Report() {
        this.preparationDate = new Date();
        this.listOfOperations = new ArrayList();
    }

    public boolean addListOperation(List<AbstractAccountOperation> operations) {
        if (this.listOfOperations == null) {
            this.listOfOperations = new ArrayList<AbstractAccountOperation>();
        }
        listOfOperations.addAll(operations);
        return true;
    }

    @Override
    public String toString() {
        String reportString = "";
        for (AbstractAccountOperation operation : listOfOperations) {
            reportString += operation.toString();
        }
        String mainInfo = "Data sporządzenia: " + preparationDate.getTime() + "\n";
        return mainInfo + reportString;
    }
}
