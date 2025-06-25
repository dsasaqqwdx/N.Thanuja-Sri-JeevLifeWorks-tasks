package util;

import model.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {

    public static void exportToCSV(List<Student> students, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("ID,Name,Email,Course\n");
            for (Student student : students) {
                writer.append(student.getId() + "," + student.getName() + "," + student.getEmail() + "," + student.getCourse() + "\n");
            }
            System.out.println("Data exported successfully to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
