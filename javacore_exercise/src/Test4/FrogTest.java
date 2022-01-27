package Test4;

import Excercise_4.Dog;
import Excercise_4.Frog;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrogTest {
    private Frog frog;
    @Before
    public void setUp() throws Exception {
        frog = new Frog();
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void getName() {
        String expResult = "abc";
        assertEquals(expResult, frog.getName());
    }

    @Test
    public void setName() {
        String name = "abs";
        frog.setName(name);
        String expResult = "abs";
        assertEquals(expResult,frog.getName());
    }

    @Test
    public void getAge() {
        int expResult  = 1;
        assertEquals(expResult,frog.getAge());
    }

    @Test
    public void setAge() {
        int age = 1;
        frog.setAge(age);
        int expResult = 1;
        assertEquals(expResult,frog.getAge());
    }
}