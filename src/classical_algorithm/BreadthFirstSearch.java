package classical_algorithm;

import java.util.LinkedList;
import java.util.Queue;

import tools.Node;

// BFS  不需要递归，用队列实现   Queue q = new LinkedList()
// 1. parameter: 节点数组   ， 队列， 访问标识数组
// 2. size为0，加入一个未访问的节点， 且访问标识设置TRUE
// 3. size不为0时， poll当前队首节点 ， 获取所有下一跳节点
// 4. 顺序处理下一跳节点，如果未被访问，则加入q并且访问标识设置TRUE

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
