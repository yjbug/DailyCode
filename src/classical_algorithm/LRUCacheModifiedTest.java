package classical_algorithm;

/**
 * 改进的LRU算法的命中率相对稳定，一定程度上抵抗缓存污染，且无太多额外代价
 *
 */
public class LRUCacheModifiedTest {

	public static void main(String[] args) {
		// 1000 个可能的值，200个缓存器 , 70%的数值在 0~200
		// LRUModified hit rate: 0.84282
		// LRU hit rate: 0.81824
		// LRUModified 的命中率不一定比 LRU高， 但是相对稳定

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
