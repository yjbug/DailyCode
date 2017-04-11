package classical_algorithm;

import java.util.Stack;
import tools.Node;
// 以邻接表的形式存储图节点
// DFS
// parameter:  节点数组   当前访问节点的索引    访问标识数组     （前一个访问节点的索引）
// 1. 判断当前节点是否访问过，是的话就退出
// 2. 设置当前节点的访问为TRUE， 进行访问操作
// 3. 获取当前节点的所有下一跳节点，  顺序遍历： 如果下一跳节点未被访问，递归调用DFS 
// 4. 关于环的判定： 有向图 - 下一跳节点曾经被访问过
//             无向图 - 下一跳节点曾经被访问过，且该下一跳节点不是前一个访问节点

// 拓扑排序： 在DFS结束时输出当前节点的值

public class DepthFirstSearch {

	public static void main(String[] args) {
		DepthFirstSearch T = new DepthFirstSearch();
		T.graphWithOrientation(Node.NODES);
		System.out.println("==========");
		T.graphWithoutOrientation(Node.NODES2);
		System.out.println("==========");
		T.topoSort(Node.NODES);
	}

	public void graphWithOrientation(Node[] nodes) {
		int len = nodes.length;
		boolean visited[] = new boolean[len];
		for (int i = 0; i < len; i++) {
			depthFirstSearch(nodes, i, visited);
		}
	}

	@SuppressWarnings("rawtypes")
	public void graphWithoutOrientation(Node[] nodes) {
		int len = nodes.length;
		boolean visited[] = new boolean[len];
		for (int i = 0; i < len; i++) {
			depthFirstSearch(nodes, i, visited, -1);
		}
	}

	// 有向图的遍历，判断是否有环
	@SuppressWarnings("rawtypes")
	private void depthFirstSearch(Node[] nodes, int cur, boolean visited[]) {
		if (!visited[cur]) {
			visited[cur] = true;
			System.out.println("visited " + cur);
			Node<Integer> curNode = nodes[cur].next;
			while (curNode != null) {
				if (visited[curNode.value] == false)
					depthFirstSearch(nodes, curNode.value, visited);
				else
					System.out.println("有向链表存在环");
				curNode = curNode.next;
			}
		}
	}

	// 无向图遍历，判断是否有环
	@SuppressWarnings("rawtypes")
	private void depthFirstSearch(Node[] nodes, int cur, boolean visited[], int pre) {
		if (!visited[cur]) {
			visited[cur] = true;
			System.out.println("visited " + cur);
			Node<Integer> curNode = nodes[cur].next;
			while (curNode != null) {
				if (visited[curNode.value] == false) {
					depthFirstSearch(nodes, curNode.value, visited, cur);
				} else {
					if (curNode.value != pre)
						System.out.println("无向链表存在环");
				}
				curNode = curNode.next;
			}
		}
	}

	public void topoSort(Node[] nodes) {
		boolean visited[] = new boolean[nodes.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				dfs(nodes, i, visited, stack);
			}
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	public void dfs(Node[] nodes, int i, boolean visited[], Stack<Integer> stack) {
		if (!visited[i]) {
			visited[i] = true;
			Node<Integer> curNode = nodes[i].next;
			while (curNode != null) {
				if (!visited[curNode.value]) {
					dfs(nodes, curNode.value, visited, stack);
				}
				curNode = curNode.next;
			}
			stack.push(i);
		}
	}

}
