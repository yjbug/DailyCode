package yj.lintcodeB;

//brute force��ô���������˼·�����ȿ��ַ���s��p�Ĵ�i��j��ʼ���Ӵ��Ƿ�ƥ�䣬�õݹ�ķ���ֱ��������������ݻ����õ���������������ߵ�s��iλ�ã�p��jλ�ã������Ϊ�������֣� 
//(1)p[j+1]����'*'������Ƚϼ򵥣�ֻҪ�жϵ�ǰs��i��p��j�ϵ��ַ��Ƿ�һ���������p��j�ϵ��ַ���'.',Ҳ����ͬ���������ͬ������false�����򣬵ݹ���һ��i+1��j+1; 
//(2)p[j+1]��'*'����ô��ʱ����s[i]��ʼ���Ӵ�������s[i],s[i+1],...s[i+k]������p[j]��ô��ζ����Щ���п����Ǻ��ʵ�ƥ�䣬��ô�ݹ����ʣ�µ�(i,j+2),(i+1,j+2),...,(i+k,j+2)��Ҫ���ԣ�j+2����Ϊ������ǰ����һ��'*'�ַ����� 

//��̬�滮����˼����ǰ����Ǽ��������ʷ��Ϣ��¼�������ȵ�Ҫ�õ���ʱ���ֱ��ʹ�ã��������¼��㡣
//����������棬��������ά��һ����������res[i][j],����s��ǰi���ַ���p��ǰj���ַ��Ƿ�ƥ��
//(ע������res��ά����s.length()+1,p.length()+1)�����ƹ�ʽ���������ƣ�������������� 
//(1)p[j+1]����'*'������Ƚϼ򵥣�ֻҪ�ж������ǰs��i��p��j�ϵ��ַ�һ���������p��j�ϵ��ַ���'.',Ҳ����ͬ��������res[i][j]==true����res[i+1][j+1]ҲΪtrue��res[i+1][j+1]=false; 
//(2)p[j+1]��'*'������p[j]!='.'����ôֻҪ����������һ�����㼴�ɶ�res[i+1][j+1]��ֵΪtrue�� 
//    1)res[i+1][j]Ϊ�棨'*'ֻȡǰ���ַ�һ�Σ�; 
//    2)res[i+1][j-1]Ϊ�棨'*'ǰ���ַ�һ�ζ���ȡ��Ҳ���Ǻ����������ַ���; 
//    3)res[i][j+1] && s[i]==s[i-1] && s[i-1]==p[j-1](����������൱��i��0��s.length()ɨ���������p[j+1]��Ӧ���ַ��ǡ�*���Ǿ���ζ�Ž������Ĵ��Ϳ�������ƥ�����������������ַ�һֱ�ظ������Ҿ��ǡ�*��ǰ����Ǹ��ַ����� 
//(3)p[j+1]��'*'������p[j]=='.'����Ϊ".*"����ƥ�������ַ�����������ǰ���res[i+1][j-1]����res[i+1][j]��ֻҪ��i+1��true����ôʣ�µ�res[i+1][j+1],res[i+2][j+1],...,res[s.length()][j+1]�Ͷ���true�ˡ� 

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		return helper(s, p, 0, 0);
	}

	private boolean helper(String s, String p, int i, int j) {
		if (j == p.length())
			return i == s.length();

		if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
			if (i == s.length() || s.charAt(i) != p.charAt(j) && p.charAt(j) != '.')
				return false;
			else
				return helper(s, p, i + 1, j + 1);
		}
		// p.charAt(j+1)=='*'
		while (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
			if (helper(s, p, i, j + 2))
				return true;
			i++;
		}
		return helper(s, p, i, j + 2);
	}

	public boolean isMatchDP(String s, String p) {
		if (s.length() == 0 && p.length() == 0)
			return true;
		if (p.length() == 0)
			return false;
		boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
		res[0][0] = true;
		for (int j = 0; j < p.length(); j++) {
			if (p.charAt(j) == '*') {
				if (j > 0 && res[0][j - 1])
					res[0][j + 1] = true;
				if (j < 1)
					continue;
				if (p.charAt(j - 1) != '.') {
					for (int i = 0; i < s.length(); i++) {
						if (res[i + 1][j] || j > 0 && res[i + 1][j - 1] || i > 0 && j > 0 && res[i][j + 1]
								&& s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == p.charAt(j - 1))
							res[i + 1][j + 1] = true;
					}
				} else {
					int i = 0;
					while (j > 0 && i < s.length() && !res[i + 1][j - 1] && !res[i + 1][j])
						i++;
					for (; i < s.length(); i++) {
						res[i + 1][j + 1] = true;
					}
				}
			} else {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
						res[i + 1][j + 1] = res[i][j];
				}
			}
		}
		return res[s.length()][p.length()];
	}
}
