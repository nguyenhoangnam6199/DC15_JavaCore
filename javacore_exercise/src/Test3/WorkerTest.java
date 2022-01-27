package Test3;

import Exercise_3.Worker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkerTest {
    private Worker worker;
    @Before
    public void setUp() throws Exception {
        worker = new Worker();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFirstName() {
        String expResult = "abc";
        assertEquals(expResult,worker.getFirstName());
    }

    @Test
    public void setFirstName() {
        worker.setFirstName("abc");
        assertEquals("abc",worker.getFirstName());
    }

    @Test
    public void getLastName() {
        String expResult = "abc";
        assertEquals(expResult,worker.getLastName());
    }

    @Test
    public void setLastName() {
        worker.setLastName("abc");
        assertEquals("abc",worker.getLastName());
    }

    @Test
    public void getWeekSalary() {
        double expResult = 1.2;
        assertEquals(expResult,worker.getWeekSalary(),0.0);
    }

    @Test
    public void setWeekSalary() {
        worker.setWeekSalary(5.6);
        assertEquals(5.6,worker.getWeekSalary(),0.0);
    }

    @Test
    public void getWorkHourPerDay() {
        float expResult =  1.8f;
        assertEquals(expResult,worker.getWorkHourPerDay(),0.0);

    }

    @Test
    public void setWorkHourPerDay() {
       worker.setWorkHourPerDay(1.3f);
        assertEquals(1.3f,worker.getWorkHourPerDay(),0.0);
    }

    @Test
    public void calculateMoneyPerHour() {
        double expResult = 0.045;
       assertEquals(expResult, worker.calculateMoneyPerHour(),0.0);

    }
}