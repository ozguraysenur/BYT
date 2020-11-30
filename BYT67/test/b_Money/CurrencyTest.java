package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		NOK = new Currency("NOK", 1.0);
	}


	//comparing currency names with the actual ones
	@Test
	public void testGetName() {

		assertEquals("SEK", SEK.getName());
		assertEquals("DKK", DKK.getName());
		assertEquals("EUR", EUR.getName());
		assertEquals("NOK", NOK.getName());

	}

	//comparing rates to the returned ones
	@Test
	public void testGetRate() {
		assertEquals(0.15,SEK.getRate(),0.001);
		assertEquals(0.20,DKK.getRate(),0.001);
		assertEquals(1.5,EUR.getRate(),0.001);
		assertEquals(1.0,NOK.getRate(),0.001);
	}

	//changing the rate and checking if it was assigned correctly
	@Test
	public void testSetRate() {
		SEK.setRate(0.17);
		DKK.setRate(0.19);
		EUR.setRate(1.53);
		NOK.setRate(0.99);

		assertEquals(0.17,SEK.getRate(),0.001);
		assertEquals(0.19,DKK.getRate(),0.001);
		assertEquals(1.53,EUR.getRate(),0.001);
		assertEquals(0.99,NOK.getRate(),0.001);

	}



	//converting amount of money in a given currency to universal value and checking correctness
	//The last two digits denote two decimals.
	@Test
	public void testGlobalValue() {
		assertEquals(Integer.valueOf(1500),SEK.universalValue(100));
		assertEquals(Integer.valueOf(100),DKK.universalValue(5));
		assertEquals(Integer.valueOf(300),EUR.universalValue(2));
		assertEquals(Integer.valueOf(500),NOK.universalValue(5));
	}

	//converting amount of money to another currency
	//and checking whether it is correctly converted
	@Test
	public void testValueInThisCurrency() {
		assertEquals(Integer.valueOf(133),SEK.valueInThisCurrency(100,DKK)); //1.00 DKK => 1.33 SEK
		assertEquals(Integer.valueOf(750),DKK.valueInThisCurrency(100,EUR)); //1.00 EUR => 7.50 DKK
		assertEquals(Integer.valueOf(66),EUR.valueInThisCurrency(100,NOK));  //1.00 NOK => 0.66 EUR
		assertEquals(Integer.valueOf(15),NOK.valueInThisCurrency(100,SEK));  //1.00 SEK => 0.15 NOK
	}

}
