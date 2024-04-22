public class Inventory {
    private String partName;
    private int partNumber;
    private int quantity;

    public Inventory(String partName, int partNumber, int quantity) {
        this.partName = partName;
        this.partNumber = partNumber;
        this.quantity = quantity;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
  public void print(){
    System.out.print("Part Name: " + partName);
    System.out.print(", Part Number: " + partNumber);
    System.out.println(", Quantity: " + quantity);
  }
}
