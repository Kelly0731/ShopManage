import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Manager Bill = new Manager("Bill", 28974);
        Mechanic Bob = new Mechanic("Bob", 03476);
        Workorder workorder001 = Bill.createWorkOrder(001, "Caleb", "1FTD7Z0943", new Date(2024,04,21));
        Bill.assignWorkorder(workorder001, 03476);

        Billing Jenny = new Billing(150, .30);
        Jenny.billWorkorder(workorder001);
    }
}
