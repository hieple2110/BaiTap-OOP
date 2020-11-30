import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    public static final String LINE = "===================================";
    public static final String CHON_MENU = "Nhập lựa chọn của bạn để tiếp tục.";
    public static Scanner scanner = new Scanner(System.in);
    public static Account account = new Account("Nguyễn Văn An", 1, 1200000);
    public static ATM atm = new ATM();
    public static ArrayList<String> giaoDich = new ArrayList<>();
    public static int id = 1;

    public static void menu() {
        System.out.println(LINE);
        System.out.println("Ngân hàng ABC xin kính chào quý khách " + account.getNameAccount());
        System.out.println("Menu.");
        System.out.println("Nhấn phím A để kiểm tra tài khoản.");
        System.out.println("Nhấn phím D để nạp tiền.");
        System.out.println("Nhấn phím W để rút tiền.");
        System.out.println("Nhấn phím H để xem lịch sử giao dịch.");
        System.out.println("Nhấn phím X để thoát giao dịch.");
        System.out.println(LINE);
        System.out.println(CHON_MENU);
    }

    public static void checkMonney() {
        System.out.println("Số dư tài khoản của khách hàng là: " + account.getAmountMonney());
        atm.menu();
    }

    public static void recharge() {
        System.out.println("Giao dịch nạp tiền.");
        System.out.println("Nhập số tiền bạn muốn nạp.");
        double monney = scanner.nextDouble();
        scanner.nextLine();
        double total = account.getAmountMonney() + monney;
        account.setAmountMonney(total);
        giaoDich.add("Nạp tiền: "+ monney + " VND");
        System.out.println("Giao dịch thành công. Bạn vừa nạp " + monney + " vào tài khoản.");
        System.out.println("SỐ dư tài khoản của quý khách là: " + total + " VND");
        atm.menu();
    }

    public static void withdrawal() {
        System.out.println("Giao dịch rút tiền.");
        System.out.println("Nhập số tiền bạn muốn rút.");
        double monney = scanner.nextDouble();
        if (monney < account.getAmountMonney()) {
            double withdraw = account.getAmountMonney() - monney;
            account.setAmountMonney(withdraw);
            giaoDich.add("Rút tiền: "+ monney + " VND");
            System.out.println("Giao dịch thành công. Bạn vừa rút " + monney + " từ tài khoản.");
            System.out.println("SỐ dư tài khoản của quý khách là: " + withdraw + " VND");
            atm.menu();
        }else {
            System.out.println("giao dịch không thành công!");
            System.out.println("Số dư trong tài khoản của bạn là: " + account.getAmountMonney() + " không đủ để thực hiện giao dịch.");
            atm.menu();
        }
    }

    public static void transactionHistory(){
        System.out.println("Lịch sử giao dịch:");
        for (int i=giaoDich.size()-1; i>=0; i--){
            if (i == giaoDich.size()-4){
                break;
            }
            System.out.println(id++ +" " + giaoDich.get(i));
        }
        atm.menu();
    }
}