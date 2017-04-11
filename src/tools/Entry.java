package tools;

public class Entry<Key, Value> {
	public Entry<Key, Value> prev;// 前一节点
	public Entry<Key, Value> next;// 后一节点
	public Key key;// 键
	public Value value;// 值

	// 尝试一下hashCode 和 equals
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int hash = 7;
		hash = hash * 31 + key.hashCode();
		hash = hash * 31 + value.hashCode();

		// 当遇到环时，会陷入死循环
		// if (prev != null) {
		// hash = hash * 31 + prev.hashCode();
		// }
		// if (next != null) {
		// hash = hash * 31 + next.hashCode();
		// }
		// hash值只要尽可能的不相同即可，因此
		// 只考虑下一跳和前一跳的元素值
		if (prev != null) {
			hash = hash * 31 + prev.key.hashCode();
			hash = hash * 31 + prev.value.hashCode();
		}
		if (next != null) {
			hash = hash * 31 + next.key.hashCode();
			hash = hash * 31 + next.value.hashCode();
		}
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Entry)) {
			return false;
		}
		
		@SuppressWarnings("unchecked")
		Entry<Key, Value> temp = (Entry<Key, Value>) obj;
		if (!key.equals(temp.key))
			return false;
		if (!value.equals(temp.value))
			return false;
		if (prev == null && temp.prev != null)
			return false;
		if (next == null && temp.next != null)
			return false;
		
		// 这个也会陷入死循环, 该问题相当于图相等的判断
		// 显然Entry这种类型的数据不适合拿来当key使用，后续的 图相等判断也就不继续写
//		if (prev != null && !(prev.equals(temp.prev)))
//			return false;
//		if (next != null && !(next.equals(temp.next)))
//			return false;
		return true;
	}
}