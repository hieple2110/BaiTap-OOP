import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
    public static final String LINE = "===========================";
    public static final String CHON_MENU = "Chọn Menu để thực hiện tiếp.";
    public static Manage manage = new Manage();
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Customer> listCustomer = new ArrayList<>();
    public static int count = 0;
    public static int id = 0;
    public void menu() {
        System.out.println(LINE);
        System.out.println("Chào mừng bạn đã đến với hệ thống Quản Lý Khách Hàng");
        System.out.println("Bấm 1 để Nhập khách hàng");
        System.out.println("Bấm 2 để Tìm kiếm khách hàng");
        System.out.println("Bấm 3 để In thông tin khách hàng");
        System.out.println("Bấm 4 để In toàn bộ danh sách khách hàng");
        System.out.println("Bấm 5 để Xóa thông tin khách hàng ");
        System.out.println("Bấm 6 để Tăng số đơn cho khách");
        System.out.println("Bấm 0 để Dừng dịch vụ");
        System.out.println(LINE);
    }

    public static void addCustomers() {
        System.out.println("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.println("Nhập địa chỉ khách hàng: ");
        String address = scanner.nextLine();
        System.out.println("Nhập số điện thoại khách hàng: ");
        String numberPhone = scanner.nextLine();
        System.out.println("Nhập email khách hàng: ");
        String email = scanner.nextLine();
        System.out.println("Nhập giới tính khách hàng: ");
        String gender = scanner.nextLine();
        Customer customer = new Customer(name, address, numberPhone, email, gender);
        System.out.println(LINE);
        if (checkCustomer(numberPhone, email)) {
            System.out.println("Khách hàng đã tồn tại.");
            manage.menu();
            System.out.println(CHON_MENU);
            System.out.println(LINE);
        } else {
            listCustomer.add(customer);
            count++;
            System.out.println("Bạn vừa mới thêm khách hàng: " + name + " thành công");
            manage.menu();
            System.out.println(CHON_MENU);
            System.out.println(LINE);
        }
    }

    public static void findingCustomers() {
        System.out.println("Nhập số điện thoại khách hàng cần tìm kiếm:");
        String numberPhone = scanner.nextLine();
        if (checkNumberPhone(numberPhone)) {
            System.out.println("Hệ thống đang tìm kiếm...");
            System.out.println("Kết quả:");
            for (int i = 0; i < listCustomer.size(); i++) {
                if (numberPhone.equals(listCustomer.get(i).getNumberPhone())) {
                    System.out.println(listCustomer.get(i).toString());
                }
            }
            manage.menu();
            System.out.println(CHON_MENU);
            System.out.println(LINE);
        } else {
            System.out.println("Không tồn tại khách hàng!");
            manage.menu();
            System.out.println(CHON_MENU);
            System.out.println(LINE);
        }

    }

    public static void printCustomerInformation() {
        System.out.println("Nhập số điện thoại khách hàng cần in thông tin:");
        String numberPhone = scanner.nextLine();
        if (checkNumberPhone(numberPhone)) {
            System.out.println("Thông tin: ");
            for (int i = 0; i < listCustomer.size(); i++) {
                if (numberPhone.equals(listCustomer.get(i).getNumberPhone())) {
                    System.out.println(listCustomer.get(i).toString());
                }
            }
            manage.menu();
            System.out.println(CHON_MENU);
            System.out.println(LINE);
        } else {
            System.out.println("Không tồn tại khách hàng!");
            manage.menu();
            System.out.println(CHON_MENU);
            System.out.println(LINE);
        }
    }

    public static void deleteCustomerInformation() {
        System.out.println("Nhập số điện thoại khách hàng cần xóa thông tin:");
        String numberPhone = scanner.nextLine();
        if (checkNumberPhone(numberPhone)) {
            for (int i = 0; i < listCustomer.size(); i++) {
                if (numberPhone.equals(listCustomer.get(i).getNumberPhone())) {
                    listCustomer.remove(i);
                    count--;
                }
            }
            System.out.println("Thông tin khách hàng đã được xóa.");
            manage.menu();
            System.out.println(CHON_MENU);
            System.out.println(LINE);
        } else {
            System.out.println("Không tồn tại khách hàng!");
            manage.menu();
            System.out.println(CHON_MENU);
            System.out.println(LINE);
        }
    }


    public static void printCustomerList() {
        id++;
        System.out.println("Thông tin khách hàng:");
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.println( id++ + " " +listCustomer.get(i).toString());
        }
        System.out.println("Tổng có " + count + " khách hàng trong hệ thống.");
        manage.menu();
        System.out.println(CHON_MENU);
        System.out.println(LINE);
    }

    public static void increaseOrder() {
        System.out.println("Nhập số điện thoại khách hàng cần tăng đơn hàng:");
        String numberPhone = scanner.nextLine();
        System.out.println("Nhập số đơn hàng đã mua:");
        int increase = scanner.nextInt();
        scanner.nextLine();
        if (checkNumberPhone(numberPhone)) {
            System.out.println("thông tin khách hàng sau khi tăng " + increase + " đơn hàng.");
            for (int i = 0; i < listCustomer.size(); i++) {
                if (numberPhone.equals(listCustomer.get(i).getNumberPhone())) {
                    listCustomer.get(i).setPurchasedOrder(listCustomer.get(i).getPurchasedOrder() + increase);
                    System.out.println( listCustomer.get(i).toString());
                }
            }
            manage.menu();
            System.out.println(CHON_MENU);
            System.out.println(LINE);
        } else {
            System.out.println("Không tồn tại khách hàng!");
            manage.menu();
            System.out.println(CHON_MENU);
            System.out.println(LINE);
        }
    }


    public static boolean checkNumberPhone(String numberPhone) {
        for (Customer customer : listCustomer) {
            if (numberPhone.equals(customer.getNumberPhone())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkCustomer(String numberPhone, String email) {
        for (Customer customer : listCustomer) {
            if (numberPhone.equals(customer.getNumberPhone()) || email.equals(customer.getEmail())) {
                return true;
            }
        }
        return false;
    }


}
