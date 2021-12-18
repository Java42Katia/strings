package encoding;

public class BaseSecret {
	private String secret;
public void setSecret(String secret) {
	/* V.R. The input string may be invalid in following 2 cases:
	 *  1. The length of the string is less than 2
	 *  2. The symbols (in the string) aren't unique
	 *  In both of these cases the methods toSecretString() and  matches() cannot be used.
	 *  What to do?
	 *  
	 */
		this.secret = secret;
		
	}
public static String toBinaryString(int num) {
	StringBuilder builder = new StringBuilder();
	do {
		int rem = num % 2;
		builder.insert(0, rem);
		num = num / 2;
		
	}while(num != 0);
	return builder.toString();
}
public static String toDecimalString(int num) {
	StringBuilder builder = new StringBuilder();
	do {
		int rem = num % 10;
		builder.insert(0, rem);
		num = num / 10;
		
	}while(num != 0);
	return builder.toString();
}
public static int parseIntBinary(String binaryStr) {
	int res = 0;
	int length = binaryStr.length();
	for (int i = 0; i < length; i++) {
		res = res * 2 + (binaryStr.charAt(i) - '0');
	}
	return res;
}
public static int parseIntDecimal(String decString) {
	int res = 0;
	int length = decString.length();
	for (int i = 0; i < length; i++) {
		res = res * 10 + (decString.charAt(i) - '0');
	}
	return res;
}
public String toSecretString(int num) {
	/* V.R. This method cannot be called in the following cases:
	 * 1. The string secret is invalid
	 * 2. The method setSecret() wasn't called before and
	 * the string secret=null is still invalid
	 * What to do?
	 */
	String secretStr = Integer.toString(num, secret.length());
	StringBuilder strBuilder = new StringBuilder();
	for (int i = 0; i < secretStr.length(); i++) {
		strBuilder.append(secret.charAt(Integer.parseInt(String.valueOf(secretStr.charAt(i)))));
	}
	return strBuilder.toString();
}
public boolean matches(String code, String decString) {
	/* V.R. This method cannot be called in the following cases:
	 * 1. The string secret is invalid
	 * 2. The method setSecret() wasn't called before and
	 * the string secret=null is still invalid
	 * What to do?
	 */
	return code.equals(toSecretString(Integer.parseInt(decString)));
}


}
