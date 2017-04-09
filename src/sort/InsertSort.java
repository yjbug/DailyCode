package sort;

import tools.ArrayUtils;

/**
 * 0. 设数组为a[0…n-1] 
 * 1. 初始时，a[0]自成1个有序区，无序区为a[1..n-1] 令i=1 
 * 2. 将a[i]并入当前的有序区a[0…i-1]中形成a[0…i]的有序区间 
 * 3. i++并重复第二步直到i==n-1。排序完成。
 */
public class InsertSort {
	public static void main(String[] args) {
		int A[] = ArrayUtils.ARRAY;
		InsertSort.insertSort(A);
		ArrayUtils.printArray(A);
		
		A = ArrayUtils.ARRAYDE;
		InsertSort.insertSort(A);
		ArrayUtils.printArray(A);
	}

	public final static void insertSort(final int A[]) {
		int i, j, k;
		for (i = 1; i < A.length; i++) {
			for (j = i - 1; j >= 0; j--) {
				if (A[j] < A[i]) {
					break;
				}
			}
			int temp = A[i];
			for (k = i - 1; k > j; k--) {
				A[k + 1] = A[k];
			}
			A[k + 1] = temp;
		}
	}
	//重载，部分数组的插入排序
	public final static void insertSort(final int A[] , int l , int r){
		int i,j,k;
		for(i=l;i<=r;i++){
			for(j=i-1;j>=l;j--){
				if(A[j]<A[i]){
					break;
				}
			}
			int temp = A[i];
			for (k = i - 1; k > j; k--) {
				A[k + 1] = A[k];
			}
			A[k + 1] = temp;
		}
	}
	
	
}
