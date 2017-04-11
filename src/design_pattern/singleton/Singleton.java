package design_pattern.singleton;

public class Singleton {

	private String name = "lovers";

	private Singleton() {
		System.out.println("Create an Instance");
	}

	// 构造静态内部内,包含一个私有、final、静态的 单例对象
	private static class SingletonHolder {
		private final static Singleton instance = new Singleton();
	}

	// 写一个get方法，调用静态内部类返回 单例对象
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