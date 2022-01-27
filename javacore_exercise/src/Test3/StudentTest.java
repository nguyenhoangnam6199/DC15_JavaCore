package Test3;

import Exercise_3.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private Student student;
    @Before
    public void setUp() throws Exception {
        student = new Student();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFirstName() {
        String expResuilt = "abs";
        assertEquals(expResuilt, student.getFirstName());
    }

    @Test
    public void setFirstName() {
        student.setFirstName("abc");
        assertEquals("abc", student.getFirstName());
    }

    @Test
    public void getLastName() {
        String expResult = "abs";
        assertEquals(expResult, student.getLastName());
    }

    @Test
    public void setLastName() {
        student.setLastName("Abc");
        assertEquals("Abc", student.getLastName());
    }

    @Test
    public void getGrade() {
        int expResult = 1;
        assertEquals(java.util.Optional.of(expResult),student.getGrade());
    }

    @Test
    public void setGrade() {
        student.setGrade(1);
        assertEquals(java.util.Optional.of(1), student.getGrade());
    }
}