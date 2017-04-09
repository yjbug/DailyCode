package sort;

//����һ����ȫ������, �ײ����������洢���ݵĻ���
//����ĳ��Ԫ��Ϊ���Ϊi(Java�����0��ʼ,iΪ0��n-1)
//�����������������ô��������λ����2i+1�����������������������λ����2i+2
//����и��ڵ㣬���ڵ��λ����(i-1)/2ȡ������Ϊ���Ѻ���С��
public class HeapSort {
	public static void main(String[] args) {
		int A[] = new int[] { 3, 8, 7, 4, 5, 11, 15, 55, 2, 1, 112, -1, -2, -3 };
		HeapSort.buildheap(A);
		// ���ֵ������β����ͬʱ��Ҫ�����ĶѴ�С��ȥ1
		for (int i = A.length - 1; i > 0; i--) {
			swap(A, 0, i);
			HeapSort.maxHeap(A, i, 0);
		}
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}

	}

	/**
	 * @param A
	 *            ��ʼ���ѣ�����һ������
	 */
	public static void buildheap(int A[]) {
		if (A == null || A.length <= 1) {
			return;
		}

		int half = A.length >> 1;
		for (int i = half; i >= 0; i--) {
			// �ӵ�һ����Ҷ�ӽڵ㿪ʼ������Ϊ����
			maxHeap(A, A.length, i);
		}

	}

	// �����ڵ�iΪ��󣬶���ÿ���³�������Ҫ�����ж��Ƿ���������
	/**
	 * @param A
	 *            ����
	 * @param length
	 *            Ҫ�����Ķѵĳ��ȣ�����ʱע���ǳ��ȣ��������±�
	 * @param i
	 *            �����Ľڵ�
	 */
	private static void maxHeap(int[] A, int length, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		// 3����ȡ���ֵ�ķ���
		int largestId = i;
		if (left < length && A[left] > A[largestId]) {
			largestId = left;
		}
		if (right < length && A[right] > A[largestId]) {
			largestId = right;
		}
		if (largestId != i) {
			swap(A, largestId, i);
			maxHeap(A, length, largestId);
		}
	}

	public static void swap(int a[], int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
