import java.util.ArrayList;

public class InventoryManager {

    private ArrayList<Inventory> inventories;

    public InventoryManager() {
        this.inventories = new ArrayList<>();
    }

    public void addInventory(Inventory inventory) {
        this.inventories.add(inventory);
    }

    public void processWorkorder(Workorder workorder) {
        String[] parts = workorder.getParts();
        for (String part : parts) {
            for (Inventory inventory : inventories) {
                if (inventory.getPartName().equals(part)) {
                    inventory.setQuantity(inventory.getQuantity() - 1);
                }
            }
        }
    }

    public void addQuantity(String partName, int quantityToAdd) {
        if (partName == null || quantityToAdd < 0) {
            System.out.println("Invalid input");
            return;
        }
        for (Inventory inventory : inventories) {
            if (inventory.getPartName().equals(partName)) {
                inventory.setQuantity(inventory.getQuantity() + quantityToAdd);
            }
        }

    }

    public void print() {
        for (Inventory inventory : inventories) {
            inventory.print();
        }
    }
}
    //Name onCreate
    //Has Array of INVENTORY OBJECTS
    //When Given Work Order, moves through all parts used based on pn
    //If part is in inventory, subtracts from quantity
    //method to add to quantity
