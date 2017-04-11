package tools;

public class Node<T> {
	public T value;
	public Node<T> next;

	public Node() {

	}

	public Node(T value) {
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	public final static Node<Integer> NODES[] = new Node[6];
	public final static Node<Integer> NODES2[] = new Node[6];
	static {
		for (int i = 0; i < NODES.length; i++) {
			NODES[i] = new Node<Integer>();
			NODES[i].value = i;
			NODES2[i] = new Node<Integer>();
			NODES2[i].value = i;
		}
		NODES[0].next = new Node<>(1);
		NODES[1].next = new Node<>(2);
		NODES[1].next.next = new Node<>(3);
		NODES[2].next = new Node<>(4);
		NODES[3].next = new Node<>(4);

		NODES2[0].next = new Node<>(1);
		NODES2[1].next = new Node<>(0);
		NODES2[1].next.next = new Node<>(2);
		NODES2[1].next.next.next = new Node<>(3);
		NODES2[2].next = new Node<>(1);
		NODES2[2].next.next = new Node<>(4);
		NODES2[3].next = new Node<>(1);
		NODES2[3].next.next = new Node<>(4);
		NODES2[4].next = new Node<>(2);
		NODES2[4].next.next = new Node<>(3);
	}

}
