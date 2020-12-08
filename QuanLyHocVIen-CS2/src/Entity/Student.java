package Entity;

public class Student implements Comparable<Student> {

    private int idStudent;
    private String nameStudent;
    private String addressStudent;
    private String phoneStudent;
    private String birthdayStudent;
    private String emailStudent;
    private double pointStudent1 = 0;
    private double pointStudent2 = 0;
    private double pointStudent3 = 0;
    private double pointStudent4 = 0;
    private double avgPoint = 0;

    public Student() {
    }

    public Student(int idStudent, String nameStudent, String addressStudent, String phoneStudent, String birthdayStudent, String emailStudent) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.addressStudent = addressStudent;
        this.phoneStudent = phoneStudent;
        this.birthdayStudent = birthdayStudent;
        this.emailStudent = emailStudent;
    }


    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getAddressStudent() {
        return addressStudent;
    }

    public void setAddressStudent(String addressStudent) {
        this.addressStudent = addressStudent;
    }

    public String getPhoneStudent() {
        return phoneStudent;
    }

    public void setPhoneStudent(String phoneStudent) {
        this.phoneStudent = phoneStudent;
    }

    public String getBirthdayStudent() {
        return birthdayStudent;
    }

    public void setBirthdayStudent(String birthdayStudent) {
        this.birthdayStudent = birthdayStudent;
    }

    public String getEmailStudent() {
        return emailStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }

    public double getPointStudent1() {
        return pointStudent1;
    }

    public void setPointStudent1(double pointStudent1) {
        this.pointStudent1 = pointStudent1;
    }

    public double getPointStudent2() {
        return pointStudent2;
    }

    public void setPointStudent2(double pointStudent2) {
        this.pointStudent2 = pointStudent2;
    }

    public double getPointStudent3() {
        return pointStudent3;
    }

    public void setPointStudent3(double pointStudent3) {
        this.pointStudent3 = pointStudent3;
    }

    public double getPointStudent4() {
        return pointStudent4;
    }

    public void setPointStudent4(double pointStudent4) {
        this.pointStudent4 = pointStudent4;
    }

    public double getAvgPoint() {

        return avgPoint;
    }

    public void setAvgPoint(double avgPoint) {
        this.avgPoint = avgPoint;
    }

    @Override
    public String toString() {
        return idStudent + "," + nameStudent + "," + addressStudent + "," + phoneStudent + "," + birthdayStudent +
                "," + emailStudent + "," + pointStudent1 + "," + pointStudent2 + "," + pointStudent3 + "," + pointStudent4 + "," + avgPoint + '\n';
    }


    @Override
    public int compareTo(Student o) {
        if (getAvgPoint() > o.getAvgPoint()) return -1;
        else if (getAvgPoint() < o.getAvgPoint()) return 1;
        else return 0;

    }

}
