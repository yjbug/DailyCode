package design_pattern.strategy;

public class DuckTest {

	public static void main(String[] args) {
		// ��ʼ��duck��ÿ����Ա����
		// ��ʵ����duck��ʱ��ȷ����Ӧ����Ҫ��Fly,Quack����
		Duck duck = new Duck(new FlyNoWay(),new QuackWithA());
		duck.perporm();
		
		//�޸�duck������
		duck.setFlyBehavior(new FlyWithWings());
		duck.setQuackBehavior(new QuackWithG());
		duck.perporm();
	}

}
