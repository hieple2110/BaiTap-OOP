import java.util.Scanner;

public class Display {
    public static Manage manage = new Manage();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        manage.menu();
        while (true) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "C":
                    manage.creatNote();
                    break;
                case "U":
                    manage.editNote();
                    break;
                case "D":
                    manage.deleteNote();
                    break;
                case "F":
                    manage.showNote();
                    break;
                case "L":
                    manage.showListNote();
                    break;
                case "X":
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ ghi chú.");
                    System.out.println("Xin chào và hẹn gặp lại.");
                    System.exit(0);
                default:
                    System.out.println("Hãy chọn đúng chức năng thực hiện");
            }
        }
    }
}
