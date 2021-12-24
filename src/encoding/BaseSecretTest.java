package encoding;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseSecretTest {
	BaseSecret bs = new BaseSecret();
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testToBinaryString() {
		assertEquals("100", BaseSecret.toBinaryString(4));
	}

	@Test
	void testToDecimalString() {
		assertEquals("1234", BaseSecret.toDecimalString(1234));
	}

	@Test
	void testParseIntBinary() {
		assertEquals(4, BaseSecret.parseIntBinary("100"));
	}

	@Test
	void testParseIntDecimal() {
		assertEquals(1234, BaseSecret.parseIntDecimal("1234"));
	}

	@Test
	void testToSecretString() {
		bs.setSecret(".-"); 
		assertEquals("-..", bs.toSecretString(4));
		
	}
	@Test
	void testSetSecretException() {
		boolean flException = false;
		try {
			bs.setSecret("abcdefrtg56$3wea");
		} catch (IllegalArgumentException e) {
			flException = true;
		}
		assertTrue(flException);
	}

	@Test
	void testMatches() {
		bs.setSecret("()");
		assertTrue(bs.matches(")((", "4"));
	}

}
