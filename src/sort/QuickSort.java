package sort;

import tools.ArrayUtils;

// quick sort with lots of duplicate value
// ƽ��ʱ�临�Ӷ� O(n * log n)
// �ʱ�临�Ӷ�O��n^2)
public class QuickSort {
	public static int CHANGE = 6;

	public static void main(String[] args) {
		System.out.println("quick sort with lots of duplicate value");
		int[] A = { 3, 1, 1, 1, 1, 1, 12, 2, 1, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 33, 1, 1, 1, 1, 1, 1,
				2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1 };
		int start = 0;
		int end = A.length - 1;
		sort(A, start, end);
		ArrayUtils.printArray(A);
	}

	public static void sort(int[] A, int low, int high) {
		int start = low;
		int end = high;
		int mid = low + ((high - low) >> 1); // ��ֹ�������
		int key = pivotSelect(A, low, mid, high);
		System.out.println("key:" + key);
		int pstart = start;
		int pend = end;
		while (end > start) {
			// �Ӻ���ǰ�Ƚ�
			while (end > start && A[end] >= key) { // ���û�бȹؼ�ֵС�ģ��Ƚ���һ����ֱ���бȹؼ�ֵС�Ľ���λ�ã�Ȼ���ִ�ǰ����Ƚ�
				// �����ظ���key��ֵ���Ҷ˲��룬�ظ���key��ֵ��ʱ����
				if (A[end] != key) {
					A[pend--] = A[end];
				}
				end--;
			}
			A[start] = A[end]; // ��ֵ���Ƶ�start������һ���ж��л��start��ʼ�������Ὣ���ظ���key��ֵ����˲���
			// ��ǰ����Ƚ�
			while (end > start && A[start] <= key) { // ���û�бȹؼ�ֵ��ģ��Ƚ���һ����ֱ���бȹؼ�ֵ��Ľ���λ��
				// �����ظ���key��ֵ����˲���
				if (A[start] != key) {
					A[pstart++] = A[start];
				}
				start++;
			}
			A[end] = A[start]; // ��ֵ���Ƶ�end������һ���ж��У��Ὣ���ظ���key��ֵ���Ҷ˲���
		}
		// ��ʱ��һ��ѭ���ȽϽ������ؼ�ֵ��λ���Ѿ�ȷ���ˡ���ߵ�ֵ���ȹؼ�ֵС���ұߵ�ֵ���ȹؼ�ֵ�󣬵������ߵ�˳���п����ǲ�һ���ģ���������ĵݹ����
		// һ��partition�������м�keyֵ���£�ע��߽�
		for (int i = pstart; i <= pend; i++) {
			A[i] = key;
		}
		// �ݹ飬ע��߽�
		// �ݹ��Ż�����pstart-low<10������£�ʹ�ò�������
		if (pstart > low) {
			if (pstart - low >= CHANGE) {
				sort(A, low, pstart - 1);// ������С���һ������λ�õ��ؼ�ֵ����-1
			} else {
				InsertSort.insertSort(A, low, pstart - 1);
			}
		}
		if (pend < high) {
			if (high - pend >= CHANGE) {
				sort(A, pend + 1, high);// �ұ����С��ӹؼ�ֵ����+1�����һ��
			} else {
				InsertSort.insertSort(A, end + 1, high);
			}
		}
	}

	public static int pivotSelect(int[] A, int low, int mid, int high) {
		// ð�ݣ����ֵ���ұ�
		if (A[low] > A[mid]) {
			ArrayUtils.swap(A, low, mid);
		}
		if (A[mid] > A[high]) {
			ArrayUtils.swap(A, mid, high);
		}
		// ��Сֵ���м�
		if (A[low] < A[mid]) {
			ArrayUtils.swap(A, low, mid);
		}
		return A[low];
	}
}