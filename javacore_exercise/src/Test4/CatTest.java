package Test4;

import Excercise_4.Cat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatTest {
    private Cat cat;
    @Before
    public void setUp() throws Exception {
        cat = new Cat();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        String expResult = "abc";
        assertEquals(expResult, cat.getName());
    }

    @Test
    public void setName() {
        String name = "abs";
        cat.setName(name);
        String expResult = "abs";
        assertEquals(expResult,cat.getName());
    }

    @Test
    public void getAge() {
        int expResult  = 1;
        assertEquals(expResult,cat.getAge());
    }

    @Test
    public void setAge() {
        int age = 1;
        cat.setAge(age);
        int expResult = 1;
        assertEquals(expResult,cat.getAge());
    }
}