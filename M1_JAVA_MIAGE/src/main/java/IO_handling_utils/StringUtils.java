package IO_handling_utils;

public class StringUtils {
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
