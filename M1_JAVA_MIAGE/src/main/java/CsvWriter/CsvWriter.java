package CsvWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
 * 
 * @author Nad Desktop
 *
 */
public class CsvWriter {
	/**
	 * 
	 */
	//CHANGE EXCEPTION TYPE
	BufferedReader csvReader;
	int iter=1;
	String path;
	String separator;
	public CsvWriter(String pathToCsv,String separator) throws Exception {
		path=pathToCsv;
		this.separator=separator;
	}


	public void writeFileFromList(List<String[]> beforWrite) throws IOException {
		FileWriter writer;
		if (iter==1) {
			writer = new FileWriter(this.path) ;
		}
		else {
			writer = new FileWriter(this.path,true) ;
		}

		BufferedWriter bw;
		bw = new BufferedWriter(writer);
		for(String[] line: beforWrite) {
			bw.write(arrayToStr(line,this.separator));
		}
		bw.close();
		writer.close();
		iter ++;

	}

	public String arrayToStr(String[] data,String joinChar) {
		StringBuilder str = new StringBuilder("");
		int size= data.length;
		for(int i=1;i<=size;i++) {
			str.append(data[i-1]);
			if (i!=size) {
				str.append(joinChar);
			}
		}
		str.append("\n");
		return str.toString();	
	}

}

