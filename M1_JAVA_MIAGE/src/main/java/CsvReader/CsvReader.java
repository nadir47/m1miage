package CsvReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 *
 * Class responsable de la lecture des fichiers CSV
 *
 */
public class CsvReader {
	//CHANGE EXCEPTION TYPE
	BufferedReader csvReader;
	int iter=1;
	String path;
	String separator;
	public boolean containsData=true;
	public CsvReader(String pathToCsv,String Separator) throws Exception {
		this.path=pathToCsv;
		this.separator = Separator;
		
	}

	public ArrayList<String[]> readAllFile() throws IOException {
		csvReader = new BufferedReader(new FileReader(this.path));
		ArrayList<String[]> allData = new ArrayList<String[]>();;
		String row;
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			allData.add(data);
		}
		csvReader.close();
		return allData;

	}
	public ArrayList<String[]> readMultipleLine(int nb) throws IOException {
		csvReader = new BufferedReader(new FileReader(this.path));
		ArrayList<String[]> allData = new ArrayList<String[]>();
		System.out.println("Write chunk nb :"+ this.iter);

		String row;
		int cpt=1;
		while ((row = csvReader.readLine())!= null && cpt<=iter*nb) {
			if (cpt>((iter-1)*nb)){
				String[] data = row.split(this.separator);
				allData.add(data);
			}
			cpt++;
		}
		if (row == null) {
			this.containsData=false;
		}
		iter ++;
		csvReader.close();
		return allData;
	}
}

