package yj.lintcodeB;

public class ClimbingStairs {
	public int climbStairs(int n) {

		int pre1 = 0;
		int pre2 = 1;
		int cur = 1; // ��ʼ���� n<=0 ʱ ���� 1
		int step = 1;
		while (step <= n) {
			cur = pre1 + pre2;
			pre1 = pre2;
			pre2 = cur;
			step++;
		}
		return cur;
	}
}
