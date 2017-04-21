package yj.lintcode;

import java.util.HashMap;
import tools.Point;

// 3.0/0.0 = Infinity
// 0.0/0.0 = NaN
// NaN - NaN = NaN
// Infinity - Infinity = NaN
// Infinity == Infinity is true  ---特殊
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
			// j可以从i+1开始，如果i左边的点可能构成包含最多点的直线，比如过点k(0<=k<i);
			// 则之前访问点k时，已经计算过以点k,i为直线包含的Point；因此无需重复计算
			for (int j = i + 1; j < points.length; j++) {
				//重复的Point需要单独计算， 针对大部分数据点有是重复点时的状况
				//主要是无法判断  NaN == NaN 的成立
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
			max = Math.max(max, curMax + duplicate);// 累加与当前点重合的点数！！！！
		}
		return max;
	}
}
