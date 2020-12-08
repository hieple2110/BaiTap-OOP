package UI;

import Dao.FileBinary;
import Dao.ManageStudent;
import Entity.Student;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Display {
    public static Scanner scanner = new Scanner(System.in);
    public static ManageStudent manageStudent = new ManageStudent();
    public static FileBinary fileBinary = new FileBinary();
    public static HashMap<Integer, Student> listStudent = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ManageStudent.menu();

        while (true) {
          int choice = Integer.parseInt(scanner.next());
            switch (choice) {
                case 1:
                    manageStudent.addStudent();
                    break;
                case 2:
                    manageStudent.addMarkStudent();
                    break;
                case 3:
                    manageStudent.updateStudent();
                    break;
                case 4:
                    manageStudent.deleteStudent();
                    break;
//                case 5:
//                    manageStudent.updateMarkStudent();
//                    break;
                case 5:
                    manageStudent.viewStudent();
                    break;
                case 6:
                    manageStudent.viewListStudent();
                    break;
                case 7:
                    manageStudent.sortStudent();
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử sụng dịch vụ");
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập đúng phím chức năng");
            }
        }
    }
}
