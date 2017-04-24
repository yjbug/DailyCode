package yj.lintcodeA;

public class ReverseWordsInAString {

	/**
	 * @param s: A string
	 * @return : A string
	 */
	public String reverseWords(String s) {
		// write your code
		s = reverse(s);
		StringBuilder sb = new StringBuilder();
		// easy for judge
		boolean start = false;
		int i = 0;
		int j = 0;
		while (i < s.length()) {
			// remember reset j
			j = 0;
			// index out of array
			while (i + j < s.length() && s.charAt(i + j) != ' ') {
				j++;
			}
			if (j == 0) {
				i++;
			} else {
				if (start) {
					sb.append(" ");
				} else {
					start = true;
				}
				sb.append(reverse(s.substring(i, i + j)));
				i = i + j + 1;
			}
		}
		return sb.toString();
	}

	public String reverse(String s) {
		char[] a = new char[s.length()];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.charAt(s.length() - 1 - i);
		}
		return new String(a);
	}
}
