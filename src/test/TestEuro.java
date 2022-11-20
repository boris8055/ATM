package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import code.Business_logic.Euro;

public class TestEuro {

    Euro testEuro1;
    Euro testEuro2;
    
    @Before
    public void initTest() {
        testEuro1 = new Euro(10,20);
        testEuro2 = new Euro(9,99);
    }

    @Test
    public void testGetValore() { 
        assertEquals(1020, testEuro1.getValore());
        assertEquals(999, testEuro2.getValore());
     }

    @Test
    public void testMinoreDi() { 
        assertTrue(testEuro2.minoreDi(testEuro1)); 
        assertFalse(testEuro1.minoreDi(testEuro2)); 
    }

    @Test
    public void testSomma() {
        testEuro1.somma(testEuro1);
        assertEquals(testEuro1.getValore(), 2040);
    }

    @Test
    public void testSottrai() {
        assertEquals(testEuro1.sottrai(testEuro1).getValore(), 0);
        assertNotEquals(testEuro1.sottrai(testEuro2).getValore(),0);
    }

    @Test
    public void testStampa() {
        assertEquals(testEuro1.stampa(), "10.2 euro");
        assertNotEquals(testEuro1.stampa(), "102 euro");
    }

    @Test
    public void testUgualeA() {
        assertFalse(testEuro1.equals(testEuro2)); 
    }
}