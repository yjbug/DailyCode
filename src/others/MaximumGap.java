package others;

import tools.ArrayUtils;

public class MaximumGap {

	public int maxGap(int A[]) {
		int res = 0;
		if (A == null || A.length < 2) {
			return res;
		}

		int len = A.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			min = Math.min(min, A[i]);
			max = Math.max(max, A[i]);
		}

		if (min == max) {
			return 0;
		}
		// N+1��Ͱ��N��������ֻ���ǿ�Ͱ���˵�ֵ
		// ��һ��boolean����ȷ��Ͱ���Ƿ���Ԫ�أ�ÿ��Ͱֻ��Ҫ��������Ԫ�أ���Ͱ�ڵ����ֵ����Сֵ
		boolean[] hasNum = new boolean[len + 1];
		int[] maxs = new int[len + 1];
		int[] mins = new int[len + 1];

		int bid = 0;
		// Ͱ��࣬ Ͱ��Ŵ� 0 ��ʼ�������Ϊ len ,һ��len+1��Ͱ��len������
		double gap = (max - min) / (double) (len);	//ע���������͵�ת������������int����
		for (int i = 0; i < len; i++) {
			bid = bucket(A[i], min, gap); // ���Ͱ��
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], A[i]) : A[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], A[i]) : A[i];
			hasNum[bid] = true;
		}
		int lastMax = 0;
		int i = 0;
		while (i <= len) {
			if (hasNum[i++]) { // �ҵ���һ����Ϊ�յ�Ͱ
				lastMax = maxs[i - 1];
				break;
			}
		}
		// lastMax������һ���ǿ�Ͱ����ֵ
		// ����� ��ǰͰ��ֵ - ��һ���ǿ�Ͱ����ֵ
		for (; i <= len; i++) {
			if (hasNum[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}

	// ʹ��double������Ϊ�˷�ֹ���ʱ���,����Ͱ�����������������
	public static int bucket(double num, double min, double gap) {
		return (int) ((num - min) / (gap));
	}

	public float maxGap(float A[]) {
		float res = 0;
		if (A == null || A.length < 2) {
			return res;
		}

		int len = A.length;
		float min = Float.MAX_VALUE;
		float max = Float.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			min = Math.min(min, A[i]);
			max = Math.max(max, A[i]);
		}
		if (Math.abs(max - min) < 1e-6) {
			return 0;
		}

		// N+1��Ͱ��N��������ֻ���ǿ�Ͱ���˵�ֵ
		// ��һ��boolean����ȷ��Ͱ���Ƿ���Ԫ�أ�ÿ��Ͱֻ��Ҫ��������Ԫ�أ���Ͱ�ڵ����ֵ����Сֵ
		boolean[] hasNum = new boolean[len + 1];
		float[] maxs = new float[len + 1];
		float[] mins = new float[len + 1];
		int bid = 0;
		// Ͱ��࣬ Ͱ��Ŵ� 0 ��ʼ�������Ϊ len ,һ��len+1��Ͱ��len������
		double gap = (max - min) / (double) (len);
		// ������Ͱ����
		for (int i = 0; i < len; i++) {
			bid = bucket(A[i], min, gap); // ���Ͱ��
			System.out.println(bid);
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], A[i]) : A[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], A[i]) : A[i];
			hasNum[bid] = true;
		}
		float lastMax = 0;
		int i = 0;
		while (i <= len) {
			if (hasNum[i++]) { // �ҵ���һ����Ϊ�յ�Ͱ
				lastMax = maxs[i - 1];
				break;
			}
		}
		// lastMax������һ���ǿ�Ͱ����ֵ
		// ����� ��ǰͰ��ֵ - ��һ���ǿ�Ͱ����ֵ
		for (; i <= len; i++) {
			if (hasNum[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}

	public static int bucketFloat(double num, double min, double gap) {
		return (int) ((num - min) / (gap));
	}

	public static void main(String[] args) {
		MaximumGap T = new MaximumGap();
		int gap = T.maxGap(ArrayUtils.ARRAYDE);
		System.out.println("max gap: " + gap);
		float gapFloat = T.maxGap(new float[]{3,2,4,5,1,6.5f,6,8.2f,7.1f,8.1999999f});
		System.out.println("max gap: " + gapFloat);
		
		// float���7λ��Ч���֣����ȱ�֤6λ
		// double���16λ��Ч���֣����ȱ�֤15λ
		
		System.out.println(Math.abs(1.3f-(8.3f-7.0f))<1e-6);
		System.out.println(Math.abs(1.3f-(8.3f-7.0f))<1e-7);
		System.out.println(Math.abs(1.3-(8.3-7.0))<1e-15);
		System.out.println(Math.abs(1.3-(8.3-7.0))<1e-16);
	}

}
