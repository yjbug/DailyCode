package classical_algorithm;

import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.sun.corba.se.spi.activation.InitialNameServicePackage.NameAlreadyBound;
import com.sun.xml.internal.ws.api.pipe.Fiber;

class EntryModified {
	EntryModified prev;// ǰһ�ڵ�
	EntryModified next;// ��һ�ڵ�
	Object value;// ֵ
	Object key;// ��
	int count;

	public void countAdd() {
		count++;
	}
}

/**
 * �㷨��LRU�����ӳ�һ���������м䣨����ָ��λ�ã��ֳ������֡�
 * 
 * ��һ����Ϊ�ȶˣ��ڶ�����Ϊ��ˡ� �ȶ˼�¼count>=2�Ķ�����˼�¼count>=1�Ķ���
 * 
 * ÿ�����󶼻��з��ʴ���count�� ��˾��������ʵĶ������ӵ��ȶˣ��ȶ˶��󲻷��ʻᱻ��������ˡ�
 * 
 * 1.����¶��󣺻���δ��ʱ�����ȶ˿�ʼ��ӣ�������ʱ���������̭һ��Ԫ�ز�����������Ԫ�ء�
 * 
 * 2.���ʶ�������ͨLRU���𣺲����ƶ�Ԫ�أ�count++�����Ч�ʡ�
 * 
 * 3.��̭�ɶ��� �����ĩβ��ʼ��̭����������count>=2,�򽫶�����ӵ��ȶ���count��0�����ҽ��ȶ˵�һ��Ԫ�ؽ�������˿�ͷ��
 * ������̼�Ϊ3��ָ����ƶ�������Clock�㷨�� ��������count==1���򽫶�����̭������˵�ͷ����������Ԫ�ء�
 * 
 */
public class LRUCacheModified {
	private int cacheSize;
	private HashMap<Object, EntryModified> nodes;// ��������
	private int currentSize;
	private EntryModified hotFirst;// ����ͷ
	private EntryModified coldFirst;// ����β
	private EntryModified coldLast;// ����β
	private int THRESHOLD = 2;

	public LRUCacheModified(int i) {
		currentSize = 0;
		cacheSize = i;
		nodes = new HashMap<Object, EntryModified>(i);// ��������
	}

	/**
	 * ��ȡ�����ж���,�������ķ��ʴ�������
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
	 * ��� EntryModified��HashMap, ����EntryModified
	 */
	public void put(Object key, Object value) {
		// �Ȳ鿴HashMap�Ƿ���ڸ�EntryModified, ������ڣ�������value,count++
		// ��������ڣ��½��ڵ�
		EntryModified node = nodes.get(key);

		if (node == null) {
			// ���������Ƿ��Ѿ�������С.
			node = new EntryModified();
			node.key = key;
			node.value = value;
			node.count = 0;
			if (currentSize >= cacheSize) {
				// �Ƴ� HashMap �� LRUCache ���������ʹ�õ�һ��Ԫ��
				removeLast();
				// ��node��ӵ� coldFirst�����Ҹ���coldFirstλ��
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
					// ��ʼ�� ��˵�ͷ���
					if (currentSize == (cacheSize >> 1)) {
						coldFirst = node;
					}
					if (currentSize == cacheSize) {
						// ����������ʱ������һ����
						coldLast.next = hotFirst;
						hotFirst.prev = coldLast;
					}
				}
			}
		} else {
			node.value = value;
			moveToHead(node);
		}
		// �ڵ���µ�HashMap
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
	 * ɾ������β���ڵ㣬��ʹ����� ʹ�õ�EntryModified
	 */
	private void removeLast() {
		while (coldLast.count >= THRESHOLD) {
			// count��0�����ƶ����ȶ˵�ͷ���
			coldLast.count -= 1;
			coldLast = coldLast.prev;
			coldFirst = coldFirst.prev;
			hotFirst = hotFirst.prev;
		}
		// ��ǰcount<=1, ���Ա���̭
		// ɾ��coldLast�Ľڵ�
		coldLast.prev.next = hotFirst;
		hotFirst = coldLast.prev;
		nodes.remove(coldLast.key);
		coldLast = coldLast.prev;
	}

	/*
	 * ��ջ���
	 */
	public void clear() {
		hotFirst = null;
		coldLast = null;
		currentSize = 0;
	}
}
