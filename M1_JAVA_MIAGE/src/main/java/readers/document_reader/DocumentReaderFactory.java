package readers.document_reader;

import Launcher.MainPg;

public  class  DocumentReaderFactory {
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
