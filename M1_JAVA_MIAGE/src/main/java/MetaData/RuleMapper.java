package MetaData;

import Rules.AllRules;

public class RuleMapper {
	
	public static boolean doMap(String str,String toCHeck) {
		switch(str) {
		case "BE_AN_AGE":
			return AllRules.isAnAge(toCHeck);
		case "BE_AN_EMAIL":
			return AllRules.isValidEmail(toCHeck);
		case "BE_AN_DAUPHINE_EMAIL":
			return AllRules.isValidDauphineEmail(toCHeck);
		default :
			return true;
		}
	}
	public static boolean verificationMatchWithRule(LineMetaData lineRef,String[] line) {
		boolean temp=true;
		for(int i=0;i<line.length;i++)
		{
			temp=temp&&lineRef.get(i).DoAllCHeck(line[i]);
		}
		return temp;
	}
}