package others;

import java.util.HashMap;

// 3.0/0.0 = Infinity
// 0.0/0.0 = NaN
// NaN - NaN = NaN
// Infinity - Infinity = NaN
// Infinity == Infinity is true  <<============
// Infinity1 == Infinity2 is true
// NaN == NaN is false

public class DoubleTest {
	public static void main(String[] args) {
		double inf = 3 / 0.0;
		double nan = 0.0 / 0;
		double inf2 = 4 / 0.0;
		System.out.println(inf);
		System.out.println(nan);
		if (inf == inf) {
			System.out.println("inf==inf is true");
		}
		if (nan != nan) {
			System.out.println("nan==nan is false");
		}
		if (inf == inf2) {
			System.out.println("inf==inf2 is true");
		}

		HashMap<Double, Integer> map = new HashMap<>();
		map.put(nan, 10086);
		System.out.println(map.containsKey(nan));
		map.put(inf, 10010);
		System.out.println(map.containsKey(inf));

		double one = 1.0;
		System.out.println("1.0 == 1 is " + (one == 1));
		
		
		
		// float小数部分最多7位有效数字，精度保证6位
		// double小数部分最多16位有效数字，精度保证15位
		
		System.out.println("\n=============精度测试===============");
		System.out.println(Math.abs(1.3f-(8.3f-7.0f))<1e-6);
		System.out.println(Math.abs(1.3f-(8.3f-7.0f))<1e-7);
		System.out.println(Math.abs(1.3-(8.3-7.0))<1e-15);
		System.out.println(Math.abs(1.3-(8.3-7.0))<1e-16);

	}
}
