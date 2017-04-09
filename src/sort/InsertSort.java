package sort;

import tools.ArrayUtils;

/**
 * 0. ������Ϊa[0��n-1] 
 * 1. ��ʼʱ��a[0]�Գ�1����������������Ϊa[1..n-1] ��i=1 
 * 2. ��a[i]���뵱ǰ��������a[0��i-1]���γ�a[0��i]���������� 
 * 3. i++���ظ��ڶ���ֱ��i==n-1��������ɡ�
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
	//���أ���������Ĳ�������
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
