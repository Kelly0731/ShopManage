import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Manager Bill = new Manager("Bill", 28974);
        Mechanic Bob = new Mechanic("Bob", 03476);
        Workorder workorder001 = Bill.createWorkOrder(001, "Caleb", "1FTD7Z0943", new Date(2024,04,21));
        Bill.assignWorkorder(workorder001, 03476);
        Bob.addPart(workorder001, "Alternator", 145783, 49.99, 129.99, "Replaced Alternator");
        Billing Jenny = new Billing(150, .30);
        double total = Jenny.billWorkorder(workorder001);
        System.out.println(total);
    }
}
