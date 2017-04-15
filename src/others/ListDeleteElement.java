package others;

import java.util.ArrayList;
import java.util.LinkedList;

import tools.Entry;

public class ListDeleteElement {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		
		// list.remove(2);  //this is error
		list.remove(new Integer(2));
		System.out.println(list.size());

	}

}
