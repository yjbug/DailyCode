package classical_algorithm;

import java.util.Stack;
import tools.Node;
// ���ڽӱ����ʽ�洢ͼ�ڵ�
// DFS
// parameter:  �ڵ�����   ��ǰ���ʽڵ������    ���ʱ�ʶ����     ��ǰһ�����ʽڵ��������
// 1. �жϵ�ǰ�ڵ��Ƿ���ʹ����ǵĻ����˳�
// 2. ���õ�ǰ�ڵ�ķ���ΪTRUE�� ���з��ʲ���
// 3. ��ȡ��ǰ�ڵ��������һ���ڵ㣬  ˳������� �����һ���ڵ�δ�����ʣ��ݹ����DFS 
// 4. ���ڻ����ж��� ����ͼ - ��һ���ڵ����������ʹ�
//             ����ͼ - ��һ���ڵ����������ʹ����Ҹ���һ���ڵ㲻��ǰһ�����ʽڵ�

// �������� ��DFS����ʱ�����ǰ�ڵ��ֵ

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

	// ����ͼ�ı������ж��Ƿ��л�
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
					System.out.println("����������ڻ�");
				curNode = curNode.next;
			}
		}
	}

	// ����ͼ�������ж��Ƿ��л�
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
						System.out.println("����������ڻ�");
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
