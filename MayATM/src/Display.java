import java.util.Scanner;

public class Display {
    public static ATM atm = new ATM();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        atm.menu();
        while (true){
      String choice = scanner.nextLine();
            switch (choice){
                case "A":
                    atm.checkMonney();
                    break;
                case "D":
                    atm.recharge();
                    break;
                case "W":
                    atm.withdrawal();
                    break;
                case "H":
                    atm.transactionHistory();
                    break;
                case "X":
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ.");
                    System.exit(0);
                default:
                    System.out.println("Hãy lựa chọn theo chức năng cần dùng.");
            }
        }
    }
}
