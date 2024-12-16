package SS8.service;
import SS8.model.Customer;

import java.util.Scanner;
public class CustomerService implements ICustomerService {
    private static final Customer[] customers = new Customer[100];

    static {
        customers[0] = new Customer(1, "Nguyễn Văn A", "01/01/1990", "123 Đường Chính");
        customers[1] = new Customer(2, "Trần Thị B", "02/02/1991", "456 Đường Phố");
        customers[2] = new Customer(3, "Lê Thị C", "03/03/1992", "789 Đường Cây");
        customers[3] = new Customer(4, "Phan Minh D", "04/04/1993", "101 Đường Sồi");
        customers[4] = new Customer(5, "Vũ Hồng E", "05/05/1994", "202 Đường Quế");
        customers[5] = new Customer(6, "Hoàng Mai F", "06/06/1995", "303 Đường Đào");
        customers[6] = new Customer(7, "Trương Thái G", "07/07/1996", "404 Đường Dương");
        customers[7] = new Customer(8, "Ngô Hồng I", "08/08/1997", "505 Đường Tùng");
        customers[8] = new Customer(9, "Bùi Quang J", "09/09/1998", "606 Đường Mai");
        customers[9] = new Customer(10, "Đặng Thanh K", "10/10/1999", "707 Đường Lúa");
    }

    @Override
    public void display() {
        System.out.println("\nDanh sách Khách hàng:");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("| %-5s | %-20s | %-15s | %-30s |%n", "ID", "Tên", "Ngày sinh", "Địa chỉ");
        System.out.println("---------------------------------------------------------------");
        for (Customer customer : customers) {
            if (customer != null) {
                System.out.printf("| %-5s | %-20s | %-15s | %-30s |%n",
                        customer.getId(),
                        customer.getName(),
                        customer.getDateOfBirth(),
                        customer.getAddress());
            }
        }
        System.out.println("---------------------------------------------------------------\n");
    }

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter customer date of birth : ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();

        Customer newCustomer = new Customer(id, name, dateOfBirth, address);

        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = newCustomer;
                System.out.println("Customer added successfully!");
                return;
            }
        }

        System.out.println("Cannot add more customers. The list is full!");
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Customer customerToUpdate = findCustomerById(id);

        if (customerToUpdate != null) {
            System.out.print("Enter new name : ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                customerToUpdate.setName(newName);
            }

            System.out.print("Enter new date of birth : ");
            String newDateOfBirth = scanner.nextLine();
            if (!newDateOfBirth.isEmpty()) {
                customerToUpdate.setDateOfBirth(newDateOfBirth);
            }

            System.out.print("Enter new address : ");
            String newAddress = scanner.nextLine();
            if (!newAddress.isEmpty()) {
                customerToUpdate.setAddress(newAddress);
            }

            System.out.println("Customer updated successfully!");
        } else {
            System.out.println("Customer not found!");
        }
    }

    @Override
    public void delete(String customerId) {
        int id = Integer.parseInt(customerId);
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null && customers[i].getId() == id) {
                System.out.println("Customer deleted: " + customers[i]);
                customers[i] = null;

                for (int j = i; j < customers.length - 1; j++) {
                    customers[j] = customers[j + 1];
                }
                customers[customers.length - 1] = null;
                return;
            }
        }
        System.out.println("Customer not found!");
    }

    public Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer != null && customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}