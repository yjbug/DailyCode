package design_pattern.strategy;

/**
 * �̳еĺô�:�ù�ͬ����,���Ը���.�����ظ����.
 * �̳еĲ���:����Ը�.һ���������һ���·���,���඼�̳�,ӵ�д˷���,�������൱���ֲ�ʵ�ִ˷���,��Ҫ���д������޸�.�̳�ʱ,����Ͳ��ɼ̳���������.
 * �ӿڵĺô�:����˼̳�����Ըߵ�����.�ҿ���ʵ����,�̳л�ʵ���������ӿ�. �ӿڵĲ���:��������ʵ�ִ���ĸ���.
 *
 */
public class Duck {
	private FlyBehavior flyBehavior;// �ӿ�
	private QuackBehavior quackBehavior;// �ӿ�
	// flyBehavior ��quackBehavior ��ʵ����д�ڽӿڶ�Ӧ������
	// ʹ�ü̳������ô��롣�����䶯�ĵط���ʹ�ýӿڶ�����Ϊ��Ա�������ӿڵ�ʵ����д�ڽӿڵ����ࡣ

	public Duck(FlyBehavior f, QuackBehavior q) {
		flyBehavior = f;
		quackBehavior = q;
	}

//	public Duck() {
//		// all member variables need to be initialize
//	};

	public void swimming() {
		System.out.println("duck swimming in water");
	}

	public void perporm() {
		System.out.println("===duck perform start===");
		swimming();
		flyBehavior.fly();
		quackBehavior.quack();
		System.out.println("===duck perform end  ===");
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
}