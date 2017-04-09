package classical_algorithm;

/**
 * �Ľ���LRU�㷨������������ȶ���һ���̶��ϵֿ�������Ⱦ������̫��������
 *
 */
public class LRUCacheModifiedTest {

	public static void main(String[] args) {
		// 1000 �����ܵ�ֵ��200�������� , 70%����ֵ�� 0~200
		// LRUModified hit rate: 0.84282
		// LRU hit rate: 0.81824
		// LRUModified �������ʲ�һ���� LRU�ߣ� ��������ȶ�

		int SIZE = 600;
		LRUCacheModified T = new LRUCacheModified(SIZE);
		LRUCache E = new LRUCache(SIZE);
		double PERCENT;
		double times = 100000.0;

		int count = 0;
		int count2 = 0;

		PERCENT = 0.70;
		int MAX = 10000;
		int P = 300;
		int temp = (int) (PERCENT * MAX);
		for (int i = 0; i < times; i++) {
			int key = (int) (Math.random() * MAX);
			if (key < temp) {
				key = (int) (Math.random() * P);
			} else {
				key = (int) (Math.random() * (MAX - P)) + P;
			}
			if (T.get(key) != null) {
				count++;
			}
			T.put(key, 0);

			if (E.get(key) != null) {
				count2++;
			}
			E.put(key, 0);
		}
		System.out.println("LRUModified hit rate: " + (count / times));
		System.out.println("LRU hit rate: " + (count2 / times));
	}

}
