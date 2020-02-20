package mappers;

import meta_data.LineMetaData;
import verification.AllVerificationRules;

public class DescTypeMapper {
	public static boolean doMap(String str,String toCHeck) {
		switch(str) {
		case "INT":;
			return AllVerificationRules.checkIfNumber(toCHeck);
		case "STRING":
			return AllVerificationRules.checkIfNotNumber(toCHeck);
		default :
			return true;
		}
	}
	public static boolean verificationMatchWithDesc(LineMetaData lineRef,String[] line) {
		boolean temp=true;
		for(int i=0;i<line.length;i++)
		{
			temp=temp&&lineRef.get(i).doDescCHeck(line[i]);
		}
		if (!temp) System.out.println(temp);
		return temp;
	}
}
