package anonymisation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Launcher.MainPg;
import mappers.AnonymisationRuleMapper;
import mappers.DescTypeMapper;
import meta_data.LineMetaData;
import readers.cfg_reader.CfgReader;
import readers.cfg_reader.CfgReaderFactory;
import readers.document_reader.DocumentReader;
import readers.document_reader.DocumentReaderFactory;
import writers.Writer;
import writers.WriterFactory;

public class Anonymisation {
	String in,out,descFilePath,anonFilePath;
	String separatorIn=";";
	String separatorOut=";";
	
	public Anonymisation(String in, String out, String descFilePath, String anonFilePath) {
		this.in = in;
		this.out = out;
		this.descFilePath = descFilePath;
		this.anonFilePath = anonFilePath;
	}
	public void doAnonymisation() throws Exception {
		DocumentReader csvReader =  DocumentReaderFactory.getDocumentReader("CSV",this.in);
		Writer csvWriter = WriterFactory.getDocumentWriter("CSV", out);
		CfgReader descReader = CfgReaderFactory.getCfgReader("JSON",descFilePath);
		CfgReader anonRuleReader = CfgReaderFactory.getCfgReader("JSON",anonFilePath);


		LineMetaData lineInit=descReader.initMetaData();

		LineMetaData lineRef=anonRuleReader.initAnonymisationMetaData(lineInit);

		while(csvReader.checkContainingData()==true){
			ArrayList<String[]> tempLine = csvReader.readMultipleLine(MainPg.blockSize);

			List<String[]> beforWrite = tempLine.stream()
				.filter((e)->{
				return DescTypeMapper.verificationMatchWithDesc(lineRef,e);})
				.map((e)-> {
				return AnonymisationRuleMapper.lineAnonymisation(lineRef,e);})
				.collect(Collectors.toList());
			
			//beforWrite.stream().map((e)-> {
			//	return AnonymisationRuleMapper.lineAnonymisation(lineRef,e);
			//}).collect(Collectors.toList());
			
			/*old version */
			//for(int i=0;i<beforWrite.size();i++) {
			//	beforWrite.set(i, AnonymisationRuleMapper.lineAnonymisation(lineRef,beforWrite.get(i)));
			//}
			csvWriter.writeFileFromList(beforWrite);
		}

	}
}
