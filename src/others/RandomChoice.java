package others;

public class RandomChoice {
	// k-means++ ��������󻯳�ʼ���ĵ�֮��ľ����Ӧ��
	// ���ѡȡ������ѡ�֣���ѡȡ��ѡ�ֵ�����ֵ�����ܵĸ�
	// ���㷨һ��ѡȡʱ��ѡ�ֱ�ѡȡ�ĸ���Ϊ   P = V/N  , VΪѡ�ָ���������NΪ����ѡ�ֵ�������
	public static void main(String[] args) {
		int A[] = new int[] { 1, 3, 4, 53, 22, 4, 2 };
		RandomChoice T = new RandomChoice();
		int res[] = T.randChoice(A);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	
	// ����ѡ�ֵ����
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
		
		// �޳�res[0]
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
