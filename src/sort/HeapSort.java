package sort;

//堆是一棵完全二叉树, 底层如果用数组存储数据的话，
//假设某个元素为序号为i(Java数组从0开始,i为0到n-1)
//如果它有左子树，那么左子树的位置是2i+1，如果有右子树，右子树的位置是2i+2
//如果有父节点，父节点的位置是(i-1)/2取整。分为最大堆和最小堆
public class HeapSort {
	public static void main(String[] args) {
		int A[] = new int[] { 3, 8, 7, 4, 5, 11, 15, 55, 2, 1, 112, -1, -2, -3 };
		HeapSort.buildheap(A);
		// 最大值交换到尾部，同时需要调整的堆大小减去1
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
	 *            初始化堆，构建一个最大堆
	 */
	public static void buildheap(int A[]) {
		if (A == null || A.length <= 1) {
			return;
		}

		int half = A.length >> 1;
		for (int i = half; i >= 0; i--) {
			// 从第一个非叶子节点开始调整成为最大堆
			maxHeap(A, A.length, i);
		}

	}

	// 调整节点i为最大，对于每个下沉的数都要继续判断是否满足条件
	/**
	 * @param A
	 *            数组
	 * @param length
	 *            要调整的堆的长度，调用时注意是长度，而不是下标
	 * @param i
	 *            调整的节点
	 */
	private static void maxHeap(int[] A, int length, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		// 3个数取最大值的方法
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
