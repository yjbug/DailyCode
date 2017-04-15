package sort;

import tools.ArrayUtils;

// quick sort with lots of duplicate value
// 平均时间复杂度 O(n * log n)
// 最坏时间复杂度O（n^2)
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
		int mid = low + ((high - low) >> 1); // 防止大数溢出
		int key = pivotSelect(A, low, mid, high);
		System.out.println("key:" + key);
		int pstart = start;
		int pend = end;
		while (end > start) {
			// 从后往前比较
			while (end > start && A[end] >= key) { // 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
				// 将不重复于key的值往右端并齐，重复于key的值暂时忽略
				if (A[end] != key) {
					A[pend--] = A[end];
				}
				end--;
			}
			A[start] = A[end]; // 把值复制到start，在下一个判断中会从start开始遍历，会将不重复于key的值往左端并齐
			// 从前往后比较
			while (end > start && A[start] <= key) { // 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
				// 将不重复于key的值往左端并齐
				if (A[start] != key) {
					A[pstart++] = A[start];
				}
				start++;
			}
			A[end] = A[start]; // 把值复制到end，在下一个判断中，会将不重复于key的值往右端并齐
		}
		// 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
		// 一次partition结束，中间key值更新，注意边界
		for (int i = pstart; i <= pend; i++) {
			A[i] = key;
		}
		// 递归，注意边界
		// 递归优化，在pstart-low<10的情况下，使用插入排序
		if (pstart > low) {
			if (pstart - low >= CHANGE) {
				sort(A, low, pstart - 1);// 左边序列。第一个索引位置到关键值索引-1
			} else {
				InsertSort.insertSort(A, low, pstart - 1);
			}
		}
		if (pend < high) {
			if (high - pend >= CHANGE) {
				sort(A, pend + 1, high);// 右边序列。从关键值索引+1到最后一个
			} else {
				InsertSort.insertSort(A, end + 1, high);
			}
		}
	}

	public static int pivotSelect(int[] A, int low, int mid, int high) {
		// 冒泡，最大值放右边
		if (A[low] > A[mid]) {
			ArrayUtils.swap(A, low, mid);
		}
		if (A[mid] > A[high]) {
			ArrayUtils.swap(A, mid, high);
		}
		// 最小值放中间
		if (A[low] < A[mid]) {
			ArrayUtils.swap(A, low, mid);
		}
		return A[low];
	}
}