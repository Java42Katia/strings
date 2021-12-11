package strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// V.R. OK
class TestsClassStringBuilder {
	StringBuilder strBuilder = new StringBuilder("StringBuilder");
	
	@BeforeEach
	void setUp() throws Exception {
		strBuilder = new StringBuilder("StringBuilder");
	}

	@Test
	void testAppendString() {
		assertEquals("StringBuilderClass", strBuilder.append("Class").toString());
	}

	@Test
	void testReplaceIntIntString() {
		assertEquals("StringClass", strBuilder.replace(6,  13, "Class").toString());
		try {
			StringBuilder t = strBuilder.replace(20, 25, "Class");
			fail("There should be StringIndexOutOfBoundsException");
		} catch (StringIndexOutOfBoundsException e) {
			
		}
		try {
			StringBuilder t = strBuilder.replace(6, 13, null);
			fail("There should be NullPointerException");
		} catch (NullPointerException e) {
			
		}
	}

	@Test
	void testInsertIntString() {
		assertEquals("String Builder", strBuilder.insert(6, " ").toString());
		try {
			StringBuilder t = strBuilder.insert(25, "Class");
			fail("There should be StringIndexOutOfBoundsException");
		} catch (StringIndexOutOfBoundsException e) {
			
		}
	}

	@Test
	void testReverse() {
		assertEquals("redliuBgnirtS", strBuilder.reverse().toString());
	}

}
