package classical_algorithm;

import java.util.LinkedList;
import java.util.Queue;

import tools.Node;

// BFS  ����Ҫ�ݹ飬�ö���ʵ��   Queue q = new LinkedList()
// 1. parameter: �ڵ�����   �� ���У� ���ʱ�ʶ����
// 2. sizeΪ0������һ��δ���ʵĽڵ㣬 �ҷ��ʱ�ʶ����TRUE
// 3. size��Ϊ0ʱ�� poll��ǰ���׽ڵ� �� ��ȡ������һ���ڵ�
// 4. ˳������һ���ڵ㣬���δ�����ʣ������q���ҷ��ʱ�ʶ����TRUE

public class BreadthFirstSearch {

	public static void main(String[] args) {
		BreadthFirstSearch T = new BreadthFirstSearch();
		T.bfs(Node.NODES);
		System.out.println();
		System.out.println("==============");
		T.bfs(Node.NODES2);
	}

	public void bfs(Node[] nodes) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[nodes.length];

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				q.add(i);
				visited[i] = true;
				while (q.size() != 0) {
					Node<Integer> temp = nodes[q.poll()];
					System.out.print(temp.value+" ");
					temp = temp.next;
					while(temp!=null){
						if(!visited[temp.value]){
							q.add(temp.value);
							visited[temp.value] = true;
						}
						temp = temp.next;
					}
				}
			}
		}
	}

}
