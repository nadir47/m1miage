package Rules;

import java.util.Random;

public class AllAnonymisations {
	
	private static final String alphabet = "abcdefghijklmnopqrstuvwxy";
	
	public static String anonymiseForLocalPart(String str) {
		String anonymisedString = "";
		Random r = new Random();
		for (int i = 0; i < str.length(); i++) {
			if (String.valueOf(str.charAt(i)).equals("@")) {
				while(i < str.length()) {
					anonymisedString += str.charAt(i);
					 i++;
				}
				break;
			}
			anonymisedString += alphabet.charAt(r.nextInt(alphabet.length()));
		}
		return anonymisedString;
	}
	
	/**
	  * @param Str, un string re présentant un nom
	  * @return un string dont chaque lettre est remplacée par une autre lettre aléatoire
	*/
	public static String anonymiseFull(String str) {
		String anonymisedString = "";
		Random r = new Random();
		for (int i = 0 ; i < str.length() ;i++) {
		    anonymisedString += alphabet.charAt(r.nextInt(alphabet.length()));
		}
		return anonymisedString;
	}
}
