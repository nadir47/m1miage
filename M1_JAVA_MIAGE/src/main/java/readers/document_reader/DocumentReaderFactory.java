package readers.document_reader;

import Launcher.MainPg;

/**
 * Famous Gang Of Four Factory Method
 * We separate the creation of DocumentReader objects from its initialisation.
 * So we can manage many kind type of files.
 * A factory that create DocumentReader object
 * @version 1.0 --> Only works for CSV.
 */

public  class  DocumentReaderFactory {
	
	
	/** Return a DocumentReader object dedicated to read from files by giving a type and a path.
	 * From now on our app only read CSV
	 * But we might have need to readJSON later.
	 *@param String giving the type of reader needed
	 *@param String giving the path where to read the document.
	 *@return a writer object
	 */
	public static DocumentReader getDocumentReader(String type,String path) throws Exception {
		if (type==null){
			return null;
		}
		switch(type) {
		case "CSV":
			return new CsvReader(path,MainPg.InSeparator);
		default :
			return null;
		}
	
}
}
