package yj.lintcodeA;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters T = new LongestSubstringWithoutRepeatingCharacters();
		T.lengthOfLongestSubstring("gehmbfqmozbpripibusbezagafqtypz");
	}
	
	public int lengthOfLongestSubstring(String s) {
		// dp + hashmap
		// o(n) time
		// o(1) space
		int map[] = new int[256]; // for all ASCII
		Arrays.fill(map, -1);
		
		int last = 0;
		int max = 0;
		// "abcadbc"
		for (int i = 0; i < s.length(); i++) {
			int cur = (int) s.charAt(i);
			if(map[cur]==-1){
				map[cur] = i;
			}else{
				//int tempMax = i - map[cur]; this is error answer
				int tempMax = i - last;
				max = max>tempMax?max:tempMax;
				if(map[cur]>=last){
					last=map[cur]+1;
				}
				map[cur] = i;
			}	
		}
		//最后一步，将尾部的不重复子串进行计算
		if(max<s.length()-last){
			max = s.length()-last;
		}
		return max;
	}
}
