package yj.lintcode;

import java.util.HashMap;
// ������������ͨ���ֵ��໥ת��
public class RomanAndInteger {
	private static HashMap<Character, Integer> map = new HashMap<>();
	private static String[][] roman = { { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
			{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
			{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" }, { "", "M", "MM", "MMM" } };
	static {
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}
	
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int pre = 0;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			int cur = toNumber(s.charAt(i));
			// �������ֵ�������ɣ���ǰ��ĸֻ���ǰһ����ĸ ���� ����3����ĸ�й���
			// ����������ĸ�Ĺ���ֱ�Ӽ��ڷ���ֵ��
			if (pre < cur) { // ǰһ����ĸ�ȵ�ǰ��ĸ��ֵС
				res += cur - 2 * pre;
			} else {
				res += cur;
			}
			pre = cur; // ����pre
		}
		return res;
	}

	public String intToRoman(int num) {
		String ret = "";
		int digit = 0;
		while (num != 0) {
			int remain = num % 10;
			ret = roman[digit][remain] + ret;
			digit++;
			num /= 10;
		}

		return ret;
	}

	int toNumber(char ch) {
		return map.get(ch);
	}

}
