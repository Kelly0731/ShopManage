public class Billing {
    private double SERVICE_FEE;
    private double markup;

    public Billing(double sf, double m){
        SERVICE_FEE = sf;
        markup = m;
    }

    public double billWorkorder(Workorder w) {
        if(w.isApproved()) {
            double[] l = w.getLabor();
            double[] p = w.getPartPrice();
            double hoursWorked = 0;
            double partPrice = 0;
            for (int i = 0; i < l.length; i++) {
                hoursWorked += l[i];
            }
            for (int i = 0; i < p.length; i++) {
                partPrice += p[i];
            }
            double wage = w.getWage();
            return calculateBill(partPrice, hoursWorked, wage);
        }
        else return -1;
    }

    public double calculateBill(Double parts, Double hoursWorked, double wage) {
        return (parts * markup) + (hoursWorked * wage) + SERVICE_FEE;
    }
}

