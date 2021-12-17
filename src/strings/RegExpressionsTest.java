package strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static strings.RegExpressions.*
;

import java.util.Arrays;class RegExpressionsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void javaVariableTrue() {
		assertTrue("__".matches(javaVariable()));
		assertTrue("$".matches(javaVariable()));
		assertTrue("a2".matches(javaVariable()));
		assertTrue("_2".matches(javaVariable()));
		assertTrue("A".matches(javaVariable()));
		assertTrue("$$".matches(javaVariable()));
	}
	@Test
	void javaVariableFalse() {
		assertFalse("_".matches(javaVariable()));
		assertFalse("1_".matches(javaVariable()));
		assertFalse("&abc".matches(javaVariable()));
		assertFalse("#".matches(javaVariable()));
		
	}
	@Test
	void lessEqual300Truetest () {
		assertTrue("1".matches(lessEqual300()));
		assertTrue("99".matches(lessEqual300()));
		assertTrue("299".matches(lessEqual300()));
		assertTrue("100".matches(lessEqual300()));
		assertTrue("300".matches(lessEqual300()));
		
	}
	@Test
	void lessEqual300Falsetest () {
		assertFalse("0".matches(lessEqual300()));
		assertFalse("09".matches(lessEqual300()));
		assertFalse("301".matches(lessEqual300()));
		assertFalse("#".matches(lessEqual300()));
		assertFalse(" 40".matches(lessEqual300()));
	}
	@Test
	void ipV4TrueTest () {
		assertTrue("0".matches(ipV4Part()));
		assertTrue("001".matches(ipV4Part()));
		assertTrue("255".matches(ipV4Part()));
		assertTrue("020".matches(ipV4Part()));
		assertTrue("199".matches(ipV4Part()));
		assertTrue("10".matches(ipV4Part()));
		assertTrue("100".matches(ipV4Part()));
		assertTrue("99".matches(ipV4Part()));
		assertTrue("000".matches(ipV4Part()));
		assertTrue("200".matches(ipV4Part()));
	}
	@Test
	void ipV4TFalseTest () {
		assertFalse("0000".matches(ipV4Part()));
		assertFalse("-10".matches(ipV4Part()));
		assertFalse("#".matches(ipV4Part()));
		assertFalse("256".matches(ipV4Part()));
		assertFalse("300".matches(ipV4Part()));
		assertFalse("260".matches(ipV4Part()));
		assertFalse("1%".matches(ipV4Part()));
	}
	@Test
	void arithmeticExpressionTrueTest() {
		assertTrue("  20".matches(arithmeticExpression()));
		assertTrue("20 +10 * 2/100 +4".matches(arithmeticExpression()));
		assertTrue(" 20 +10 * 2/100 +4 ".matches(arithmeticExpression()));
	}
	@Test
	void arithmeticExpressionFalseTest() {
		assertFalse("  20+".matches(arithmeticExpression()));
		assertFalse("  20+a".matches(arithmeticExpression()));
		assertFalse("10  20".matches(arithmeticExpression()));
		assertFalse("  # * 10".matches(arithmeticExpression()));
		assertFalse("  20+&".matches(arithmeticExpression()));
		assertFalse(" +20".matches(arithmeticExpression()));
	}
	@Test
	void ipV4PartsTrueTest() {
		assertTrue("000.000.000.000".matches(ipV4()));
		assertTrue("1.2.3.4".matches(ipV4()));
		assertTrue("255.255.255.255".matches(ipV4()));
		assertTrue("190.20.03.004".matches(ipV4()));
		
	}
	@Test
	void ipV4PartsFalseTest() {
		
		assertFalse("000.000.000.000.".matches(ipV4()));
		assertFalse("000.000.".matches(ipV4()));
		assertFalse("...".matches(ipV4()));
		assertFalse(".100.200.".matches(ipV4()));
		assertFalse("255,255,255,255".matches(ipV4()));
	}
	@Test
	void mobileIsraelTrueTest() {
		//Israel code optional +972
		//code operator 050, 051, 052, 053, 054, 055,056,057,058, 059
		//code operator 072 - 077
		//7 digits that may or may not be separated by dash
		assertTrue("+972-541234567".matches(mobileIsraelPhone()));
		assertTrue("0541234567".matches(mobileIsraelPhone()));
		assertTrue("074-1-2345-67".matches(mobileIsraelPhone()));
		assertTrue("+972541234567".matches(mobileIsraelPhone()));
		assertTrue("+972  541234567".matches(mobileIsraelPhone()));
	}
	@Test
	void mobileIsraelFalseTest() {
		//Israel code optional +972
		//code operator 050, 051, 052, 053, 054, 055,056,057,058, 059
		//code operator 072 - 077
		//7 digits that may or may not be separated by dash
		
		assertFalse("+972-0541234567".matches(mobileIsraelPhone()));
		assertFalse("+972541234567-".matches(mobileIsraelPhone()));
		assertFalse("972-541234567".matches(mobileIsraelPhone()));
		assertFalse("0641234567".matches(mobileIsraelPhone()));
		assertFalse("+972-54123v567".matches(mobileIsraelPhone()));
	}
	@Test 
	void replaceAllTest() {
		String expr = " 20 +10 * 2	/100 +4     ";
		String actual = getStringWithoutSpaces(expr);
		String expected = "20+10*2/100+4";
		assertEquals(expected, actual);
		
	}

	private String getStringWithoutSpaces(String str) {
		return str.replaceAll("\\s+", "");
	}
	@Test
	void splitTest () {
		String expr = " 20 +10 * 2	/100 +4     ";
		String [] operatorsExp = {"", "+", "*", "/", "+"};
		// [Katia] - changed assertEquals() to assertArrayEquals()
//		assertEquals(operatorsExp, getOperatorsExpression(expr)); 
		assertArrayEquals(operatorsExp, getOperatorsExpression(expr));
		String [] operandsExp = {"20", "10", "2", "100", "4"};
		// [Katia] - changed assertEquals() to assertArrayEquals()
//		assertEquals(operandsExp, getOperandsExpression(expr));
		assertArrayEquals(operandsExp, getOperandsExpression(expr));
	}

	private String[] getOperandsExpression(String expr) { // [Katia] - changed Object to String[]
		return getStringWithoutSpaces(expr).split("[+*/-]");
	}

	private String[] getOperatorsExpression(String expr) {
		return getStringWithoutSpaces(expr).split("\\d{1,}");
	}

}
