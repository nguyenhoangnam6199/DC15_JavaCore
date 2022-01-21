package Test4;

import Excercise_4.Frog;
import Excercise_4.Tomcat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TomcatTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        String expResult = "abc";
        Tomcat tomcat = new Tomcat();
        assertEquals(expResult, tomcat.getName());
    }

    @Test
    public void setName() {
        String name = "abs";
        Tomcat tomcat = new Tomcat();
        tomcat.setName(name);
        String expResult = "abs";
        assertEquals(expResult,tomcat.getName());
    }

    @Test
    public void getAge() {
        int expResult  = 1;
        Tomcat tomcat = new Tomcat();
        assertEquals(expResult,tomcat.getAge());
    }

    @Test
    public void setAge() {
        int age = 1;
        Tomcat tomcat = new Tomcat();
        tomcat.setAge(age);
        int expResult = 1;
        assertEquals(expResult,tomcat.getAge());
    }
}