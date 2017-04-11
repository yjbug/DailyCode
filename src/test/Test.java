package test;

import java.util.LinkedList;

import tools.Entry;

public class Test {

	public static void main(String[] args) {
		Entry<Integer, Integer> E1 = new Entry<>();
		Entry<Integer, Integer> E2 = new Entry<>();

		E1.key = 1;
		E1.value = 1;
		E1.next = E2;
		E2.key = 1;
		E2.value = 1;
		E2.next = E1;

		// System.out.println(E1.hashCode());
		// System.out.println(E2.hashCode());
		//
		// if(E1.equals(E2)){
		// System.out.println("true");
		// }else{
		// System.out.println("false");
		// }
		//
		// System.out.println(E1);

	}

}
