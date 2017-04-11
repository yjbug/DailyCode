package others;

public class RandomChoice {
	// k-means++ 尽可能最大化初始中心点之间的距离的应用
	// 随机选取用两名选手，被选取的选手的能力值尽可能的高
	// 该算法一次选取时，选手被选取的概率为   P = V/N  , V为选手个人能力，N为所有选手的总能力
	public static void main(String[] args) {
		int A[] = new int[] { 1, 3, 4, 53, 22, 4, 2 };
		RandomChoice T = new RandomChoice();
		int res[] = T.randChoice(A);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	
	// 返回选手的序号
	public int[] randChoice(int[] A) {
		if (A == null || A.length <= 2) {
			return A;
		}
		int res[] = new int[2];
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		System.out.println(sum);

		double tar1 = sum * Math.random();
		int index1 = 0;
		System.out.println(tar1);
		while (tar1 > 0) {
			tar1 -= A[index1++];
		}
		index1--;
		res[0] = index1;
		
		// 剔除res[0]
		sum -= A[res[0]];
		double tar2 = sum * Math.random();
		int index2 = 0;
		System.out.println(tar2);
		while (tar2 > 0) {
			if (index2 != index1) {
				tar2 -= A[index2];
			}
			index2++;
		}
		index2--;
		res[1] = index2;
		return res;
	}

}
