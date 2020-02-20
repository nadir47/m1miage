package verification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import Launcher.MainPg;
import mappers.DescTypeMapper;
import mappers.VerificationRuleMapper;
import meta_data.LineMetaData;
import readers.cfg_reader.CfgReader;
import readers.cfg_reader.CfgReaderFactory;
import readers.document_reader.DocumentReader;
import readers.document_reader.DocumentReaderFactory;
import writers.Writer;
import writers.WriterFactory;

public class Verification {

	String in,out,descFilePath,checkFilePath;
	String separatorIn=";";
	String separatorOut=";";


	public Verification(String in, String out, String descFilePath, String anonFilePath) {
		this.in = in;
		this.out = out;
		this.descFilePath = descFilePath;
		this.checkFilePath = anonFilePath;
	}
	public void doVerification() throws Exception {
		DocumentReader csvReader =  DocumentReaderFactory.getDocumentReader("CSV",in);
		Writer csvWriter= WriterFactory.getDocumentWriter("CSV", out);
		CfgReader descReader = CfgReaderFactory.getCfgReader("JSON",descFilePath);
		CfgReader checkRuleReader = CfgReaderFactory.getCfgReader("JSON",checkFilePath);
		LineMetaData lineInit=descReader.initMetaData();
		LineMetaData lineRef=(checkRuleReader.initRuleMetaData(lineInit));

		while(csvReader.checkContainingData()==true){
			ArrayList<String[]> tempLine = csvReader.readMultipleLine(MainPg.blockSize);
			List<String[]> beforWrite = (tempLine.stream()
					.filter((e)->{
						return DescTypeMapper.verificationMatchWithDesc(lineRef,e)&&VerificationRuleMapper.verificationMatchWithRule(lineRef,e);
					})).collect(Collectors.toList());
			csvWriter.writeFileFromList(beforWrite);
		}
	}
}
