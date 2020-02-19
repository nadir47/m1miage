package MetaData;
import java.util.ArrayList;


public class Column {
	public String name ;
	public String type;
	public ArrayList<String> Rules ;
	public String AnonymisationType;
	public boolean withCheck=false;
	//enumeration type of this column
	
	public Column() {
		
	}
	public boolean DoAllCHeck(String toCHeck) {
		boolean temp =true;
		if (!withCheck) {
			return true;
		}
		for(String rule : Rules) {
			temp=temp&&RuleMapper.doMap(rule,toCHeck);
		}
		return temp;
	}
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void setRule(String rule) {
		if (!withCheck) {
			this.Rules= new ArrayList<String>();
			this.withCheck=true;
		}
		this.Rules.add(rule);
	}
	public ArrayList<String> getRules() {
		return Rules;
	}
	public String getAnonymisationType() {
		return AnonymisationType;
	}
	public void setAnonymisationType(String anonymisationType) {
		AnonymisationType = anonymisationType;
	}
}