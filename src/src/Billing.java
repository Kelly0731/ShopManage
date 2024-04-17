public class Billing {
    private static final double SERVICE_FEE = 50.55;
    private final double wage;
    private final double hoursWorked;

    public Billing(double hoursWorked, double wage) {
        this.hoursWorked = hoursWorked;
        this.wage = wage;
        calculateBill(hoursWorked, wage);
    }

    public double calculateBill(double hoursWorked, double wage) {
        return hoursWorked * wage + SERVICE_FEE;
    }
}

