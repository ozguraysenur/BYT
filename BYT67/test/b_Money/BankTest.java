package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank",SweBank.getName());
		assertEquals("Nordea",Nordea.getName());
		assertEquals("DanskeBank",DanskeBank.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK,SweBank.getCurrency());
		assertEquals(SEK,Nordea.getCurrency());
		assertEquals(DKK,DanskeBank.getCurrency());

	}
	//opening an account with the same id didn't cause an exception
	@Test(expected=AccountExistsException.class)
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");

		Nordea.openAccount("Aysenur");
		//assertNotNull(Nordea.getBalance("Aysenur"));

	}
	//it was throwing AccountDoesNotExistException even we have such account
	@Test  //(expected=AccountDoesNotExistException.class)
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika",new Money(1000 , SEK));
		assertEquals(Integer.valueOf(1000),SweBank.getBalance("Ulrika"));

		Nordea.deposit("Bob",new Money(2000 , SEK));
		assertEquals(Integer.valueOf(2000),Nordea.getBalance("Bob"));

		DanskeBank.deposit("Gertrud",new Money(1500 , DKK));
		assertEquals(Integer.valueOf(1500),DanskeBank.getBalance("Gertrud"));

		SweBank.deposit("Bob",new Money(500 , SEK));
		assertEquals(Integer.valueOf(500),SweBank.getBalance("Bob"));
	}


	//there was an error in method withdraw in class Bank
	@Test
	public void testWithdraw() throws AccountDoesNotExistException {

		testDeposit();

		SweBank.withdraw("Ulrika",new Money(500 , SEK));
		assertEquals(Integer.valueOf(500),SweBank.getBalance("Ulrika"));

		Nordea.withdraw("Bob",new Money(100 , SEK));
		assertEquals(Integer.valueOf(1900),Nordea.getBalance("Bob"));

		DanskeBank.withdraw("Gertrud",new Money(5 , DKK));
		assertEquals(Integer.valueOf(1495),DanskeBank.getBalance("Gertrud"));
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika",new Money(1000 , SEK));

		assertEquals(Integer.valueOf(0),DanskeBank.getBalance("Gertrud"));
		assertEquals(Integer.valueOf(0),Nordea.getBalance("Bob"));
		assertEquals(Integer.valueOf(1000),SweBank.getBalance("Ulrika"));

	}

	//failed =>  error in transfer method
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		testDeposit();

		SweBank.transfer("Ulrika",Nordea,"Bob",new Money(100,SEK));
		assertEquals(Integer.valueOf(900),SweBank.getBalance("Ulrika"));
		assertEquals(Integer.valueOf(2100),Nordea.getBalance("Bob"));

		Nordea.transfer("Bob",DanskeBank,"Gertrud",new Money(100,SEK));
		assertEquals(Integer.valueOf(2000),Nordea.getBalance("Bob"));
		assertEquals(Integer.valueOf(1575),DanskeBank.getBalance("Gertrud"));

		SweBank.transfer("Ulrika","Bob",new Money(5,SEK));
		assertEquals(Integer.valueOf(505),SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(895),SweBank.getBalance("Ulrika"));
	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {


		SweBank.addTimedPayment("Bob", "test1", 5, 5, new Money(1000, SEK), DanskeBank, "Gertrud");
		for (int i = 0; i < 20; i++) {
			SweBank.tick();

		}
		assertEquals(Integer.valueOf(-3000), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(2250), DanskeBank.getBalance("Gertrud"));

		SweBank.removeTimedPayment("Bob","test1");
		SweBank.tick();
		assertEquals(Integer.valueOf(-3000), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(2250), DanskeBank.getBalance("Gertrud"));

	}
}
