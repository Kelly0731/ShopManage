import java.util.ArrayList;

public class Mechanic {
    private ArrayList<Workorder> workOrders;
    private String name;
    private int id;

    public Mechanic(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public Workorder createWorkOrder(int number){
        Workorder workOrder = new Workorder(number);
        workOrders.add(workOrder);
        return workOrder;
    }
    /*public void addItemToWorkOrder(Workorder workOrder, Item item){
        workOrder.addItem(item);
    }*/


   /* public void updateWorkOrderStatus(Workorder workOrder, boolean isComplete) {
       workOrder.setComplete(isComplete);
    }*/

  /*  public boolean getApproval(Manager manager, Workorder workOrder) {
        return manager.approveWorkorder(workOrder);
    } */
}
//.For mechanic class
/// array list of work orders that is assigned to a mechanic, connected to number of how much of that object is in inventory
//  mechanic can add a work order
//   mechanic can update if the work order is complete
//  mechanic can request list of "low stock" items in inventory (if workorder == complete, added to "complete" array)
//   DATABASE to store upcoming work orders, previous work done on the car and parts used
//
// create Workorder (ID, title, parts)
//  edit workorder (ID, title, stock)
//create a method that shows past orders,
// to illustrate what has been done on the vehicle in the pst
//a method to create and edit work orders for the vehicles
//a method for the mechanic to get an approval for his work order from the manager
// public Workorder createWorkOrder(int number){
//   Workorder workorder= new Workorder(number);
//   return workorder;
//  }