package encoding;

public class BaseSecret {
	private String secret;
	private static final String binaryString = "01";
	private static final String decimalString = "0123456789";
	
public void setSecret(String secret) {
		if (isValid(secret)) {
			this.secret = secret;
		} else {
			throw new IllegalArgumentException("wrong key");
		}
		
		
	}

private boolean isValid(String secret) {
	if (secret == null) {
		return false;
	}
	int base = secret.length();
	for (int i = 0; i < base; i++) {
		if (secret.lastIndexOf(secret.charAt(i)) != i) {
			return false;
		}
	}
	return true;
}

public static String toBinaryString(int num) {
	BaseSecret bs = new BaseSecret();
	bs.setSecret(binaryString);
	return bs.toSecretString(num);
}
public static String toDecimalString(int num) {
	BaseSecret bs = new BaseSecret();
	bs.setSecret(decimalString);
	return bs.toSecretString(num);
}
private int parseSecretString(String str) {
	int res = 0;
	int base = secret.length();
	for(char ch: str.toCharArray()) {
		int digit = secret.indexOf(ch);
		if (digit < 0) {
			return -1;
		}
		res = res * base + digit;
	}
	return res;
}
public static int parseIntBinary(String binaryStr) {
	BaseSecret bs = new BaseSecret();
	bs.setSecret(binaryString);
	return bs.parseSecretString(binaryStr);
}
public static int parseIntDecimal(String decString) {
	BaseSecret bs = new BaseSecret();
	bs.setSecret(decimalString);
	return bs.parseSecretString(decString);
}
public String toSecretString(int num) {
//<<<<<<< HEAD
	String secretStr = Integer.toString(num, secret.length());
	StringBuilder strBuilder = new StringBuilder();
	for (int i = 0; i < secretStr.length(); i++) {
		strBuilder.append(secret.charAt(Integer.parseInt(String.valueOf(secretStr.charAt(i)))));
	}
	return strBuilder.toString();
}
public boolean matches(String code, String decString) {
	return code.equals(toSecretString(Integer.parseInt(decString)));
//=======
//	StringBuilder builder = new StringBuilder();
//	if (secret == null) {
//		throw new IllegalArgumentException("Wrong key");
//	}
//	int base = secret.length();
//	do {
//		int rem = num % base;
//		builder.insert(0, secret.charAt(rem));
//		num /= base;
//	} while(num != 0);
//	return builder.toString();
//}
//public boolean matches(String code, String decString) {
//	int codeNum = parseSecretString(code);
//	return Integer.toString(codeNum).equals(decString);

}


}
