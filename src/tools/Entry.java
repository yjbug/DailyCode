package tools;

public class Entry<Key,Value> {
	public Entry<Key,Value> prev;// 前一节点
	public Entry<Key,Value> next;// 后一节点
	public Key key;// 键
	public Value value;// 值
}