package yj.lintcodeA;

public class PlusOne {
	/**
	 * @param digits
	 *            a number represented as an array of digits
	 * @return the result
	 */
	public int[] plusOne(int[] digits) {
		if(digits==null||digits.length==0){
			return digits;
		}
		int carry = 1;
		int curId = digits.length - 1;
		while (curId >= 0 && carry == 1) {
			digits[curId]++;
			carry = digits[curId] / 10;
			digits[curId--] %= 10;
		}

		if (carry == 1) {
			int res[] = new int[digits.length + 1];
			res[0] = 1;
			return res;
		} else {
			return digits;
		}
	}
}
