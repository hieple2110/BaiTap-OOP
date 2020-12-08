package Dao;

import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Pattern;

public class Validate {
    public static Scanner scanner = new Scanner(System.in);

    public static String regexNameStudent() {
        String name;
        String regex = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]{3,25}$";
        while (true) {
            System.out.print("Nhập Họ và Tên học viên: ");
            name = scanner.nextLine();
            Pattern patternName = Pattern.compile(regex);
            if (patternName.matcher(name).find()) {
                return name;
            } else {
                System.out.println("Tên học viên hoặc độ dài không chính xác! ");
            }
        }
    }

    public static String regexPhoneStudent() {
        String numberPhone;
        String regex = "^(08|09|07|03)\\d{8}$";
        while (true) {
            System.out.print("Nhập số điện thoại của học viên: ");
            numberPhone = scanner.nextLine();
            Pattern patternName = Pattern.compile(regex);
            if (patternName.matcher(numberPhone).find()) {
                return numberPhone;
            } else {
                System.out.println("Số điện thoại nhập chưa chính xác...");
            }
        }
    }

    public static String regexDateStudent(){
        String date;
        String regex = "^\\s*(3[01]|[12][0-9]|0?[1-9])\\.(1[012]|0?[1-9])\\.((?:199|200|)\\d{1,1})\\s*$";
        while (true) {
            System.out.print("Nhập ngày sinh học viên: ");
            date = scanner.nextLine();
            Pattern patternName = Pattern.compile(regex);
            if (patternName.matcher(date).find()) {
                return date;
            } else {
                System.out.println("Ngày sinh học viên không chính xác! ");
            }
        }
    }

    public static String regexEmailStudent() {
        String email;
        String regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        while (true) {
            System.out.print("Nhập email học viên: ");
            email = scanner.nextLine();
            Pattern patternName = Pattern.compile(regex);
            if (patternName.matcher(email).find()) {
                return email;
            } else {
                System.out.println("Email học viên không chính xác! ");
            }
        }
    }

    public static String regexAddresStudent() {
        String address;
        String regex = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]{20,70}$";
        while (true) {
            System.out.print("Nhập địa chỉ học viên: ");
            address = scanner.nextLine();
            Pattern patternName = Pattern.compile(regex);
            if (patternName.matcher(address).find()) {
                return address;
            } else {
                System.out.println("Độ dài không phù hợp với quy định. Vui lòng nhập lại. ");
            }
        }
    }

}
