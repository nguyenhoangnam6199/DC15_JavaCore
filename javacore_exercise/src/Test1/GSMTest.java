package Test1;

import Exercise_1.Call;
import Exercise_1.GSM;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class GSMTest {
    private GSM gsm;
    private Call call1;

    @Before
    public void setUp() throws Exception {
        gsm = new GSM();
        call1 = new Call(LocalDate.now(),"123",10);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getModel() {
        String expResult = "abc";
        assertEquals(expResult,gsm.getModel());
    }

    @Test
    public void setModel() {
       gsm.setModel("abc");
       assertEquals("abc", gsm.getModel());
    }

    @Test
    public void getPrice() {
        int expResult = 1;
        assertEquals(expResult,gsm.getPrice());
    }

    @Test
    public void setPrice() {
        gsm.setPrice(1);
        assertEquals(1,gsm.getPrice());
    }

    @Test
    public void addCall() {

        gsm.addCall(call1);
        int expSize = 1;
        int actSize = gsm.getCallHistory().size();
        assertEquals(expSize,actSize);
    }

    @Test
    public void deleteCall() {
        gsm.addCall(call1);
        gsm.deleteCall(call1);
        int expSize = 1;
        int actSize = gsm.getCallHistory().size();
        assertEquals(expSize,actSize);
    }

    @Test
    public void calculateTotalPrice() {
        gsm.addCall(new Call(LocalDate.now(),"19001023",3250));
        gsm.addCall(new Call(LocalDate.now(),"18891023",4650));
        gsm.addCall(new Call(LocalDate.now(),"17751533",9650));
        double k = 0.37;
        double expResult = 107.67;
        double actResult = gsm.calculateTotalPrice(k);

        assertEquals(expResult,actResult,0.0);

    }
}