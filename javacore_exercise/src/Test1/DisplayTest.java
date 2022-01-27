package Test1;

import Exercise_1.Display;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayTest {
    private Display display;
    @Before
    public void setUp() throws Exception {
        display = new Display();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSize() {
        int expResult = 1;
        int actResult = display.getSize();
        assertEquals(expResult,actResult);
    }

    @Test
    public void setSize() {
        display.setSize(1);
        assertEquals(1, display.getSize());
    }

    @Test
    public void getNumberofColors() {
        int expResult = 1;
        int actResult = display.getNumberofColors();
        assertEquals(expResult,actResult);
    }

    @Test
    public void setNumberofColors() {
        display.setNumberofColors(2);
        assertEquals(1,display.getNumberofColors());
    }
}