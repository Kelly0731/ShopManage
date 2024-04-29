import java.util.ArrayList;
import java.util.Date;

public class Mechanic {

    private String name;
    private int id;

    public Mechanic(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public Workorder createWorkOrder(int number, String customerName, String vin, Date date){
        Workorder workOrder = new Workorder(number, customerName, vin, date);
        return workOrder;
    }
    public int getId() {
        return this.id;
    }
    public void viewWorkorder(Workorder w){
        w.print();
    }
    public void addPart(Workorder w, String p, int pN, double pP, double l, String d){
        w.addItem(p, pN, pP, l, d);
    }

}
