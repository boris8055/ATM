package test;

import static org.junit.Assert.*;
import org.junit.*;

import code.Business_logic.Euro;
import code.Database.Account;
import code.Database.BankDatabase;

public class TestBankDatabase {

    private BankDatabase bankdatabase;
    private Account accounts[] = new Account[1];

    @Before
    public void init() {
        bankdatabase = new BankDatabase();
        accounts[0] = new Account(54013, 12345, new Euro(1500.0), new Euro(1900.0));
    }

    @After
    public void clear() {
        accounts = null;
        bankdatabase = null;
        assertNull(accounts);
        assertNull(bankdatabase);
    }

    @Test
    public void testInvalidAuthenticateUser() {
        assertFalse(bankdatabase.authenticateUser(54013, 12345));
    }

}