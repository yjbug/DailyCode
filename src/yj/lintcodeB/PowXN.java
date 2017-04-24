package yj.lintcodeB;

public class PowXN {
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (Math.abs(x) < 1e-7) {
			return 0;
		}
		boolean negative = false;
		if (n < 0) {
			negative = true;
			n = -n;
		}
		double modify = (n & 1) == 0 ? 1 : x;	// 优先级 == 高于 &、&&
		double res = modify * myPow(x * x, n >> 1);
		if (negative) {
			return 1 / res;
		} else {
			return res;
		}
	}
}
