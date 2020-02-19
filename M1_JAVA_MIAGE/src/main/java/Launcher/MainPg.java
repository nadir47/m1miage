package Launcher;

public class MainPg {
	public static void main(String[] args) throws Exception {
		//init env Variables
		String in="testCSv.csv";
		String out="testCSv2.csv";
		String descFilePath="desc.json";
		String checkFilePath="check.json";
		String anonFilePath="anon.json";
		
		//DocumentRuleCheck.DoCheck(in, out, descFilePath, checkFilePath);
		DocumentRuleCheck.DoAnonymisation(in, out, descFilePath, anonFilePath);
	}


}
