package test;


import org.junit.*;




import code.Business_logic.Euro;

import code.Database.BankDatabase;





public class TestBankDatabase {
    BankDatabase bankDatabase;
    @Before
    public void Init() {
        bankDatabase = new BankDatabase();
    }

    @Test
    public void testAuthenticateUser() {
        Assert.assertTrue(bankDatabase.authenticateUser(98765, 56789));
    }

    @Test
    public void testCredit() {
        bankDatabase.credit(98765, new Euro(158));
        Assert.assertEquals(40800, bankDatabase.getTotalBalance(98765).getValore());
    }

    @Test
    public void testDebit() {
        bankDatabase.debit(98765, new Euro(50.10));
        Assert.assertEquals(14990, bankDatabase.getAvailableBalance(98765).getValore());
    }

    @Test
    public void testGetAvailableBalance() {
        Assert.assertEquals(20000, bankDatabase.getAvailableBalance(98765).getValore());
    }

    @Test
    public void testGetTotalBalance() {
        Assert.assertEquals(25000, bankDatabase.getTotalBalance(98765).getValore());
    }
}
