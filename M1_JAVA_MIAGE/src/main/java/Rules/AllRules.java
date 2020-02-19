package Rules;

public class AllRules {

	public static boolean checkIfNumber(String str) {

		try {
			Double.parseDouble(str.trim());
		}
		catch(NumberFormatException e)
		{	
			return false;
		}
		return true;

	}
	
	public static boolean checkIfNotNumber(String str) {
		try {
			Double.parseDouble(str.trim());
		}
		catch(NumberFormatException e)
		{	
			return true;
		}
		return false;
	}
	
	public static boolean isValidEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	public static boolean isValidDauphineEmail(String email) {
		String tempString = email.toLowerCase();
		String check = "^[a-zA-Z0-9_.+-]+@(dauphine\\.eu|dauphine\\.psl\\.eu|lamsade\\.dauphine\\.fr)$";
		return (tempString.matches(check));
	}

	public static boolean isAnAge(String age) {
		int i = Integer.parseInt(age.trim());
		return (i>0 && i <120);
	}
}
