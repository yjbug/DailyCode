package design_pattern.singleton;

public class SingletonTest {

	public static void main(String[] args) {
		Singleton F = null;
		System.out.println("�����࣬û�д�������");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Singleton T = Singleton.getInstance();
		System.out.println(T.getName());
		T.setName("CHANGE");
		Singleton E = Singleton.getInstance();
		System.out.println(E.getName());
	}
}
