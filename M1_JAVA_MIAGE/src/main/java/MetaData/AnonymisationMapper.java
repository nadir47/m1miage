package MetaData;

import Rules.AllAnonymisations;

public class AnonymisationMapper {
	
	public static String doMap(String type,String toAnon) {
		if (type==null){
			return toAnon;
		}
		switch(type) {
		case "RANDOM_LETTER":
			return AllAnonymisations.anonymiseFull(toAnon);
		case "RANDOM_LETTER_FOR_LOCAL_PART":
			return AllAnonymisations.anonymiseForLocalPart(toAnon);
		default :
			return toAnon;
		}
	}
	public static String[] lineAnonymisation(LineMetaData lineRef,String[] line) {
		boolean temp=true;
		for(int i=0;i<line.length;i++)
		{	
		 	//System.out.println(lineRef.get(i).name);
			line[i]=doMap(lineRef.get(i).AnonymisationType,line[i]);
		}
		return line;
	}
}
