package Test4;

import Excercise_4.Dog;
import Excercise_4.Frog;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrogTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void getName() {
        String expResult = "abc";
        Frog frog = new Frog();
        assertEquals(expResult, frog.getName());
    }

    @Test
    public void setName() {
        String name = "abs";
        Frog frog = new Frog();
        frog.setName(name);
        String expResult = "abs";
        assertEquals(expResult,frog.getName());
    }

    @Test
    public void getAge() {
        int expResult  = 1;
        Frog frog = new Frog();
        assertEquals(expResult,frog.getAge());
    }

    @Test
    public void setAge() {
        int age = 1;
        Frog frog = new Frog();
        frog.setAge(age);
        int expResult = 1;
        assertEquals(expResult,frog.getAge());
    }
}