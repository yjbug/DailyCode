package classical_algorithm;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "AAAAAAAAA";
		int next[] = null;
		next = getNext(str);
		for (int i : next) {
			System.out.print(i + " ");
		}
		String target = "ABCDABDE";
		boolean flag = kmpSearch(target, str, next);
		System.out.println(flag);
	}

	private static boolean kmpSearch(String tar, String pat, int[] next) {
		// TODO Auto-generated method stub
		int tlen = tar.length();
		int plen = pat.length();
		int i = 0, j = 0;
		while (i < tlen && j < plen) {
			if (j == -1 || tar.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		return j == plen;
	}

	private static int[] getNext(String str) {
		// TODO Auto-generated method stub
		final int len = str.length();
		int next[] = new int[len];
		next[0] = -1;
		int k = -1;
		int i = 0;
		while (i < len - 1) {
			if (k == -1 || str.charAt(i) == str.charAt(k)) {
				next[++i] = ++k;
			} else {
				k = next[k];
			}
		}
		return next;
	}

}
