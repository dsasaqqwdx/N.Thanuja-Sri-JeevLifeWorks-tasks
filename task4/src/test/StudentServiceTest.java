package test;

import static org.junit.Assert.*;

import model.Student;
import org.junit.Before;
import org.junit.Test;
import service.StudentService;
import service.StudentServiceImpl;

import java.util.Optional;

public class StudentServiceTest {

    private StudentService studentService;

    @Before
    public void setUp() {
        studentService = new StudentServiceImpl();
    }

    @Test
    public void testAddStudent() {
        Student student = new Student(101, "John Doe", "john@example.com", "Math");
        studentService.addStudent(student);

        Optional<Student> fetchedStudent = studentService.getStudentById(101);
        assertTrue(fetchedStudent.isPresent());
        assertEquals("John Doe", fetchedStudent.get().getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddStudentWithEmptyName() {
        Student student = new Student(102, "", "empty@example.com", "Physics");
        studentService.addStudent(student);
    }

    @Test(expected = Exception.class)
    public void testDeleteNonExistentStudent() {
        studentService.deleteStudent(9999);
    }
}
