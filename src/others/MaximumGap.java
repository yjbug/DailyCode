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
		// N+1个桶，N个数，则只考虑空桶两端的值
		// 用一个boolean数组确定桶内是否有元素，每个桶只需要保留两个元素，该桶内的最大值和最小值
		boolean[] hasNum = new boolean[len + 1];
		int[] maxs = new int[len + 1];
		int[] mins = new int[len + 1];

		int bid = 0;
		// 桶间距， 桶编号从 0 开始，最大编号为 len ,一共len+1个桶，len个数据
		double gap = (max - min) / (double) (len);	//注意数据类型的转换，不能两个int运算
		for (int i = 0; i < len; i++) {
			bid = bucket(A[i], min, gap); // 算出桶号
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], A[i]) : A[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], A[i]) : A[i];
			hasNum[bid] = true;
		}
		int lastMax = 0;
		int i = 0;
		while (i <= len) {
			if (hasNum[i++]) { // 找到第一个不为空的桶
				lastMax = maxs[i - 1];
				break;
			}
		}
		// lastMax缓存上一个非空桶的右值
		// 间隔： 当前桶左值 - 上一个非空桶的右值
		for (; i <= len; i++) {
			if (hasNum[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}

	// 使用double类型是为了防止相乘时溢出,采用桶间距描述，更加清晰
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

		// N+1个桶，N个数，则只考虑空桶两端的值
		// 用一个boolean数组确定桶内是否有元素，每个桶只需要保留两个元素，该桶内的最大值和最小值
		boolean[] hasNum = new boolean[len + 1];
		float[] maxs = new float[len + 1];
		float[] mins = new float[len + 1];
		int bid = 0;
		// 桶间距， 桶编号从 0 开始，最大编号为 len ,一共len+1个桶，len个数据
		double gap = (max - min) / (double) (len);
		// 数据入桶过程
		for (int i = 0; i < len; i++) {
			bid = bucket(A[i], min, gap); // 算出桶号
			System.out.println(bid);
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], A[i]) : A[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], A[i]) : A[i];
			hasNum[bid] = true;
		}
		float lastMax = 0;
		int i = 0;
		while (i <= len) {
			if (hasNum[i++]) { // 找到第一个不为空的桶
				lastMax = maxs[i - 1];
				break;
			}
		}
		// lastMax缓存上一个非空桶的右值
		// 间隔： 当前桶左值 - 上一个非空桶的右值
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
		
		// float最多7位有效数字，精度保证6位
		// double最多16位有效数字，精度保证15位
		
		System.out.println(Math.abs(1.3f-(8.3f-7.0f))<1e-6);
		System.out.println(Math.abs(1.3f-(8.3f-7.0f))<1e-7);
		System.out.println(Math.abs(1.3-(8.3-7.0))<1e-15);
		System.out.println(Math.abs(1.3-(8.3-7.0))<1e-16);
	}

}
