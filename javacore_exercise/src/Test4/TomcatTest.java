package Test4;

import Excercise_4.Frog;
import Excercise_4.Tomcat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TomcatTest {
    private Tomcat tomcat;
    @Before
    public void setUp() throws Exception {
        tomcat = new Tomcat();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        String expResult = "abc";
        assertEquals(expResult, tomcat.getName());
    }

    @Test
    public void setName() {
        String name = "abs";
        tomcat.setName(name);
        String expResult = "abs";
        assertEquals(expResult,tomcat.getName());
    }

    @Test
    public void getAge() {
        int expResult  = 1;
        assertEquals(expResult,tomcat.getAge());
    }

    @Test
    public void setAge() {
        int age = 1;
        tomcat.setAge(age);
        int expResult = 1;
        assertEquals(expResult,tomcat.getAge());
    }
}