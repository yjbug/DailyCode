package yj.lintcodeB;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum = Integer.MIN_VALUE;
		for (int one : nums) {
			if (sum < 0) {
				sum = one;
			} else {
				sum += one;
			}
			max = Math.max(max, sum);
		}
		return max;
	}
}
