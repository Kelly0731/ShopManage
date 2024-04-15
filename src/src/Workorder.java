import java.util.Date;

public class Workorder {
    private String customerName;
    private String vin;
    private Date date;
    private String[] parts;
    private int mechanic;

    ////////////Getters
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

    ////////////Setters
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
}
