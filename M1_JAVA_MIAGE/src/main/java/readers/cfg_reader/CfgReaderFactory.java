package readers.cfg_reader;

/**
 * Famous Gang Of Four Factory Method
 * We separate the creation of CfgReaders from its initialisation.
 * So we can offer many kind type of files.
 * A factory that create CfgReaders object
 * @version 1.0 --> Only works for JSON.
 */
public  class  CfgReaderFactory {
	/** Return an CfgReason object dedicated to read from files by giving a type and a path.
	 * From now on our app only read JSON configurations
	 * But we might have need to write in CSV or any flat files later.
	 *@param String giving the type of writer needed
	 *@param String giving the path where to create a document.
	 *@return a CfgReader object
	 */
	public static CfgReader getCfgReader(String type,String path) throws Exception {
		switch(type) {
		case "JSON":
			return new JsonReader(path);
		default :
			return null;
		}
	
}
}
