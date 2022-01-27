package Test1;

import Exercise_1.Battery;
import Exercise_1.BatteryType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BatteryTest {
    private  Battery battery;

    @Before
    public void setUp() throws Exception {
        battery = new Battery("ABC",45,47, BatteryType.LiIon);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getModel() {
        String expResult = "ABC";
        String actResult = battery.getModel();
        assertEquals(expResult,actResult);
    }

    @Test
    public void setModel() {
        battery.setModel("abc");
        assertEquals("abc",battery.getModel());
    }

    @Test
    public void getHoursIdle() {
        int expResult = 0;
        int actResult = battery.getHoursIdle();
        assertEquals(expResult,actResult);
    }

    @Test
    public void setHoursIdle() {
        battery.setHoursIdle(1);
        assertEquals(1,battery.getHoursIdle());
    }

    @Test
    public void getHoursTalk() {
        int expResult = 0;
        int actResult = battery.getHoursTalk();
        assertEquals(expResult,actResult);
    }

    @Test
    public void setHoursTalk() {
        battery.setHoursTalk(1);
        assertEquals(1,battery.getHoursTalk());
    }


}