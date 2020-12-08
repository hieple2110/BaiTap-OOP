package Dao;

import Entity.Student;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class FileBinary {
    public static final String fileName = "DSSV.txt";

    public static void writerStudent(HashMap<Integer, Student> listStudent) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter("DSSV.txt");
            Iterator var2 = listStudent.values().iterator();

            while(var2.hasNext()) {
                Student student = (Student)var2.next();
                fileWriter.append(student.toString());
            }

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<Integer,Student> readStudent() throws IOException {
        File file = new File(fileName);
        HashMap<Integer, Student> list = new HashMap<>();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] slip = line.split(",");
                Student student = new Student();
                student.setIdStudent(Integer.parseInt(slip[0]));
                student.setNameStudent(slip[1]);
                student.setAddressStudent(slip[2]);
                student.setPhoneStudent(slip[3]);
                student.setBirthdayStudent(slip[4]);
                student.setEmailStudent(slip[5]);
                student.setPointStudent1(Double.parseDouble(slip[6]));
                student.setPointStudent2(Double.parseDouble(slip[7]));
                student.setPointStudent3(Double.parseDouble(slip[8]));
                student.setPointStudent4(Double.parseDouble(slip[9]));
                student.setAvgPoint(Double.parseDouble(slip[10]));
                list.put(student.getIdStudent(), student);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
