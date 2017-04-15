package test;

public class Test {
	public static void main(String[] args) {
		int l = 1;
		int r = 3;
		int mid = l + ((r - l) >> 1);
		System.out.println(mid);
	}
}
