package yj.lintcode;

import java.util.HashMap;
import tools.Point;

// 3.0/0.0 = Infinity
// 0.0/0.0 = NaN
// NaN - NaN = NaN
// Infinity - Infinity = NaN
// Infinity == Infinity is true  ---����
// Infinity1 == Infinity2 is true
// NaN == NaN is false

public class MaxPointsonaLine {

	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			double x = points[i].x;
			double y = points[i].y;
			HashMap<Double, Integer> map = new HashMap<>();
			int duplicate = 1;
			// j���Դ�i+1��ʼ�����i��ߵĵ���ܹ��ɰ��������ֱ�ߣ��������k(0<=k<i);
			// ��֮ǰ���ʵ�kʱ���Ѿ�������Ե�k,iΪֱ�߰�����Point����������ظ�����
			for (int j = i + 1; j < points.length; j++) {
				//�ظ���Point��Ҫ�������㣬 ��Դ󲿷����ݵ������ظ���ʱ��״��
				//��Ҫ���޷��ж�  NaN == NaN �ĳ���
				if (points[j].y == y && points[j].x == x) {
					duplicate++;
				} else {
					double k = (points[j].y - y) / (points[j].x - x);
					map.put(k, map.containsKey(k) ? map.get(k) + 1 : 1);
				}
			}
			int curMax = 0;
			for (Double key : map.keySet()) {
				curMax = Math.max(curMax, map.get(key));
			}
			max = Math.max(max, curMax + duplicate);// �ۼ��뵱ǰ���غϵĵ�����������
		}
		return max;
	}
}
