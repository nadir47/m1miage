package verification;

/**
 * Class relative to Verification rules. Here is all method use to verify a
 * given string
 * 
 * @version 1.0
 * @author Nadir Omega
 * @author ylgn
 */
public class AllVerificationRules {

	/**
	 * Return true whether the string given is a number or false whether not. To
	 * manage it we parse an int thanks to Integer.parseInt(String str)
	 * 
	 * @param String giving the potential number.
	 * @return Boolean true if number
	 */
	public static boolean checkIfNumber(String str) {

		try {
			Integer.parseInt(str);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	/**
	 * Return true whether the string given is not a number or false whether not. To
	 * manage it we parse an Double thanks to Double.parseDouble(String str); We
	 * eliminates leading and trailing spaces with String.trim() onto our String;
	 * 
	 * @param String giving the potential number.
	 * @return Boolean true if not number
	 */
	public static boolean checkIfNotNumber(String str) {
		try {
			Double.parseDouble(str.trim());
		} catch (NumberFormatException e) {
			return true;
		}
		return false;
	}

	/**
	 * Return true whether the string given is a valid email or false whether not.
	 * To manage it we check it with regex.
	 * 
	 * @param String giving the email under check test.
	 * @return Boolean true if valid adress
	 */
	public static boolean isValidEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	/**
	 * Return true whether the string given is a valid dauphine email or false
	 * whether not. To manage it we check it with regex.
	 * 
	 * @param String giving the email under check dauphine test
	 * @return Boolean true if valid dauphine adress
	 */
	public static boolean isValidDauphineEmail(String email) {
		String tempString = email.toLowerCase();
		String check = "^[a-zA-Z0-9_.+-]+@(dauphine\\.eu|dauphine\\.psl\\.eu|lamsade\\.dauphine\\.fr)$";
		return (tempString.matches(check));
	}

	/**
	 * Return true whether the string given is a age or false whether not. To manage
	 * it we parse an int thanks to Integer.parseInt(String str) and then we check
	 * if the age is between 0 & 120 years
	 * 
	 * @param String giving the potential age.
	 * @return Boolean true if the string is an adress
	 */
	public static boolean isAnAge(String age) {
		int i = Integer.parseInt(age.trim());
		return (i > 0 && i < 120);
	}
}
