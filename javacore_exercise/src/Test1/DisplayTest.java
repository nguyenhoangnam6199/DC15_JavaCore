package Test1;

import Exercise_1.Display;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSize() {
        int expResult = 1;
        Display display = new Display();
        int actResult = display.getSize();
        assertEquals(expResult,actResult);
    }

    @Test
    public void setSize() {
        int size = 1;
        Display display = new Display();
        display.setSize(size);
        int expResult = 1;
        assertEquals(expResult, display.getSize());
    }

    @Test
    public void getNumberofColors() {
        int expResult = 1;
        Display display = new Display();
        int actResult = display.getNumberofColors();
        assertEquals(expResult,actResult);
    }

    @Test
    public void setNumberofColors() {
        int numberOfColor = 2;
        Display display =  new Display();
        display.setNumberofColors(numberOfColor);
        int expResult = 1;
        assertEquals(expResult,display.getNumberofColors());
    }
}