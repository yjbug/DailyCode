package yj.lintcode;

public class StringToIntegerII {
	public int atoi(String str) {
		if (str.length() == 0)
			return 0;

		boolean positive = true;
		int len = str.length();
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		int maxL = max/10;

		int i = 0;
		// discard whitespace
		while (i < len && str.charAt(i) == ' ') {
			i++;
		}

		if (i < len && str.charAt(i) == '-') {
			positive = false;
			i++;
		}

		if (i < len && str.charAt(i) == '+') {
			i++;
		}

		int t = 0, num = 0;
		for (; i < len; i++) {
			t = str.charAt(i) - '0';
			if (t < 0 || t > 9)
				break;
			if (maxL / 10 >= num) {	
				num = num * 10 + t;	// 最后一位可能溢出
			} else {				// 确定溢出
				return positive ? max : min;
			}
			if (num < 0) {			// 溢出
				return positive ? max : min;
			}

		}

		return positive ? num : -num;
	}
}
