package mappers;

import meta_data.LineMetaData;
import verification.AllVerificationRules;

public class VerificationRuleMapper {
	
	public static boolean doMap(String str,String toCHeck) {
		switch(str) {
		case "BE_AN_AGE":
			return AllVerificationRules.isAnAge(toCHeck);
		case "BE_AN_EMAIL":
			return AllVerificationRules.isValidEmail(toCHeck);
		case "BE_AN_DAUPHINE_EMAIL":
			return AllVerificationRules.isValidDauphineEmail(toCHeck);
		default :
			return true;
		}
	}
	public static boolean verificationMatchWithRule(LineMetaData lineRef,String[] line) {
		boolean temp=true;
		for(int i=0;i<line.length;i++)
		{
			temp=temp&&lineRef.get(i).doAllCHeck(line[i]);
		}
		return temp;
	}
}