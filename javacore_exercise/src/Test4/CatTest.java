package Test4;

import Excercise_4.Cat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        String expResult = "abc";
        Cat cat = new Cat();
        assertEquals(expResult, cat.getName());
    }

    @Test
    public void setName() {
        String name = "abs";
        Cat cat = new Cat();
        cat.setName(name);
        String expResult = "abs";
        assertEquals(expResult,cat.getName());
    }

    @Test
    public void getAge() {
        int expResult  = 1;
        Cat cat = new Cat();
        assertEquals(expResult,cat.getAge());
    }

    @Test
    public void setAge() {
        int age = 1;
        Cat cat = new Cat();
        cat.setAge(age);
        int expResult = 1;
        assertEquals(expResult,cat.getAge());
    }
}