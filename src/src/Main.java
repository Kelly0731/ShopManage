public class Main {
    public static void main(String[] args) {
        Manager Bill = new Manager("Bill", 28974);
        Mechanic Bob = new Mechanic("Bob", 03476);
        Workorder workorder001 = Bill.createWorkOrder(001);
        Bill.assignWorkorder(workorder001, 03476);

    }
}
