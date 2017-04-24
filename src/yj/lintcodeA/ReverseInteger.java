package yj.lintcodeA;

public class ReverseInteger {
	public int reverseInteger(int n) {
		// Write your code here
		int res = 0;
		int flag = 1;
		int modify = 0;
		// 正整数取余数
		if (n < 0) {
			flag = -1;
			// 类似-128 ~ 127
			if (n == Integer.MIN_VALUE) {
				modify = -1;
				n++;
			}
			n = -n;
		}
		// 最大值最小值的描述
		int maxL = Integer.MAX_VALUE / 10;
		int maxR = Integer.MAX_VALUE % 10;
		// 防止大数溢出，优化判断逻辑
		while (n != 0) {
			int cur = n % 10;
			n /= 10;
			if (res >= maxL) {
				if (!(res == maxL && cur <= maxR)) {
					return 0;
				}
			}
			res = res * 10 + cur;
		}
		res = flag * res + modify;
		return res;
	}
}
