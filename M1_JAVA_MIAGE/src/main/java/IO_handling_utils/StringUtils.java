package IO_handling_utils;

/**
 * 
 * Contains functions related to String manipulations
 * @version 1.0
 * @author Nadir Omega
 * @author ylgn
 *
 */
public class StringUtils {
	
	/**
	 * Return a data String delimited with a a given delimiter instead of a String tab.
	 * For each String within the tab, the method add the given delimiter between two objects.
	 * This is the best thing you need to create CSV with your personal delimiter. 
	 * @param  String[] giving the data
	 * @param  String giving the ruleName
	 * @return A string delimited by the string you asked for
	 */
	public static String arrayToStr(String[] data,String joinChar) {
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
