import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class ShopManageUI {
    private InventoryManager inventoryManager;
    private Scanner scanner;

    private List<Manager> managers;




    public ShopManageUI(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        this.managers = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() throws ParseException {
        while (true) {
            System.out.println("Welcome to ShopManage!");
            System.out.println("1. Add inventory");
            System.out.println("2. Process work order");
            System.out.println("3. Add manager");
            System.out.println("4. Print inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline left-over

            switch (choice) {
                case 1:
                    addInventory();
                    break;
                case 2:
                    processWorkOrder();
                    break;
                case 3:
                    addManager();
                    break;
                case 4:
                    printInventory();
                    break;
                case 5:
                    return;  // exit method, thus terminating the program
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private void addInventory() {
        System.out.print("Enter part name: ");
        String partName = scanner.nextLine();
        System.out.print("Enter part number: ");
        int partNumber = scanner.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // consume newline left-over

        inventoryManager.addInventory(new Inventory(partName, partNumber, quantity));
    }

    private void processWorkOrder() throws ParseException {
        System.out.print("Enter work order number: ");
        int number = scanner.nextInt();
        scanner.nextLine();  // consume newline left-over

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter VIN: ");
        String vin = scanner.nextLine();

        System.out.print("Enter date (yyyy-mm-dd): ");
        String dateInput = scanner.nextLine();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);

        System.out.print("Enter mechanic ID: ");
        int mechID = scanner.nextInt();
        scanner.nextLine();  // consume newline left-over

        System.out.print("Enter wage: ");
        double wage = scanner.nextDouble();
        scanner.nextLine();  // consume newline left-over

        // Create a new manager
        Manager manager = new Manager("Manager Name", 12345);

        // Create a work order
        Workorder workOrder = manager.createWorkOrder(number, customerName, vin, date);

        // Set wage for the work order
        manager.setWorkorderWage(workOrder, wage);

        // Assign the work order to a mechanic
        manager.assignWorkorder(workOrder, mechID);

        // Approve the work order
        manager.approveWorkorder(workOrder);

        System.out.println("Work order processed successfully.");
    }

    private void printInventory() {
        inventoryManager.print();
    }
    private void addManager() {
        System.out.print("Enter manager name: ");
        String name = scanner.nextLine();
        System.out.print("Enter manager ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume newline left-over

        Manager manager = new Manager(name, id);
        managers.add(manager);

        System.out.println("Manager added successfully.");
    }
}