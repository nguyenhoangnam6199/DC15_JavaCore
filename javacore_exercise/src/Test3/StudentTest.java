package Test3;

import Exercise_3.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFirstName() {
        String expResuilt = "abs";
        Student student = new Student();
        assertEquals(expResuilt, student.getFirstName());
    }

    @Test
    public void setFirstName() {
        String name = "abc";
        Student student = new Student();
        student.setFirstName(name);
        String expResult = "abc";
        assertEquals(expResult, student.getFirstName());
    }

    @Test
    public void getLastName() {
        String expResuilt = "abs";
        Student student = new Student();
        assertEquals(expResuilt, student.getLastName());
    }

    @Test
    public void setLastName() {
        String name = "abc";
        Student student = new Student();
        student.setLastName(name);
        String expResult = "abc";
        assertEquals(expResult, student.getLastName());
    }

    @Test
    public void getGrade() {
        int expResult = 1;
        Student student = new Student();
        assertEquals(java.util.Optional.of(expResult),student.getGrade());
    }

    @Test
    public void setGrade() {
        int grade = 1;
        Student student = new Student();
        student.setGrade(grade);
        int expResult = 1;
        assertEquals(java.util.Optional.of(expResult), student.getGrade());
    }
}