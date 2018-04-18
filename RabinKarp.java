/**
 * 
 */
package algos;

/**
 * @author Gaurav
 *
 */
public class RabinKarp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "2359023141526739921";
		String pattern = "31415";
		int n = text.length();
		int m = pattern.length();
		int hash[] = new int[n - m + 1];
		
		// Horner's Rule
		hash[0] = getHash(text.substring(0, m));
		for (int i = 1; i < hash.length; i++) {
			hash[i] = (hash[i - 1] % (int) Math.pow(10, m - 1)) * 10
					+ text.charAt(m + i - 1) - '0';
		}

		// simplify using hash %13. Any prime can be taken
		for (int i = 0; i < hash.length; i++) {
			hash[i] %= 13;
		}
		int patternHash = getHash(pattern) % 13;
		
		//check for answer in collisions
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] == patternHash) {
				int temp = 0;
				while (temp < m
						&& pattern.charAt(temp) == text.charAt(temp + i)) {
					temp++;
				}
				if (temp == m) {
					System.out.println("Pattern found at position " + i);
				}
			}
		}
	}

	private static int getHash(String str) {
		if (str.length() == 1) {
			return str.charAt(0) - '0';
		}
		return str.charAt(str.length() - 1) - '0' + 10
				* getHash(str.substring(0, str.length() - 1));
	}

}
