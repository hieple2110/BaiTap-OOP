import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Manage {
    public static final String LINE = "===========================";
    public static final String MENU = "Chọn chức năng theo Menu để thực hiện.";
    public static Scanner scanner = new Scanner(System.in);
    public static Manage manage = new Manage();
    public static ArrayList<Note> noteList = new ArrayList<>();
    public static int index;

    public static void menu() {
        System.out.println(LINE);
        System.out.println("Menu.");
        System.out.println("Bấm C: Tạo ghi chú mới.");
        System.out.println("Bấm U: Sửa ghi chú.");
        System.out.println("Bấm D: Xóa ghi chú.");
        System.out.println("Bấm F: Xem ghi chú.");
        System.out.println("Bấm L: Xem danh sách ghi chú.");
        System.out.println("Bấm X: Thoát chương trình.");
        System.out.println(MENU);
        System.out.println(LINE);
    }

    public static void creatNote() {
        System.out.println("Nhập Tiêu đề ghi chú.");
        String title = scanner.nextLine();
        System.out.println("Nhập Nội dung ghi chú.");
        String content = scanner.nextLine();
        System.out.println("Nhập số task cần làm");
        String taskList = " ";
        Date timeCreat = new Date();
        Date timeEdit = new Date();
        int task = Integer.parseInt(scanner.next());
        scanner.nextLine();
        if (task <= 5) {
            for (int i = 0; i < task; i++) {
                System.out.println("Nhập task " + (i + 1) + ": ");
                String numberTask = scanner.nextLine();
                taskList = taskList + numberTask + " / ";
            }
            Note note = new Note(title, content, taskList, timeCreat, timeEdit);
            noteList.add(note);
            System.out.println("Bạn đã tạo thành công Note: " + note.getTitle() + " thành công!");
            manage.menu();
        } else {
            System.out.println("Số task quá lớn..Hãy thử lại.!");
            manage.menu();
        }
    }

    public static void editNote() {
        System.out.println("Nhập tiêu đề ghi chú cần chỉnh sữa.");
        String title = scanner.nextLine();
        if (checkTitle(title)) {
            System.out.println("Nhập tiêu đề muốn sửa.");
            noteList.get(index).setTitle(scanner.nextLine());
            System.out.println("Nhập nội dung muốn sửa.");
            noteList.get(index).setContentl(scanner.nextLine());
            System.out.println("Nhập danh sách việc muốn sửa.");
            String taskList = " ";
            int task = Integer.parseInt(scanner.next());
            scanner.nextLine();
            if (task <= 5) {
                for (int i = 0; i < task; i++) {
                    System.out.println("Nhập task " + (i + 1) + ": ");
                    String numberTask = scanner.nextLine();
                    taskList = taskList + numberTask + " / ";
                }
            }
            noteList.get(index).setList(taskList);
            Date editTimeNote = new Date();
            noteList.get(index).setDateTimeEdit(editTimeNote);
            System.out.println("Bạn đã chỉnh sửa thành công..!");
            manage.menu();
        }
    }

    public static void deleteNote() {
        System.out.println("Nhập tiêu đề ghi chú cần xóa.");
        String title = scanner.nextLine();
        if (checkTitle(title)) {
            for (int i = 0; i < noteList.size(); i++) {
                if (title.equals(noteList.get(i).getTitle())) {
                    System.out.println("Hãy cân nhắc trước khi xóa.");
                    System.out.println("Chọn C: Đồng ý xóa.");
                    System.out.println("Chọn K: Không đồng ý xóa.");
                    System.out.println("Chọn B: Quay lại menu.");
                    String choice = scanner.nextLine();
                    switch (choice){
                        case "C":
                            noteList.remove(i);
                            System.out.println("Ghi chú đã xóa thành công..!");
                            manage.menu();
                            break;
                        case "K":
                            System.out.println("Bạn không đồng ý xóa Ghi Chú này..!");
                            manage.menu();
                            break;
                        case "B":
                            manage.menu();
                            break;
                        default:
                            System.out.println("Bạn đã chọn sại chức năng. Vui lòng chọn lại..!");
                    }
                }
            }

        } else {
            System.out.println("Không tìm thấy ghi chú muốn xóa...");
            manage.menu();
        }
    }

    public static void showNote() {
        System.out.println("Nhập tiêu đề ghi chú cần xem.");
        String title = scanner.nextLine();
        System.out.println(LINE);
        if (checkTitle(title)) {
            for (int i = 0; i < noteList.size(); i++) {
                if (title.equals(noteList.get(i).getTitle())) {
                    System.out.println(noteList.get(i).toString());
                }
            }
            manage.menu();
        } else {
            System.out.println("Không tìm thấy ghi chú muốn xóa...");
            manage.menu();
        }
    }

    public static void showListNote() {
        System.out.println("Danh sách ghi chú.");
        for (int i = 0; i < noteList.size(); i++) {
            System.out.println(LINE);
            System.out.println(noteList.get(i).toString());
            System.out.println(LINE);
        }
        manage.menu();
    }

    public static boolean checkTitle(String title) {
        for (Note note : noteList) {
            if (title.equals(note.getTitle())) {
                return true;
            }
        }
        return false;
    }
}

