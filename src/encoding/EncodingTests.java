package encoding;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EncodingTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void integerToStringTest() {
		int num = 1234;
		assertEquals("1234", Integer.toString(num));
		num = 5;
		assertEquals("101", Integer.toString(num, 2));
		System.out.println(Integer.toString(1234, 36));
		assertEquals("10", Integer.toString(36,36));
		assertEquals("Java".toLowerCase(),Integer.toString(900550,36));
	}
	@Test
	void integerParseTest() {
		assertEquals(1234, Integer.parseInt("1234"));
		assertEquals(5, Integer.parseInt("101", 2));
		System.out.println(Integer.parseInt("Java", 36));
	}

}
