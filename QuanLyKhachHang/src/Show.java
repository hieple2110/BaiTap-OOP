import java.util.Scanner;

public class Show {
    public static Manage manage = new Manage();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        manage.menu();
        while (true){
            int choice = Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    manage.addCustomers();
                    break;
                case 2:
                    manage.findingCustomers();
                    break;
                case  3:
                    manage.printCustomerInformation();
                    break;
                case 4:
                    manage.printCustomerList();
                    break;
                case 5:
                    manage.deleteCustomerInformation();
                    break;
                case 6:
                    manage.increaseOrder();
                    break;
                case 0:
                    System.out.println("Cám ơn đã sử dụng dịch vụ");
                    System.out.println("Xin chào và hẹn gặp lại.");
                    System.exit(0);
                default:
                    System.out.println("Bạn đã chọn sai chức năng. Vui lòng chọn lại");
            }
        }
    }
}
