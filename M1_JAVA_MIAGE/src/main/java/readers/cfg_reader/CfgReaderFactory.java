package readers.cfg_reader;


public  class  CfgReaderFactory {
	public static CfgReader getCfgReader(String type,String path) throws Exception {
		switch(type) {
		case "JSON":
			return new JsonReader(path);
		default :
			return null;
		}
	
}
}
