package Test4;

import Excercise_4.Kitten;
import Excercise_4.Tomcat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KittenTest {
    private Kitten kitten;
    @Before
    public void setUp() throws Exception {
        kitten = new Kitten();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        String expResult = null;
        assertEquals(expResult, kitten.getName());
    }

    @Test
    public void setName() {
        String name = "abs";
        kitten.setName(name);
        String expResult = "abs";
        assertEquals(expResult,kitten.getName());
    }

    @Test
    public void getAge() {
        int expResult  = 1;
        assertEquals(expResult,kitten.getAge());
    }

    @Test
    public void setAge() {
        int age = 1;
        kitten.setAge(age);
        int expResult = 1;
        assertEquals(expResult,kitten.getAge());
    }
}