package yj.lintcodeA;

import java.util.ArrayList;
// 重复次数超过一半的数
public class MajorityNumber {
	public int majorityNumber(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return 0;
		}
		int curNum = -1;
		int count = 0;
		for (int i : nums) {
			if (count == 0) {
				curNum = i;
				count++;
			} else {
				if (curNum == i) {
					count++;
				} else {
					count--;
				}
			}
		}
		return curNum;
	}
}
