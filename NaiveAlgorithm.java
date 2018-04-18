package algos;

/**
 * 
 */

/**
 * @author Gaurav
 *
 */
public class NaiveAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String text = "000010001010001";
		String pattern = "0001";
		int n = text.length();
		int m = pattern.length();
		
		//find shift
		for (int s = 0; s < n - m; s++) {
			int i = 0;
			//compare till end is found
			while (i<m && pattern.charAt(i) == text.charAt(i + s)) {
				i++;
			}
			if (i == m) {
				System.out.println("Pattern found with shift " + s);
			}
		}

	}

}
