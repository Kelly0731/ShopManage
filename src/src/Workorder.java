import java.util.Date;

public class Workorder {
    private int number;
    private String customerName;
    private String vin;
    private Date date;
    private String[] parts = new String[99];
    private String[] labor = new String[99];
    private String[] description = new String[99];
    private int mechanic;
    private boolean approved = false;
    private int pointer = 0;

    public Workorder(int number) {
        this.number = number;
    }

    //Getters

    public int getNumber() {
        return number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getVin() {
        return vin;
    }

    public Date getDate() {
        return date;
    }

    public String[] getParts() {
        return parts;
    }

    public int getMechanic() {
        return mechanic;
    }

    public boolean isApproved() {
        return approved;
    }
    //Setters

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setParts(String[] parts) {
        this.parts = parts;
    }

    public void setMechanic(int mechanic) {
        this.mechanic = mechanic;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    //Methods
    public void addItem(String p, String l, String d){
        parts[pointer] = p;
        labor[pointer] = l;
        description[pointer] = d;
        pointer++;
    }
}

