package Launcher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import CsvReader.CsvReader;
import CsvWriter.CsvWriter;
import JsonParse.JsonReader;
import MetaData.AnonymisationMapper;
import MetaData.Column;
import MetaData.LineMetaData;
import MetaData.RuleMapper;


public class DocumentRuleCheck {
	public static int blockSize = 2;
	public static String separatorIn = ";";
	public static String separatorOut = ";";
	public static void DoCheck(String in, String out,String descFilePath,String checkFilePath) throws Exception {
		CsvReader csvReader =  new CsvReader(in,separatorIn);
		CsvWriter csvWriter = new CsvWriter(out,separatorOut);	
		JsonReader js = new JsonReader();
		//End init readers

		LineMetaData lineRef=(js.initRuleMetaData(js.initMetaData(descFilePath),checkFilePath));

		while(csvReader.containsData==true){
			ArrayList<String[]> tempLine = csvReader.readMultipleLine(blockSize);
			List<String[]> beforWrite = (tempLine.stream().filter((e)->{
				return RuleMapper.verificationMatchWithRule(lineRef,e);
			})).collect(Collectors.toList());
			csvWriter.writeFileFromList(beforWrite);
		}


	}
	public static void DoAnonymisation(String in, String out,String descFilePath,String checkFilePath) throws Exception {
		CsvReader csvReader =  new CsvReader(in,separatorIn);
		CsvWriter csvWriter = new CsvWriter(out,separatorOut);	
		JsonReader js = new JsonReader();
		//End init readers

		LineMetaData lineRef=(js.initAnonymisationMetaData(js.initMetaData(descFilePath),checkFilePath));

		while(csvReader.containsData==true){
			ArrayList<String[]> tempLine = csvReader.readMultipleLine(blockSize);
			for(int i=0;i<tempLine.size();i++) {
				tempLine.set(i, AnonymisationMapper.lineAnonymisation(lineRef,tempLine.get(i)));
			}
			csvWriter.writeFileFromList(tempLine);
		}

	}

}