package Test1;

import Exercise_1.Call;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CallTest {
    private Call call;
    @Before
    public void setUp() throws Exception {
        call = new Call();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDialedPhoneNumber() {
        String expResult = null;
        String actResult = call.getDialedPhoneNumber();
        assertEquals(expResult,actResult);
    }

    @Test
    public void setDialedPhoneNumber() {
       call.setDialedPhoneNumber("123");
        assertEquals("123", call.getDialedPhoneNumber());
    }

    @Test
    public void getDuration() {
        int expResult =  1;
        int actResult = call.getDuration();
        assertEquals(expResult,actResult);
    }

    @Test
    public void setDuration() {
        call.setDuration(1);
        assertEquals(1,call.getDuration());
    }
}