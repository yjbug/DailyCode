package classical_algorithm;

import java.util.HashMap;

class Entry {
	Entry prev;// 前一节点
	Entry next;// 后一节点
	Object value;// 值
	Object key;// 键
}

/**
 * Least recently used 算法根据数据的历史访问记录来进行淘汰数据，其核心思想是“如果数据最近被访问过，那么将来被访问的几率也更高”。
 * 使用一个含有头、尾指针的双向链表作为LRU缓存数据，用一个HashMap存储数据实现O(1)查找：
 * 
 * 
 * 【命中率】
 * 
 * 当存在热点数据时，LRU的效率很好，但偶发性的、周期性的批量操作会导致LRU命中率急剧下降，缓存污染情况比较严重。
 * 
 * 【复杂度】
 * 
 * 实现简单。
 * 
 * 【代价】
 * 
 * 命中时需要遍历链表，找到命中的数据块索引，然后需要将数据移到头部。
 */
public class LRUCache {
	private int cacheSize;
	private HashMap<Object, Entry> nodes;// 缓存容器
	private int currentSize;
	private Entry first;// 链表头
	private Entry last;// 链表尾

	public LRUCache(int i) {
		currentSize = 0;
		cacheSize = i;
		nodes = new HashMap<Object, Entry>(i);// 缓存容器
	}

	/**
	 * 获取缓存中对象,并把它放在最前面
	 */
	public Entry get(Object key) {
		Entry node = nodes.get(key);
		if (node != null) {
			moveToHead(node);
			return node;
		} else {
			return null;
		}
	}

	/**
	 * 添加 entry到HashMap, 并把entry
	 */
	public void put(Object key, Object value) {
		// 先查看HashMap是否存在该entry, 如果存在，则只更新其value
		Entry node = nodes.get(key);

		if (node == null) {
			// 缓存容器是否已经超过大小.
			if (currentSize >= cacheSize) {
				// 移除 HashMap 和 LRUCache 中最近最少使用的一个元素
				nodes.remove(last.key);
				removeLast();
			} else {
				currentSize++;
			}
			node = new Entry();
		}
		node.value = value;
		node.key = key;
		// 将最新使用的节点放到链表头，表示最新使用的.
		moveToHead(node);
		nodes.put(key, node);
	}

	/**
	 * 删除链表尾部节点，即使用最后 使用的entry
	 */
	private void removeLast() {
		// 链表尾不为空,则将链表尾指向null. 删除连表尾（删除最少使用的缓存对象）
		if (last != null) {
			if (last.prev != null)
				last.prev.next = first;
			else
				first = null;
			last = last.prev;
		}
	}

	/**
	 * 移动到链表头，表示这个节点是最新使用过的
	 */
	private void moveToHead(Entry node) {
		if (node == first)
			return;
		// remove node
		if (node.prev != null)
			node.prev.next = node.next;
		if (node.next != null)
			node.next.prev = node.prev;
		// reset last
		if (last == node)
			last = node.prev;
		// remove node to first and reset first
		if (first != null) {
			node.next = first;
			first.prev = node;
		}
		first = node;
		node.prev = null;
		if (last == null)
			last = first;
	}

	/*
	 * 清空缓存
	 */
	public void clear() {
		first = null;
		last = null;
		currentSize = 0;
	}
}
