package strings;

public class RegExpressions {
public static String javaVariable() {
	//return "[A-Za-z$][A-Za-z$0-9_]*|_[A-Za-z$0-9_]+";
	return "[A-Za-z$][\\w$]*|_[\\w$]+";
}
public static String lessEqual300() {
	
	return "[1-9]\\d?|[12]\\d{2}|300";
}
/**
 * 
 * @return regex for any number 0-255 with optional leading zero's
 */
public static String ipV4Part() {
	
	return "\\d\\d?|[01]\\d{2}|2[0-4]\\d|25[0-5]";
}
/**
 * 
 * @return regex for arithmetic expressions without brackets 
 * operators - +, -, *, /
 * operands integer positive number with possible leading zero's 
 */
public static String arithmeticExpression() {
	String delimiter = "\\s*";
	String operand = "\\d+";
	String operator = "[+*/-]";
//	return delimiter + operand + "(" +delimiter + operator + delimiter + operand + ")" + "*" + delimiter;
//	return "\\s*\\d+(\\s*[+*/-]\\s*\\d+)*\\s*";
	return String.format("%1$s%2$s(%1$s%3$s%1$s%2$s)*%1$s", delimiter,operand, operator);
}
/**
 * 
 * @return regex for mobile Israel phone
 * Israel code optional +972 (if the code specified, operator code should be with no 0)
 * operator code: 050-059 , 072-077
 * 7 digits that may or may not be separated by dash
 */
public static String mobileIsraelPhone() {
	String code = "((\\+972)|0)";
	String prefix = "(5[0-9]|7[2-7])";
	String delimiter = "(-?|\\s*)";
	String number = "(" + delimiter + "\\d)";
	return String.format("%1$s%2$s%3$s%4$s{7}", code, delimiter, prefix, number);
}
/**
 * 
 * @return regex for IpV4
 * contains four parts separated by dot
 * each part is the  regex of String ipV4Part()
 */
public static String ipV4() {
	 return ".*";
}


}
