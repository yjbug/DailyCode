package tools;

public class Entry<Key, Value> {
	public Entry<Key, Value> prev;// ǰһ�ڵ�
	public Entry<Key, Value> next;// ��һ�ڵ�
	public Key key;// ��
	public Value value;// ֵ

	// ����һ��hashCode �� equals
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int hash = 7;
		hash = hash * 31 + key.hashCode();
		hash = hash * 31 + value.hashCode();

		// ��������ʱ����������ѭ��
		// if (prev != null) {
		// hash = hash * 31 + prev.hashCode();
		// }
		// if (next != null) {
		// hash = hash * 31 + next.hashCode();
		// }
		// hashֵֻҪ�����ܵĲ���ͬ���ɣ����
		// ֻ������һ����ǰһ����Ԫ��ֵ
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
		
		// ���Ҳ��������ѭ��, �������൱��ͼ��ȵ��ж�
		// ��ȻEntry�������͵����ݲ��ʺ�������keyʹ�ã������� ͼ����ж�Ҳ�Ͳ�����д
//		if (prev != null && !(prev.equals(temp.prev)))
//			return false;
//		if (next != null && !(next.equals(temp.next)))
//			return false;
		return true;
	}
}