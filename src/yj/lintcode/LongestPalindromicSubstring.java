package yj.lintcode;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		// data 20170406
		// o(n) time o(n) space
		if (s == null || s.length() == 0) {
			return s;
		}
		// think of s is "abcba" and we assume that s not contains "#"
		int len = s.length();
		final StringBuilder sb = new StringBuilder();
		sb.append("#");
		for (int i = 0; i < len; i++) {
			sb.append(s.charAt(i)).append("#");
		}
		// now s is "#a#b#c#b#a#"
		int newLen = len * 2 + 1;
		final int rad[] = new int[newLen];
		int id = -1;
		int right = -1;

		//
		int maxRad = -1;
		int maxRadId = -1;
		for (int i = 0; i < newLen; i++) {
			int r = 1; // init
			if (i < right) {
				r = Math.min(rad[2 * id - i], right - i); // make sure rad[] not
															// exceed right-i
			}
			// try to increase r
			while (i - r >= 0 && i + r < newLen && sb.charAt(i - r) == sb.charAt(i + r)) {
				r++;
			}
			rad[i] = r;
			if (maxRad < r) {
				maxRad = r;
				maxRadId = i;
			}
			if (i + r > right) {
				right = i + r;
				id = i;
			}
		}
		final StringBuilder res = new StringBuilder();
		for (int i = maxRadId - maxRad + 1; i < maxRadId + maxRad; i++) {
			if (sb.charAt(i) != '#') {
				res.append(sb.charAt(i));
				i++; // next char must be '#'
			}
		}
		return res.toString();
	}
}