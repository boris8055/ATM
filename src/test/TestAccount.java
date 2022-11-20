package test;

import static org.junit.Assert.*;
import org.junit.*;
import code.Business_logic.Euro;
import code.Database.Account;

public class TestAccount {

    private Account account;
    Euro euros;
    @Before
    public void init() {
        account = new Account(54013, 12345, new Euro(4000.0), new Euro(4500.0));
        
    }

    @After
    public void clear() {
        account = null;
        assertNull(account);
    }

    @Test
    public void testValidatePIN() {
        assertFalse("Pin sbagliato", account.validatePIN(125));
        assertTrue("Pin corretto", account.validatePIN(12345));
    }

    @Test
    public void testCredit() {
        account.credit(new Euro(100));
        assertEquals(460000, account.getTotalBalance().getValore());
    }

    @Test
    public void testDebit() {
        Euro euro = new Euro(200.0);
        account.debit(euro);
        long availableBalance = 3800 * 100;
        long totalBalance = 4300 * 100;
        assertEquals("addebito su availableBalance è fallito", account.getAvailableBalance().getValore(),
                availableBalance);
        assertEquals("addebito su totalBalance è fallito", account.getTotalBalance().getValore(), totalBalance);
    }

}
