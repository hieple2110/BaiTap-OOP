package Dao;

import Entity.Student;

import java.io.IOException;
import java.util.*;

import static java.util.Collections.*;

public class ManageStudent implements BaseDao<Student> {

    public static final String LINE = "============================";
    public static HashMap<Integer, Student> listStudent = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);
    public static double mark, point1, point2, point3, point4, avg;

    public static void menu() {
        System.out.println(LINE);
        System.out.println("Chọn phím chức năng theo Menu..!!");
        System.out.println("Chọn 1: Thêm học viên.");
        System.out.println("Chọn 2: Nhập/Sửa điểm học viên.");
        System.out.println("Chọn 3: Sửa thông tin học viên.");
        System.out.println("Chọn 4: Xóa thông tin học viên.");
        System.out.println("Chọn 5: Xem thông tin học viên.");
        System.out.println("Chọn 6: Xem danh sách học viên.");
        System.out.println("Chọn 7: Xếp loại học viên.");
        System.out.println("Chọn 0: Thoát khỏi ứng dụng.");
        System.out.println(LINE);
    }

    @Override
    public void viewListStudent() throws IOException {
        listStudent = FileBinary.readStudent();
        TableShow.tableShow(listStudent);
        menu();
    }

    @Override
    public void viewStudent() throws IOException {
        listStudent = FileBinary.readStudent();
        System.out.println("Nhập ID học viên muốn xem thông tin.");
        int idStudent = Integer.parseInt(scanner.next());
        if (listStudent.containsKey(idStudent)) {
            System.out.println(LINE);
            System.out.println(listStudent.get(idStudent));
            menu();
        } else {
            System.out.println(LINE);
            System.out.println("Không tìm thấy thông tin học viên cần xem.");
            menu();
        }
    }

    @Override
    public void addStudent() throws IOException {
        listStudent = FileBinary.readStudent();
        System.out.println("Bạn đang tiến hành thêm mới học viên");
        System.out.print("Nhâp Id của học viên: ");
        int id = Integer.parseInt(scanner.next());
        scanner.nextLine();
        if (listStudent.containsKey(id)) {
            System.out.println("Id học viên đã tồn tại.");
            menu();
        } else {
            String nameStudent = Validate.regexNameStudent();
            String addresStudent = Validate.regexAddresStudent();
            String phoneStudent = Validate.regexPhoneStudent();
            String birthdayStudent = Validate.regexDateStudent();
            String emailStudent = Validate.regexEmailStudent();
            Student student = new Student(id, nameStudent, addresStudent, phoneStudent, birthdayStudent, emailStudent);
            listStudent.put(student.getIdStudent(), student);
            TableShow.lengthColum(student);
            FileBinary.writerStudent(listStudent);
            System.out.println("Học viên " + nameStudent + " đã đăng ký thành công..!");
            menu();
        }
    }

    @Override
    public void updateStudent() throws IOException {
        listStudent = FileBinary.readStudent();
        System.out.println("Hãy nhập Id học viên muốn thay đổi thông tin.");
        int idStudent = scanner.nextInt();
        scanner.nextLine();
        if (listStudent.containsKey(idStudent)) {
            menuUpdateInformation();
            boolean check = true;
            while (check) {
                int choice = Integer.parseInt(scanner.next());
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập lại tên muốn sửa..");
                        listStudent.get(idStudent).setNameStudent(scanner.nextLine());
                        System.out.println("Bạn đã sửa tên học viên thành: " + listStudent.get(idStudent).getNameStudent());
                        menuUpdateInformation();
                        break;
                    case 2:
                        System.out.println("Nhập lại địa chỉ muốn sửa..");
                        listStudent.get(idStudent).setAddressStudent(scanner.nextLine());
                        System.out.println("Bạn đã sửa địa chỉ học viên thành: " + listStudent.get(idStudent).getAddressStudent());
                        menuUpdateInformation();
                        break;
                    case 3:
                        System.out.println("Nhập lại số điên thoại muốn sửa..");
                        listStudent.get(idStudent).setPhoneStudent(scanner.nextLine());
                        System.out.println("Bạn đã sửa số điện thoại học viên thành: " + listStudent.get(idStudent).getPhoneStudent());
                        menuUpdateInformation();
                        break;
                    case 4:
                        System.out.println("Nhập lại ngày sinh muốn sửa..");
                        listStudent.get(idStudent).setBirthdayStudent(scanner.nextLine());
                        System.out.println("Bạn đã sửa ngày sinh học viên thành: " + listStudent.get(idStudent).getBirthdayStudent());
                        menuUpdateInformation();
                        break;
                    case 5:
                        System.out.println("Nhập lại email muốn sửa..");
                        listStudent.get(idStudent).setEmailStudent(scanner.nextLine());
                        System.out.println("Bạn đã sửa email học viên thành: " + listStudent.get(idStudent).getEmailStudent());
                        menuUpdateInformation();
                        break;
                    case 0:
                        System.out.println("Bạn đã chỉnh sửa xong.");
                        check = false;
                        menu();
                        break;
                }
            }
            FileBinary.writerStudent(listStudent);
        } else {
            System.out.println("không tìm thấy học viên cần chỉnh sửa thông tin.");
            menu();
        }
    }

    @Override
    public void deleteStudent() throws IOException {
        listStudent = FileBinary.readStudent();
        System.out.println("Nhập Id học viên muốn XÓA thông tin.");
        int idStudent = scanner.nextInt();
        scanner.nextLine();
        if (listStudent.containsKey(idStudent)) {
            menuDelete();
            int choice = Integer.parseInt(scanner.next());
            switch (choice) {
                case 1:
                    listStudent.remove(idStudent);
                    System.out.println("Thông tin học viên đã được XÓA.");
                    FileBinary.writerStudent(listStudent);
                    menu();
                    break;
                case 2:
                    System.out.println("Thông tin học viên không được XÓA.");
                    menu();
                    break;
                case 3:
                    menu();
                    break;
            }
        } else {
            System.out.println("Không tìm thấy học viên cần XÓA.");
            System.out.println("Vui lòng nhập đúng mã học viên.");
        }
    }

    @Override
    public void addMarkStudent() throws IOException {
        listStudent = FileBinary.readStudent();
        System.out.println("Nhập Id học viên bạn muốn nhập/sửa điểm..");
        int idStudent = scanner.nextInt();
        scanner.nextLine();
        if (listStudent.containsKey(idStudent)) {
            menuAddMark();
            boolean check = true;
            while (check) {
                int choice = Integer.parseInt(scanner.next());
                switch (choice) {
                    case 1:
                        checkMark();
                        point1 = mark;
                        listStudent.get(idStudent).setPointStudent1(point1);
                        System.out.println("Điểm hệ số 1: " + point1);
                        menuAddMark();
                        break;
                    case 2:
                        checkMark();
                        point2 = mark;
                        listStudent.get(idStudent).setPointStudent2(point2);
                        System.out.println("Điểm hệ số 2: " + point2);
                        menuAddMark();
                        break;
                    case 3:
                        checkMark();
                        point3 = mark;
                        listStudent.get(idStudent).setPointStudent3(point3);
                        System.out.println("Điểm hệ số 3: " + point3);
                        menuAddMark();
                        break;
                    case 4:
                        checkMark();
                        point4 = mark;
                        listStudent.get(idStudent).setPointStudent4(point4);
                        System.out.println("Điểm hệ số 4: " + point4);
                        menuAddMark();
                        break;
                    case 5:
                        avg = (point1 + point2 + (point3 * 2) + (point4 * 3)) / 7;
                        double round = Math.ceil(avg * 10) / 10;
                        listStudent.get(idStudent).setAvgPoint(round);
                        System.out.println("Điểm trung bình của học viên " + listStudent.get(idStudent).getNameStudent() + ": " + round);
                        menuAddMark();
                        break;
                    case 0:
                        System.out.println("Bạn đã nhập/sửa điểm xong.");
                        check = false;
                        menu();
                        break;
                }
            }
            FileBinary.writerStudent(listStudent);
        } else {
            System.out.println("Không tìm thấy học viên. Vui lòng nhập đúng mã học viên.");
            menu();
        }
    }

    @Override
    public void sortStudent() throws IOException {
        listStudent = FileBinary.readStudent();
        var listEntry = listStudent.entrySet();
        List<Map.Entry<Integer, Student>> list = new ArrayList<Map.Entry<Integer, Student>>(listEntry);
        sort(list, new Comparator<Map.Entry<Integer, Student>>() {
            @Override
            public int compare(Map.Entry<Integer, Student> o1, Map.Entry<Integer, Student> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        HashMap<Integer, Student> mapShow = new HashMap<>();
        int count = 0;
        for (Map.Entry<Integer, Student> item : list) mapShow.put(count++, item.getValue());
        System.out.println("Danh sách xếp hạng Học Viên ");
        TableShow.tableShow(mapShow);
        menu();
    }

    public static void menuUpdateInformation() {
        System.out.println(LINE);
        System.out.println("Bạn đang tiến hành chỉnh sửa thông tin học viện.");
        System.out.println("Bấm 1: Sửa tên học viên");
        System.out.println("Bấm 2: sửa địa chỉ học viên");
        System.out.println("Bấm 3: Sửa số điện thoại học viên.");
        System.out.println("Bấm 4: Sửa ngày sinh học viên");
        System.out.println("Bấm 5: Sửa email học viên");
        System.out.println("Bấm 0: Quay lại.");
        System.out.println(LINE);
    }

    public static void menuDelete() {
        System.out.println(LINE);
        System.out.println("Bạn đang thực hiện XÓA thông tin học viên.");
        System.out.println("Bấm 1: Đồng ý XÓA");
        System.out.println("Bấm 2: Không đồng ý XÓA");
        System.out.println("Bấm 3: Quay lại menu.");
        System.out.println(LINE);
    }

    public static void menuAddMark() {
        System.out.println(LINE);
        System.out.println("Bạn đang tiến hành nhập điểm học viện.");
        System.out.println("Bấm 1: Nhập điểm hệ số 1.");
        System.out.println("Bấm 2: Nhập điểm hệ số 2.");
        System.out.println("Bấm 3: Nhập điểm hệ số 3.");
        System.out.println("Bấm 4: Nhập điểm hệ số 4.");
        System.out.println("Bấm 5: Xem điểm trung bình.");
        System.out.println("Bấm 0: Quay lại.");
        System.out.println(LINE);
    }

    public static Double checkMark() {
        System.out.print("Nhập/sửa điểm học viên: ");
        mark = 0.0;
        boolean check = false;
        while (!check) {
            try {
                mark = scanner.nextDouble();
                if (mark < 0 || mark > 10) {
                    throw new ArithmeticException();
                }
                check = true;
            } catch (Exception e) {
                System.out.println("Nhập diểm sai. Vui lòng nhâp lại");
                scanner.nextLine();
            }
        }
        return mark;
    }


}
