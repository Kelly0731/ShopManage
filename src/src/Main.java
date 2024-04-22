import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Manager Dave = new Manager("Bill", 28974);
        Mechanic Brian = new Mechanic("Bob", 03476);
        Billing Jenny = new Billing(150, .30);
        InventoryManager Tamara = new InventoryManager();
        Workorder workorder001 = Dave.createWorkOrder(001, "Caleb", "1FTD7Z0943", new Date(2024,04,21));
        Dave.assignWorkorder(workorder001, 03476);
        Brian.addPart(workorder001, "Alternator", 145783, 49.99, 129.99, "Replaced Alternator");
        Dave.approveWorkorder(workorder001);
        Tamara.addInventory(new Inventory("Alternator", 145783, 4));
        Tamara.processWorkorder(workorder001);
        Brian.viewWorkorder(workorder001);
        double total = Jenny.billWorkorder(workorder001);
        System.out.println("Total Due: $" + total);
    }
}
