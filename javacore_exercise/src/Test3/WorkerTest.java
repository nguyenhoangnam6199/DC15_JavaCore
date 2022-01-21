package Test3;

import Exercise_3.Worker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFirstName() {
        String expResult = "abc";
        Worker worker = new Worker();
        assertEquals(expResult,worker.getFirstName());
    }

    @Test
    public void setFirstName() {
        String name = "abc";
        Worker worker = new Worker();
        worker.setFirstName(name);
        String expResult = "abc";
        assertEquals(expResult,worker.getFirstName());
    }

    @Test
    public void getLastName() {
        String expResult = "abc";
        Worker worker = new Worker();
        assertEquals(expResult,worker.getLastName());
    }

    @Test
    public void setLastName() {
        String name = "abc";
        Worker worker = new Worker();
        worker.setLastName(name);
        String expResult = "abc";
        assertEquals(expResult,worker.getLastName());
    }

    @Test
    public void getWeekSalary() {
        double expResult = 1.2;
        Worker worker = new Worker();
        assertEquals(expResult,worker.getWeekSalary(),0.0);
    }

    @Test
    public void setWeekSalary() {
        double salary = 1.2;
        Worker worker = new Worker();
        worker.setWeekSalary(salary);
        double expResult = 1.2;
        assertEquals(expResult,worker.getWeekSalary(),0.0);
    }

    @Test
    public void getWorkHourPerDay() {
        float expResult =  1.8f;
        Worker worker = new Worker();
        assertEquals(expResult,worker.getWorkHourPerDay(),0.0);

    }

    @Test
    public void setWorkHourPerDay() {
        float hour = 1.3f;
        Worker worker = new Worker();
        worker.setWorkHourPerDay(hour);
        float expResult =  1.3f;
        assertEquals(expResult,worker.getWorkHourPerDay(),0.0);
    }

    @Test
    public void calculateMoneyPerHour() {
        Worker worker = new Worker("Hoang","Nam",1.8,1.6f);
        double expResult = 0.045;
       assertEquals(expResult, worker.calculateMoneyPerHour(),0.0);

    }
}