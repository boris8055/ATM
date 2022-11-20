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
        account.debit(new Euro(500.0));

        assertEquals(350000,account.getAvailableBalance().getValore());
        assertEquals(400000,account.getTotalBalance().getValore());
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(54013, account.getAccountNumber());
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(400000, account.getAvailableBalance().getValore());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(450000, account.getTotalBalance().getValore());
    }


}
