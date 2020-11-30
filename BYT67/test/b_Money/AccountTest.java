package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;


	//all tests failed because there was an error in setUp method it was throwing null-pointer exception
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		//failed again because this line was throwing accountDoesNotExistException
		SweBank.deposit("Alice", new Money(1000000, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() {

		testAccount.addTimedPayment("test1",1,1,new Money(1000,SEK),SweBank,"Alice");
		assertTrue(testAccount.timedPaymentExists("test1"));

		testAccount.removeTimedPayment("test1");
		assertFalse(testAccount.timedPaymentExists("test1"));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());

		testAccount.addTimedPayment("test1", 2, 2, new Money(100, SEK), SweBank, "Alice");
		/*
		 * performing timed payment n times
		 * */
		for (int i = 0; i < 10; i++) {
			testAccount.tick();
		}
		assertEquals(Integer.valueOf(9999700), testAccount.getBalance().getAmount());

	}

	@Test
	public void testAddWithdraw() {

		testAccount.withdraw(new Money(100,SEK));
		assertEquals(Integer.valueOf(9999900), testAccount.getBalance().getAmount());
	}
	
	@Test
	public void testGetBalance() {
		assertEquals(Integer.valueOf(10000000), testAccount.getBalance().getAmount());
	}
}
