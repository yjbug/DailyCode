package design_pattern.singleton;

public class Singleton {
	private Singleton() {

	}
	//���쾲̬�ڲ���,����һ��˽�С�final����̬�� ��������
	private static class SingletonHolder {
		private final static Singleton instance = new Singleton();
	}
	//дһ��get���������þ�̬�ڲ��෵�� ��������
	public static Singleton getInstance() {
		return SingletonHolder.instance;
	}
}