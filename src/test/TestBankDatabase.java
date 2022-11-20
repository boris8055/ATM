package test;


import org.junit.*;




import code.Business_logic.Euro;

import code.Database.BankDatabase;





public class TestBankDatabase {
    BankDatabase bankDatabase;
    @Before
    public void setUp() {
        bankDatabase = new BankDatabase();
    }

    @Test
    public void testAuthenticateUser() {
        Assert.assertTrue(bankDatabase.authenticateUser(54013, 12345));
    }

    @Test
    public void testCredit() {
        bankDatabase.credit(12345, new Euro(108));
        Assert.assertEquals(130800, bankDatabase.getTotalBalance(12345).getValore());
    }
}
/*
public class TestBankDatabase {

     BankDatabase bankdatabase;
    private Account account;
    Euro testEuro1, testEuro2;

    @Before
    public void initTest() {
        testEuro1 = new Euro(10,20);
        testEuro2 = new Euro(9,99);
        bankdatabase = new BankDatabase();
        account = new Account(54013, 12345, 4000.0, 4500.0);
    }

    @After
    public void clear() {
        account = null;
        bankdatabase = null;
        assertNull(account);
        assertNull(bankdatabase);
    }

    @Test
    public void testInvalidAuthenticateUser() {
        assertFalse(bankdatabase.authenticateUser(54013, 12345));
    }
    

    @Test
    public void testDebit() {
        bankdatabase.debit(54013,testEuro1); //same thing as debit, except this time we subtract euro10 from the total balance
        assertEquals(testEuro1.getValore(), bankdatabase.getTotalBalance(54013).getValore());
    }
}
 */