package writers;

import Launcher.MainPg;


/**
 * Famous Gang Of Four Factory Method
 * We separate the creation of Writer objects from its initialisation.
 * So we can offer many kind type of files.
 * A factory that create Writer object
 * @version 1.0 --> Only works for CSV.
 */
public class WriterFactory {
	
	/** Return an Writer object dedicated to write into files by giving a type and a path.
	 * From now on our app only write CSV
	 * But we might have need to write in JSON later.
	 *@param String giving the type of writer needed
	 *@param String giving the path where to create a document.
	 *@return a writer object
	 */
	public static Writer getDocumentWriter(String type,String path) throws Exception {
		if (type==null){
			return null;
		}
		switch(type) {
		//We should add an upper case onto type String value --> Could limit confusions.
		case "CSV":
			return new CsvWriter(path,MainPg.InSeparator);
		default :
			return null;
		}
	}
	
	

}
