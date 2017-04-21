package yj.lintcode;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * @param numbers
 *            Give an array numbers of n integer.
 * @return Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(nums);
		int sum;
		for (int i = 0; i < nums.length; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				sum = nums[i] + nums[start] + nums[end];
				if (sum == 0) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(nums[i]);
					tmp.add(nums[start]);
					tmp.add(nums[end]);
					result.add(tmp);
					start++;
					end--;
					while (start < end && nums[start] == nums[start - 1]) {
						start++;
					}
					while (start < end && nums[end] == nums[end + 1]) {
						end--;
					}
				} else if (sum < 0) {
					start++;
				} else {
					end--;
				}
			}
			while (i + 1 < nums.length - 1 && nums[i + 1] == nums[i]) {
				i++;
			}
		}
		return result;
	}
}
