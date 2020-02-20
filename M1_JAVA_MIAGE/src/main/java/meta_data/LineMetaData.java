package meta_data;

import java.util.ArrayList;

public class LineMetaData extends ArrayList<Column>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//a revoir !
	public Column getColByName (String colName){
		for(Column c : this) {
			if (c.getName().equals(colName))
				return c;
		}
		return null;
	}

}
