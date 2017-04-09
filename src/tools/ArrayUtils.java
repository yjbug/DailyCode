package tools;

public class ArrayUtils {
	public final static int[] ARRAY = new int[]{ 3, 8, 7, 4, 5, 11, 15, 55, 2, 1, 112, -1, -2, -3 };
	public final static int[] ARRAYDE = new int[]{5,4,3,2,1,0,-1,-2,-3};
	public final static void printArray(int A[]){
		System.out.print("Array: ");
		for (int i : A) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public final static void swap(int a[], int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
}
