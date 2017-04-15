package sort;

import tools.ArrayUtils;

// 时间复杂度  好坏都是  O( n * log n )
// 有两种实现方法：自底向上和自顶向下
// 自底向上时，需要考虑的情况比较多：  分别有子文件奇数与偶数的情况
// 奇数：  最后一个子文件不参与当前的二路归并，留到下一次迭代
// 偶数： 最后一个子文件的上界是数组 length - 1
// 自顶向下时，先深度递归到单个元素，然后再进行自底向上的Merge

public class MergeSort {

	public static void main(String[] args) {
		MergeSort T = new MergeSort();
		
		int A[] = ArrayUtils.ARRAY.clone();
		ArrayUtils.printArray(A);
		T.mergeSortA(A, 1);
		ArrayUtils.printArray(A);

		A = ArrayUtils.ARRAYDE.clone();
		T.mergeSortA(A, 1);
		ArrayUtils.printArray(A);

		A = ArrayUtils.ARRAY.clone();
		T.mergeSortB(A, 0, A.length - 1);
		ArrayUtils.printArray(A);

		A = ArrayUtils.ARRAY.clone();
		T.mergeSortC(A, A.clone(), 0, A.length - 1);
		ArrayUtils.printArray(A);		

	}

	// 自底向上 ， 每次归并相邻两个length长度的数据块， 注意边界的处理
	public void mergeSortA(int A[], int len) {
		int i = 0;
		// 先处理前面正常的偶数个子文件
		while (i + 2 * len < A.length) {
			// i为左子块的起始下标， i+len为右子块的起始下标， i+2*len-1为右子块最终下标
			merge(A, i, i + len, i + 2 * len - 1);
			i += 2 * len; // 更新到一个新的归并区块
		}
		// 处理有上界的偶数个文件
		if (i + len <= A.length - 1) { // 右子块起始下标没有越界，所以是偶数个文件块
			merge(A, i, i + len, A.length - 1);
		}
		// 处理奇数个文件块，最后一个文件块直接忽略处理，留到下一次迭代

		// 现在处理了当前数据块长度为len的二路归并，下一步处理长度为2*len的二路归并
		// 注意递归的结束条件
		if (len < A.length)
			mergeSortA(A, len << 1);
	}

	// 自顶向下，先深度递归到单个元素，然后再进行自底向上的Merge
	public void mergeSortB(int A[], int l, int r) {
		if (l >= r) {
			return;
		}
		// r>l ,至少两个元素
		// 深度递归，类似后序遍历
		int mid = l + ((r - l) >> 1); // 注意优先级 >> is higher than +
		mergeSortB(A, l, mid);
		mergeSortB(A, mid + 1, r);
		merge(A, l, mid + 1, r);
	}

	// 自顶向下, 用两个等长数组交替计算，优化空间复杂度 ；优化前：O(n*log n) 优化后：O(n)
	public void mergeSortC(int A[], int temp[], int l, int r) {
		if (l >= r) {
			return;
		}
		int mid = l + ((r - l) >> 1);
		// 交替使用空间
		mergeSortC(temp, A, l, mid);
		mergeSortC(temp, A, mid + 1, r);
		// merge temp to A ， so，  A is the answer
		merge(temp, A, l, mid + 1, r); //注意是右子块下标的起始位置
	}

	// l 为左子块的起始下标，mid 为右子块的起始下标， r 为右子块最终下标
	private void merge(int[] A, int l, int mid, int r) {
		int[] temp = new int[r + 1 - l];
		// 二路归并
		int cur = 0;
		int k1 = l;
		int k2 = mid;
		// 逻辑
		while (k1 < mid && k2 <= r) {
			temp[cur++] = A[k1] < A[k2] ? A[k1++] : A[k2++];
		}
		while (k1 < mid) {
			temp[cur++] = A[k1++];
		}
		while (k2 <= r) {
			temp[cur++] = A[k2++];
		}

		// 更新temp[]到A[]
		for (int val : temp) {
			A[l++] = val;
		}
	}

	// 简单重载一下
	private void merge(int[] A, int[] temp, int l, int mid, int r) {
		// 二路归并
		int cur = l;
		int k1 = l;
		int k2 = mid;
		// 逻辑
		while (k1 < mid && k2 <= r) {
			temp[cur++] = A[k1] < A[k2] ? A[k1++] : A[k2++];
		}
		while (k1 < mid) {
			temp[cur++] = A[k1++];
		}
		while (k2 <= r) {
			temp[cur++] = A[k2++];
		}
	}

}
