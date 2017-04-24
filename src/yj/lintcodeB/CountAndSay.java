package yj.lintcodeB;

public class CountAndSay {
	public String countAndSay(int n) {
		int step = 1;
		StringBuilder s = new StringBuilder("1");
		while (step < n) {
			StringBuilder res = new StringBuilder();
			char pre = 'a';
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == pre) {
					count++;
				} else {
					if (count != 0) {
						res.append(count);
						res.append(pre);
					}
					pre = s.charAt(i);
					count = 1;
				}
			}
			res.append(count);
			res.append(pre);
			step++;
			s = res;
		}
		return s.toString();
	}
}
