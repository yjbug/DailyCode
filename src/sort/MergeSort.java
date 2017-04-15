package sort;

import tools.ArrayUtils;

// ʱ�临�Ӷ�  �û�����  O( n * log n )
// ������ʵ�ַ������Ե����Ϻ��Զ�����
// �Ե�����ʱ����Ҫ���ǵ�����Ƚ϶ࣺ  �ֱ������ļ�������ż�������
// ������  ���һ�����ļ������뵱ǰ�Ķ�·�鲢��������һ�ε���
// ż���� ���һ�����ļ����Ͻ������� length - 1
// �Զ�����ʱ������ȵݹ鵽����Ԫ�أ�Ȼ���ٽ����Ե����ϵ�Merge

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

	// �Ե����� �� ÿ�ι鲢��������length���ȵ����ݿ飬 ע��߽�Ĵ���
	public void mergeSortA(int A[], int len) {
		int i = 0;
		// �ȴ���ǰ��������ż�������ļ�
		while (i + 2 * len < A.length) {
			// iΪ���ӿ����ʼ�±꣬ i+lenΪ���ӿ����ʼ�±꣬ i+2*len-1Ϊ���ӿ������±�
			merge(A, i, i + len, i + 2 * len - 1);
			i += 2 * len; // ���µ�һ���µĹ鲢����
		}
		// �������Ͻ��ż�����ļ�
		if (i + len <= A.length - 1) { // ���ӿ���ʼ�±�û��Խ�磬������ż�����ļ���
			merge(A, i, i + len, A.length - 1);
		}
		// �����������ļ��飬���һ���ļ���ֱ�Ӻ��Դ���������һ�ε���

		// ���ڴ����˵�ǰ���ݿ鳤��Ϊlen�Ķ�·�鲢����һ��������Ϊ2*len�Ķ�·�鲢
		// ע��ݹ�Ľ�������
		if (len < A.length)
			mergeSortA(A, len << 1);
	}

	// �Զ����£�����ȵݹ鵽����Ԫ�أ�Ȼ���ٽ����Ե����ϵ�Merge
	public void mergeSortB(int A[], int l, int r) {
		if (l >= r) {
			return;
		}
		// r>l ,��������Ԫ��
		// ��ȵݹ飬���ƺ������
		int mid = l + ((r - l) >> 1); // ע�����ȼ� >> is higher than +
		mergeSortB(A, l, mid);
		mergeSortB(A, mid + 1, r);
		merge(A, l, mid + 1, r);
	}

	// �Զ�����, �������ȳ����齻����㣬�Ż��ռ临�Ӷ� ���Ż�ǰ��O(n*log n) �Ż���O(n)
	public void mergeSortC(int A[], int temp[], int l, int r) {
		if (l >= r) {
			return;
		}
		int mid = l + ((r - l) >> 1);
		// ����ʹ�ÿռ�
		mergeSortC(temp, A, l, mid);
		mergeSortC(temp, A, mid + 1, r);
		// merge temp to A �� so��  A is the answer
		merge(temp, A, l, mid + 1, r); //ע�������ӿ��±����ʼλ��
	}

	// l Ϊ���ӿ����ʼ�±꣬mid Ϊ���ӿ����ʼ�±꣬ r Ϊ���ӿ������±�
	private void merge(int[] A, int l, int mid, int r) {
		int[] temp = new int[r + 1 - l];
		// ��·�鲢
		int cur = 0;
		int k1 = l;
		int k2 = mid;
		// �߼�
		while (k1 < mid && k2 <= r) {
			temp[cur++] = A[k1] < A[k2] ? A[k1++] : A[k2++];
		}
		while (k1 < mid) {
			temp[cur++] = A[k1++];
		}
		while (k2 <= r) {
			temp[cur++] = A[k2++];
		}

		// ����temp[]��A[]
		for (int val : temp) {
			A[l++] = val;
		}
	}

	// ������һ��
	private void merge(int[] A, int[] temp, int l, int mid, int r) {
		// ��·�鲢
		int cur = l;
		int k1 = l;
		int k2 = mid;
		// �߼�
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
