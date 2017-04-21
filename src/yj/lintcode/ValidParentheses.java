package yj.lintcode;

import java.util.HashMap;
import java.util.LinkedList;

public class ValidParentheses {
	private final static HashMap<Character, Character> map = new HashMap<>();
	static {
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
	}

	public boolean isValidParentheses(String s) {
		final LinkedList<Character> LinkedList = new LinkedList<>();
		for (char one : s.toCharArray()) {
			if (one == '(' || one == '{' || one == '[') {
				LinkedList.add(one);
			} else {
				if (LinkedList.size() == 0) {
					return false;
				}
				if (map.get(one) != LinkedList.pollLast()) {
					return false;
				}
			}
		}
		if (LinkedList.size() == 0) {
			return true;
		} else {
			return false;
		}

	}
}
