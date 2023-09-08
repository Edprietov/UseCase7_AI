package converter;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.Student;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentConverterTest {

    private StudentConverter studentConverter;

    @BeforeEach
    public void setUp() {
        studentConverter = new StudentConverter();
    }

    @Test
    public void highAchieverStudentTest() {
        Student student = new Student();
        student.setName("John");
        student.setAge(22);
        student.setGrade(95);

        List<Student> convertedStudents = studentConverter.convertStudents(List.of(student));
        assertFalse(convertedStudents.get(0).isExceptional());
        assertTrue(convertedStudents.get(0).isHonorRoll());
        assertFalse(convertedStudents.get(0).isPassed());
    }

    @Test
    public void exceptionalYoungHighAchieverStudentTest() {
        Student student = new Student();
        student.setName("John");
        student.setAge(20);
        student.setGrade(95);

        List<Student> convertedStudents = studentConverter.convertStudents(List.of(student));
        assertTrue(convertedStudents.get(0).isExceptional());
        assertFalse(convertedStudents.get(0).isHonorRoll());
        assertFalse(convertedStudents.get(0).isPassed());
    }

    @Test
    public void passedStudentTest() {
        Student student = new Student();
        student.setName("Mike");
        student.setAge(18);
        student.setGrade(80);

        List<Student> convertedStudents = studentConverter.convertStudents(Arrays.asList(student));
        assertFalse(convertedStudents.get(0).isExceptional());
        assertFalse(convertedStudents.get(0).isHonorRoll());
        assertTrue(convertedStudents.get(0).isPassed());
    }

    @Test
    public void studentFailedTest() {
        Student student = new Student();
        student.setName("Lucy");
        student.setAge(19);
        student.setGrade(65);

        List<Student> convertedStudents = studentConverter.convertStudents(Arrays.asList(student));
        assertFalse(convertedStudents.get(0).isExceptional());
        assertFalse(convertedStudents.get(0).isHonorRoll());
        assertFalse(convertedStudents.get(0).isPassed());
    }

    @Test
    public void emptyListInputTest() {
        List<Student> convertedStudents = studentConverter.convertStudents(List.of());
        assertTrue(convertedStudents.isEmpty());
    }

    @Test
    public void testNullInputThrowsError() {
        assertThrows(NullPointerException.class, () -> {
            studentConverter.convertStudents(null);
        });
    }
}
