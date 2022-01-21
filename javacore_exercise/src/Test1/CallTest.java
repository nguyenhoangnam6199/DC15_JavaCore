package Test1;

import Exercise_1.Call;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CallTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void getPhoneNumber() {
        String expResult = null;
        Call call = new Call();
        String actResult = call.getPhoneNumber();
        assertEquals(expResult,actResult);
    }

    @Test
    public void setPhoneNumber() {
        String phoneNumber = "0010";
        Call call = new Call();
        call.setPhoneNumber(phoneNumber);
        String expResult  = "0012";
        assertEquals(expResult, call.getPhoneNumber());
    }

    @Test
    public void getDuration() {
        int expResult =  1;
        Call call = new Call();
        int actResult = call.getDuration();
        assertEquals(expResult,actResult);
    }

    @Test
    public void setDuration() {
        int duration = 1;
        Call call = new Call();
        call.setDuration(duration);
        int expResult = 1;
        assertEquals(expResult,call.getDuration());
    }
}