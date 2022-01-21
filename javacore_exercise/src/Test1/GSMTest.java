package Test1;

import Exercise_1.Call;
import Exercise_1.GSM;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class GSMTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getModel() {
        String expResult = "abc";
        GSM gsm = new GSM();
        assertEquals(expResult,gsm.getModel());
    }

    @Test
    public void setModel() {
        String model = "abc";
        GSM gsm = new GSM();
        gsm.setModel(model);
        String expResult="abs";
        assertEquals(expResult, gsm.getModel());
    }

    @Test
    public void getPrice() {
        int expResult = 1;
        GSM gsm = new GSM();
        assertEquals(expResult,gsm.getPrice());
    }

    @Test
    public void setPrice() {
        int price = 1;
        GSM gsm = new GSM();
        gsm.setPrice(price);
        int expResult = 1;
        assertEquals(expResult,gsm.getPrice());
    }

    @Test
    public void addCall() {
        GSM gsm = new GSM();
        Call call1 = new Call(LocalDate.now(),"123",10);
        gsm.addCall(call1);
        int expSize = 1;
        int actSize = gsm.getCallHistory().size();
        assertEquals(expSize,actSize);
    }

    @Test
    public void deleteCall() {
        GSM gsm = new GSM();
        Call call1 = new Call(LocalDate.now(),"123",10);
        gsm.addCall(call1);
        gsm.deleteCall(call1);
        int expSize = 1;
        int actSize = gsm.getCallHistory().size();
        assertEquals(expSize,actSize);
    }

    @Test
    public void calculateTotalPrice() {
        GSM gsm = new GSM();
        gsm.addCall(new Call(LocalDate.now(),"19001023",3250));
        gsm.addCall(new Call(LocalDate.now(),"18891023",4650));
        gsm.addCall(new Call(LocalDate.now(),"17751533",9650));

        double k = 0.37;
        double expResult = 107.67;
        double actResult = gsm.calculateTotalPrice(k);

        assertEquals(expResult,actResult,0.0);

    }
}