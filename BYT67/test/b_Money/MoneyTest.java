package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	//checking whether amount of money assigned correctly
	@Test
	public void testGetAmount() {

		assertEquals(10000,SEK100.getAmount().intValue());
		assertEquals(1000,EUR10.getAmount().intValue());
		assertEquals(20000,SEK200.getAmount().intValue());
		assertEquals(2000,EUR20.getAmount().intValue());
		assertEquals(0,SEK0.getAmount().intValue());
		assertEquals(0,EUR0.getAmount().intValue());
		assertEquals(-10000,SEKn100.getAmount().intValue());
	}
	//checking whether currency assigned correctly
	@Test
	public void testGetCurrency() {

		assertEquals(SEK,SEK0.getCurrency());
		assertEquals(EUR,EUR0.getCurrency());
		assertEquals(EUR, EUR10.getCurrency());
		assertEquals(EUR,EUR20.getCurrency());
		assertEquals(SEK,SEK100.getCurrency());
		assertEquals(SEK,SEK200.getCurrency());
		assertEquals(SEK,SEKn100.getCurrency());

	}

	//checking if toString() correctly works
	@Test
	public void testToString() {

		assertEquals("100.0 SEK",SEK100.toString());
		assertEquals("10.0 EUR", EUR10.toString());
		assertEquals("200.0 SEK",SEK200.toString());
		assertEquals("20.0 EUR", EUR20.toString());
		assertEquals("0.0 SEK",SEK0.toString());
		assertEquals("0.0 EUR", EUR0.toString());
		assertEquals("-100.0 SEK",SEKn100.toString());

	}
	//checking amount of money in a given currency correctly converted to universal value
	@Test
	public void testGlobalValue() {
		assertEquals(Integer.valueOf(0),SEK0.universalValue());
		assertEquals(Integer.valueOf(150000),SEK100.universalValue());
		assertEquals(Integer.valueOf(300000),SEK200.universalValue());
		assertEquals(Integer.valueOf(-150000),SEKn100.universalValue());

		assertEquals(Integer.valueOf(0),EUR0.universalValue());
		assertEquals(Integer.valueOf(150000),EUR10.universalValue());
		assertEquals(Integer.valueOf(300000),EUR20.universalValue());

	}
	//checking the amount of money are equal in different currencies
	@Test
	public void testEqualsMoney() {
		assertTrue("they should be equal", SEK0.equals(EUR0));
		assertTrue("they should be equal", SEK200.equals(EUR20));
		assertTrue("they should be equal", SEK100.equals(EUR10));

		assertFalse(" should not equal", EUR10.equals(SEK200));
		assertFalse(" should not equal", EUR20.equals(SEK100));
		assertFalse(" should not equal", SEKn100.equals(EUR0));
	}
	//adding monies in different currencies and checking if they are correctly added
	@Test
	public void testAdd() {
		assertEquals(Integer.valueOf(0),SEK0.add(EUR0).getAmount());
		assertEquals(Integer.valueOf(20000),SEK100.add(EUR10).getAmount());
		assertEquals(Integer.valueOf(4000),EUR20.add(SEK200).getAmount());
		assertEquals(Integer.valueOf(1000),EUR10.add(SEK0).getAmount());
		assertEquals(Integer.valueOf(3000),EUR10.add(SEK200).getAmount());
	}
	//subtracting monies in different currencies and checking if they are correctly subtracted
	@Test
	public void testSub() {
		assertEquals(Integer.valueOf(0),SEK0.sub(EUR0).getAmount());
		assertEquals(Integer.valueOf(0),SEK100.sub(EUR10).getAmount());
		assertEquals(Integer.valueOf(0),EUR20.sub(SEK200).getAmount());
		assertEquals(Integer.valueOf(1000),EUR10.sub(SEK0).getAmount());
		assertEquals(Integer.valueOf(10000),SEK200.sub(EUR10).getAmount());
	}
	//checking if isZero() returns correct results
	@Test
	public void testIsZero() {
		assertTrue("its true" ,EUR0.isZero());
		assertTrue("its true" ,SEK0.isZero());
		assertFalse("not 0 " ,SEK100.isZero());
		assertFalse("not 0",EUR20.isZero());
	}
	//negating value of money and checking if negate() returns correct results
	@Test
	public void testNegate() {
		assertEquals(Integer.valueOf(-0),EUR0.negate().getAmount());
		assertEquals(Integer.valueOf(-1000),EUR10.negate().getAmount());
		assertEquals(Integer.valueOf(-2000),EUR20.negate().getAmount());

		assertEquals(Integer.valueOf(-0),SEK0.negate().getAmount());
		assertEquals(Integer.valueOf(-10000),SEK100.negate().getAmount());
		assertEquals(Integer.valueOf(-20000),SEK200.negate().getAmount());
		assertEquals(Integer.valueOf(10000),SEKn100.negate().getAmount());

	}

	@Test
	public void testCompareTo() {
		assertEquals("they should be equal", 0, SEK100.compareTo(EUR10));
		assertEquals("they should be equal", 0, SEK200.compareTo(EUR20));

		assertEquals("they should be more",-1, SEK100.compareTo(EUR20));
		assertEquals("they should be more",-1, EUR10.compareTo(SEK200));

		assertEquals("they should be more", 1,SEK200.compareTo(EUR10));
		assertEquals("they should be more", 1,SEK100.compareTo(EUR0));

	}
}
