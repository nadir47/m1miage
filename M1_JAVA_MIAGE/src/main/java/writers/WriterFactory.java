package writers;

import Launcher.MainPg;

public class WriterFactory {
	public static Writer getDocumentWriter(String type,String path) throws Exception {
		if (type==null){
			return null;
		}
		switch(type) {
		case "CSV":
			return new CsvWriter(path,MainPg.InSeparator);
		default :
			return null;
		}
	}

}