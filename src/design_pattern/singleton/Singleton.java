package design_pattern.singleton;

public class Singleton {

	private String name = "lovers";

	private Singleton() {
		System.out.println("Create an Instance");
	}

	// ���쾲̬�ڲ���,����һ��˽�С�final����̬�� ��������
	private static class SingletonHolder {
		private final static Singleton instance = new Singleton();
	}

	// дһ��get���������þ�̬�ڲ��෵�� ��������
	public static Singleton getInstance() {
		return SingletonHolder.instance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}