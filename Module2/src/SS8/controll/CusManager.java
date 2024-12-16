package SS8.controll;
import SS8.view.Menu;
import java.util.Scanner;
import SS8.service.CustomerService;

    public class CusManager extends Menu {
        static String[] options = {"Manage Customers", "Quit"};
        private final CustomerService customerService;
        private final Scanner sc;

        public CusManager(String title, String[] options) {
            super(title, options);
            this.customerService = new CustomerService();
            this.sc = new Scanner(System.in);
        }

        @Override
        public void execute(int choice) {
            switch (choice) {
                case 1:
                    manageCustomers();
                    break;
                case 2:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        private void manageCustomers() {
            String[] customerOptions = {"Display all customers", "Add a customer", "Update a customer", "Delete a customer", "Return"};
            Menu customerMenu = new Menu("Customer Management", customerOptions) {
                @Override
                public void execute(int choice) {
                    switch (choice) {
                        case 1:
                            customerService.display();
                            break;
                        case 2:
                            customerService.add();
                            break;
                        case 3:
                            customerService.update();
                            break;
                        case 4:
                            System.out.print("Enter customer ID to delete: ");
                            String customerId = sc.nextLine();
                            customerService.delete(customerId);
                            break;
                        case 5:
                            System.out.println("Returning to main menu...");
                            break;
                        default:
                            System.out.println("Invalid choice! Please try again.");
                    }
                }
            };
            customerMenu.run();
        }

        public static void main(String[] args) {
            CusManager manager = new CusManager("Customer Management System", options);
            manager.run();
        }
    }

