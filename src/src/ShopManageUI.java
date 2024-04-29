import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
//Is it working
public class ShopManageUI {
    private InventoryManager inventoryManager;
    private Scanner scanner;

    private List<Manager> managers;
    private List<Workorder> workorders;




    public ShopManageUI(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        this.managers = new ArrayList<>();
        this.mechanics = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() throws ParseException {
        while (true) {
            System.out.println("Welcome to ShopManage!");
            System.out.println("1. Add inventory");
            System.out.println("2. Process work order");
            System.out.println("3. Add manager");
            System.out.println("4. Print inventory");
            System.out.println("5. Add mechanic");
            System.out.println("6. View work orders");
            System.out.println("7. Approve Work Order");
            System.out.println("8. Assign Work Order");
            System.out.println("9. Add Item to Workorder");
            System.out.println("10. Exit");
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
                    addMechanic();
                    break;
                case 6:
                    viewWorkOrders();
                    break;
                case 7:
                    approveWorkOrder();
                    break;
                case 8:
                    assignWorkOrder();
                    break;
                case 9:
                    addItemtoWorkOrder();
                    break;
                case 10:
                  return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
    private void approveWorkOrder() {
        System.out.print("Enter manager ID: ");
        int managerId = scanner.nextInt();
        scanner.nextLine();  // consume newline left-over

        System.out.print("Enter work order number: ");
        int workOrderNumber = scanner.nextInt();
        scanner.nextLine();  // consume newline left-over

        Manager manager = findManagerById(managerId);
        Workorder workOrder = findWorkOrderById(workOrderNumber);

        if (manager != null && workOrder != null) {
            manager.approveWorkorder(workOrder);
            System.out.println("Work order approved successfully.");
        } else {
            System.out.println("Manager or work order not found.");
        }
    }

    private Manager findManagerById(int id) {
        for (Manager manager : managers) {
            if (manager.getId() == id) {
                return manager;
            }
        }
        return null;
    }
    private Workorder findWorkOrderById(int number) {
        for (Workorder workOrder : workorders) {
            if (workOrder.getNumber() == number) {
                return workOrder;
            }
        }
        return null;
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
    private Mechanic findMechanic(int id) {
        for (Mechanic mechanic : mechanics) {
            if (mechanic.getId() == id) {
                return mechanic;
            }
        }
        return null;
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



        System.out.println("What is your position?");
        System.out.println("1. Mechanic");
        System.out.println("2. Manager");
        int level = scanner.nextInt();
        switch(level) {
            case 1:
                //Mechanic
                System.out.println("What is your ID:");
                int id = scanner.nextInt();
                Workorder workOrder1 = findMechanic(id).createWorkOrder(number, customerName, vin, date);
                workorders.add(workOrder1);

                System.out.println("Work order created successfully.");
                break;
            case 2:
                //Manager
                System.out.println("What is your ID:");
                int id1 = scanner.nextInt();
                Workorder workOrder = findManagerById(id1).createWorkOrder(number, customerName, vin, date);


                System.out.print("Enter wage: ");
                double wage = scanner.nextDouble();
                scanner.nextLine();  // consume newline left-over
                findManagerById(id1).setWorkorderWage(workOrder, wage);
                workorders.add(workOrder);

                System.out.println("Work order created successfully.");
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 2.");
        }




        // Set wage for the work order


        // Assign the work order to a mechanic
        //manager.assignWorkorder(workOrder, mechID);

        // Approve the work order
        //manager.approveWorkorder(workOrder);


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
    private List<Mechanic> mechanics;

    private void addMechanic() {
        System.out.print("Enter mechanic name: ");
        String name = scanner.nextLine();
        System.out.print("Enter mechanic ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume newline left-over

        Mechanic mechanic = new Mechanic(name, id);
        mechanics.add(mechanic);

        System.out.println("Mechanic added successfully.");
    }
    private void viewWorkOrders() {
        if (workorders.isEmpty()) {
            System.out.println("No work orders to display.");
        } else {
            for (Workorder workOrder : workorders) {
                workOrder.print();
            }
        }
    }
    private void assignWorkOrder() {
        System.out.print("Enter mechanic ID: ");
        int mechanicId = scanner.nextInt();
        scanner.nextLine();  // consume newline left-over

        System.out.print("Enter work order number: ");
        int workOrderNumber = scanner.nextInt();
        scanner.nextLine();  // consume newline left-over

        Mechanic mechanic = findMechanic(mechanicId);
        Workorder workOrder = findWorkOrderById(workOrderNumber);

        if (mechanic != null && workOrder != null) {
            workOrder.setMechanic(mechanicId);
            System.out.println("Work order assigned successfully.");
        } else {
            System.out.println("Mechanic or work order not found.");
        }
    }
    private void addItemtoWorkOrder() {
        System.out.print("Enter work order number: ");
        int workOrderNumber = scanner.nextInt();
        scanner.nextLine();  // consume newline left-over

        Workorder workOrder = findWorkOrderById(workOrderNumber);

        if (workOrder != null) {
            System.out.print("Enter part name: ");
            String partName = scanner.nextLine();

            System.out.print("Enter part number: ");
            int partNumber = scanner.nextInt();
            scanner.nextLine();  // consume newline left-over

            System.out.print("Enter part price: ");
            double partPrice = scanner.nextDouble();
            scanner.nextLine();  // consume newline left-over

            System.out.print("Enter labor cost: ");
            double laborCost = scanner.nextDouble();
            scanner.nextLine();  // consume newline left-over

            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            workOrder.addItem(partName, partNumber, partPrice, laborCost, description);
            System.out.println("Item added to work order successfully.");
        } else {
            System.out.println("Work order not found.");
        }
    }


}

