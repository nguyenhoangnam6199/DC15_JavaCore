package Test4;

import Excercise_4.Cat;
import Excercise_4.Dog;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DogTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        String expResult = "abc";
        Dog dog = new Dog();
        assertEquals(expResult, dog.getName());
    }

    @Test
    public void setName() {
        String name = "abs";
        Dog dog = new Dog();
        dog.setName(name);
        String expResult = "abs";
        assertEquals(expResult,dog.getName());
    }

    @Test
    public void getAge() {
        int expResult  = 1;
        Dog dog = new Dog();
        assertEquals(expResult,dog.getAge());
    }

    @Test
    public void setAge() {
        int age = 1;
        Dog dog = new Dog();
        dog.setAge(age);
        int expResult = 1;
        assertEquals(expResult,dog.getAge());
    }
}