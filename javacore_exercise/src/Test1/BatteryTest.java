package Test1;

import Exercise_1.Battery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BatteryTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getModel() {
        Battery battery = new Battery();
        String expResult = null;
        String actResult = battery.getModel();
        assertEquals(expResult,actResult);
    }

    @Test
    public void setModel() {
        String model = "abc";
        Battery battery = new Battery();
        battery.setModel(model);

        String expResult = "abc";
        String actResult = battery.getModel();
        assertEquals(expResult,actResult);
    }

    @Test
    public void getHoursIdle() {
        int expResult = 0;
        Battery battery = new Battery();
        int actResult = battery.getHoursIdle();
        assertEquals(expResult,actResult);
    }

    @Test
    public void setHoursIdle() {
        int hoursIdle = 1;
        Battery battery = new Battery();
        battery.setHoursIdle(hoursIdle);
        int expResult = 1;
        assertEquals(expResult,battery.getHoursIdle());
    }

    @Test
    public void getHoursTalk() {
        int expResult = 0;
        Battery battery = new Battery();
        int actResult = battery.getHoursTalk();
        assertEquals(expResult,actResult);
    }

    @Test
    public void setHoursTalk() {
        int hoursTalk = 1;
        Battery battery = new Battery();
        battery.setHoursTalk(hoursTalk);
        int expResult =  1;
        assertEquals(expResult,battery.getHoursTalk());
    }


}