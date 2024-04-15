public class Manager {
    private int id;
    private String name;
    public Manager(String name, int id){
        setName(name);
        setId(id);
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Methods
    public Workorder createWorkOrder(int number){
        Workorder workOrder = new Workorder(number);
        return workOrder;
    }

    public void assignWorkorder(Workorder w, int mechID){
        //logic to assign workorder to a mechanic
        w.setMechanic(mechID);
    }

    public void approveWorkorder(Workorder w){
        w.setApproved(true);
    }
}
