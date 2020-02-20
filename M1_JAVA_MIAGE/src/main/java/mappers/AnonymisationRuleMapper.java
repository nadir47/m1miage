package mappers;

import anonymisation.AllAnonymisationRules;
import meta_data.LineMetaData;

public class AnonymisationRuleMapper {
	
	public static String doMap(String type,String toAnon) {
		if (type==null){
			return toAnon;
		}
		switch(type) {
		case "RANDOM_LETTER":
			return AllAnonymisationRules.anonymiseFull(toAnon);
		case "RANDOM_LETTER_FOR_LOCAL_PART":
			return AllAnonymisationRules.anonymiseForLocalPart(toAnon);
		default :
			return toAnon;
		}
	}
	public static String[] lineAnonymisation(LineMetaData lineRef,String[] line) {
		for(int i=0;i<line.length;i++)
		{	
			line[i]=doMap(lineRef.get(i).AnonymisationType,line[i]);
		}
		return line;
	}
}
