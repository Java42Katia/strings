package strings;

import static org.junit.jupiter.api.Assertions.*;

import java.util.IllegalFormatException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestsClassString {
	
	final static String str = "Hello, hello, World!";


	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCharAt() {
		assertEquals('e', str.charAt(1));
		assertEquals(' ', str.charAt(6));
		try {
			char t = str.charAt(-1);
			fail("There should be Exeption");
		} catch (StringIndexOutOfBoundsException e) {
			
		}
	}

	@Test
	void testEqualsIgnoreCase() {
		assertTrue("hello, hello, woRld!".equalsIgnoreCase(str));
	}

	@Test
	void testCompareToIgnoreCase() {
		assertTrue(0 > "helllo, WorlD!".compareToIgnoreCase(str));
		assertTrue(0 < "Hi, hello, World!".compareToIgnoreCase(str));
		assertTrue(0 == "hello, Hello, world!".compareToIgnoreCase(str));
	}

	@Test
	void testStartsWithStringInt() {
		assertTrue(str.startsWith("llo", 2));
		assertFalse(str.startsWith("llo", 0));
	}

	@Test
	void testStartsWithString() {
		assertTrue(str.startsWith("Hello"));
		assertFalse(str.startsWith("llo"));
	}

	@Test
	void testEndsWith() {
		assertTrue(str.endsWith("d!"));
		assertFalse(str.endsWith("world"));
	}

	@Test
	void testIndexOfInt() {
		assertEquals(5, str.indexOf(","));
		assertEquals(-1, str.indexOf("a"));
	}

	@Test
	void testIndexOfIntInt() {
		assertEquals(9, str.indexOf("l", 5));
		assertEquals(-1, str.indexOf("e", 9));
	}

	@Test
	void testLastIndexOfIntInt() {
		assertEquals(3, str.lastIndexOf("l", 5));
		assertEquals(-1, str.lastIndexOf("h", 5));
	}

	@Test
	void testIndexOfString() {
		assertEquals(3, str.indexOf("lo"));
		assertEquals(-1, str.indexOf("lol"));
	}

	@Test
	void testLastIndexOfString() {
		assertEquals(10, str.lastIndexOf("lo"));
		assertEquals(-1, str.lastIndexOf("lol"));
	}

	@Test
	void testSubstringInt() {
		assertEquals("hello, World!", str.substring(7));
		try {
			String t = str.substring(-5);
			fail("There should be IndexOutOfException");
		} catch (IndexOutOfBoundsException e) {
			
		}
		try {
			String t = str.substring(77);
			fail("There should be IndexOutOfException");
		} catch (IndexOutOfBoundsException e) {
			
		}
	}

	@Test
	void testSubstringIntInt() {
		assertEquals("hello", str.substring(7, 12));
		try {
			String t = str.substring(-5, 3);
			fail("There should be IndexOutOfException");
		} catch (IndexOutOfBoundsException e) {
		
		}
		try {
			String t = str.substring(3, 77);
			fail("There should be IndexOutOfException");
		} catch (IndexOutOfBoundsException e) {
			
		}	
	}

	@Test
	void testContains() {
		assertTrue(str.contains("hello"));
		assertFalse(str.contains("world!"));
	}

	@Test
	void testJoinCharSequenceCharSequenceArray() {
		assertEquals("hello:hello", String.join(":", "hello", "hello"));
		try {
			String t = String.join(null, "hello", null);
			fail("There should be NullPointerException");
		} catch (NullPointerException e) {
			
		}
	}

	@Test
	void testToLowerCase() {
		assertEquals("hello, hello, world!", str.toLowerCase());
		assertFalse("Hello, hello, World!".equals(str.toLowerCase()));
	}

	@Test
	void testTrim() {
		String actual1 = " Hello, World! ";
		String actual2 = "Hello, World!";
		String expected = "Hello, World!";
		assertEquals(expected, actual1.trim());
		assertEquals(expected, actual2.trim());
	}

	@Test
	void testToCharArray() {
		String actual = "Hello!";
		char[] expected = {'H', 'e', 'l', 'l', 'o', '!'};
		assertArrayEquals(expected, actual.toCharArray());
	}

	@Test
	void testFormatStringObjectArray() {
		assertEquals("I said: Hello, hello, World!", String.format("I said: %s", str));
		try {
			String t = String.format("I said: %d", str);
			fail("There should be IllegalFormatException");
		} catch (IllegalFormatException e) {
			
		}
	}

}
