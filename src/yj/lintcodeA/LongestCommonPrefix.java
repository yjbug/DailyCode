package yj.lintcodeA;

public class LongestCommonPrefix {
	/**
	 * @param strs:
	 *            A list of strings
	 * @return: The longest common prefix
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs == null) {
			return null;
		} else if (strs.length == 0) {
			return "";
		}

		StringBuilder res = new StringBuilder();
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			minLen = minLen < strs[i].length() ? minLen : strs[i].length();
		}
		int i = 0;
		while (i < minLen) {
			char cur = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].charAt(i) != cur) {
					return res.toString();
				}
			}
			res.append(cur);
			i++;
		}
		return res.toString();
	}
}
