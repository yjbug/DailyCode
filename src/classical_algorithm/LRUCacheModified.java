package classical_algorithm;

import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.sun.corba.se.spi.activation.InitialNameServicePackage.NameAlreadyBound;
import com.sun.xml.internal.ws.api.pipe.Fiber;

class EntryModified {
	EntryModified prev;// 前一节点
	EntryModified next;// 后一节点
	Object value;// 值
	Object key;// 键
	int count;

	public void countAdd() {
		count++;
	}
}

/**
 * 算法将LRU链连接成一个环，从中间（或者指定位置）分成两部分。
 * 
 * 第一部分为热端，第二部分为冷端。 热端记录count>=2的对象，冷端记录count>=1的对象。
 * 
 * 每个对象都会有访问次数count。 冷端经常被访问的对象会添加到热端，热端对象不访问会被降级到冷端。
 * 
 * 1.添加新对象：缓存未满时，从热端开始添加；缓存满时，从冷端淘汰一个元素并从冷端添加新元素。
 * 
 * 2.访问对象，与普通LRU区别：不再移动元素，count++，提高效率。
 * 
 * 3.淘汰旧对象： 从冷端末尾开始淘汰，如果对象的count>=2,则将对象添加到热端且count置0，并且将热端的一个元素降级到冷端开头。
 * 这个过程简化为3个指针的移动，类似Clock算法。 如果对象的count==1，则将对象淘汰，在冷端的头结点出插入新元素。
 * 
 */
public class LRUCacheModified {
	private int cacheSize;
	private HashMap<Object, EntryModified> nodes;// 缓存容器
	private int currentSize;
	private EntryModified hotFirst;// 链表头
	private EntryModified coldFirst;// 链表尾
	private EntryModified coldLast;// 链表尾
	private int THRESHOLD = 2;

	public LRUCacheModified(int i) {
		currentSize = 0;
		cacheSize = i;
		nodes = new HashMap<Object, EntryModified>(i);// 缓存容器
	}

	/**
	 * 获取缓存中对象,并把它的访问次数增加
	 */
	public EntryModified get(Object key) {
		EntryModified node = nodes.get(key);
		if (node != null) {
			node.countAdd();
			return node;
		} else {
			return null;
		}
	}

	/**
	 * 添加 EntryModified到HashMap, 并把EntryModified
	 */
	public void put(Object key, Object value) {
		// 先查看HashMap是否存在该EntryModified, 如果存在，更新其value,count++
		// 如果不存在，新建节点
		EntryModified node = nodes.get(key);

		if (node == null) {
			// 缓存容器是否已经超过大小.
			node = new EntryModified();
			node.key = key;
			node.value = value;
			node.count = 0;
			if (currentSize >= cacheSize) {
				// 移除 HashMap 和 LRUCache 中最近最少使用的一个元素
				removeLast();
				// 将node添加到 coldFirst，并且更新coldFirst位置
				addColdFirst(node);
			} else {
				currentSize++;
				if (currentSize == 1) {
					hotFirst = node;
					coldLast = node;
				} else {
					node.prev = coldLast;
					coldLast.next = node;
					coldLast = node;
					// 初始化 冷端的头结点
					if (currentSize == (cacheSize >> 1)) {
						coldFirst = node;
					}
					if (currentSize == cacheSize) {
						// 当缓存器满时，构建一个环
						coldLast.next = hotFirst;
						hotFirst.prev = coldLast;
					}
				}
			}
		} else {
			node.value = value;
			moveToHead(node);
		}
		// 节点更新到HashMap
		node.countAdd();
		nodes.put(key, node);
	}

	private void moveToHead(EntryModified node) {
		if (node == hotFirst)
			return;
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}

		if (hotFirst.prev != null) {
			hotFirst.prev.next = node;
		}

		if (node == coldLast) {
			coldLast = coldLast.prev;
		} else if (node == coldFirst) {
			coldFirst = coldFirst.next;
		} else if (node == hotFirst) {
			return;
		}

		node.next = hotFirst;
		node.prev = hotFirst.prev;
		hotFirst.prev = node;
		hotFirst = node;
	}

	private void addColdFirst(EntryModified node) {
		coldFirst.prev.next = node;
		node.next = coldFirst;
		node.prev = coldFirst.prev;
		coldFirst.prev = node;
		coldFirst = node;
	}

	/**
	 * 删除链表尾部节点，即使用最后 使用的EntryModified
	 */
	private void removeLast() {
		while (coldLast.count >= THRESHOLD) {
			// count置0，且移动到热端的头结点
			coldLast.count -= 1;
			coldLast = coldLast.prev;
			coldFirst = coldFirst.prev;
			hotFirst = hotFirst.prev;
		}
		// 当前count<=1, 可以被淘汰
		// 删除coldLast的节点
		coldLast.prev.next = hotFirst;
		hotFirst = coldLast.prev;
		nodes.remove(coldLast.key);
		coldLast = coldLast.prev;
	}

	/*
	 * 清空缓存
	 */
	public void clear() {
		hotFirst = null;
		coldLast = null;
		currentSize = 0;
	}
}
