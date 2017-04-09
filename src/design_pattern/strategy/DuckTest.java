package design_pattern.strategy;

public class DuckTest {

	public static void main(String[] args) {
		// 初始化duck的每个成员变量
		// 在实例化duck的时，确定对应所需要的Fly,Quack属性
		Duck duck = new Duck(new FlyNoWay(),new QuackWithA());
		duck.perporm();
		
		//修改duck的属性
		duck.setFlyBehavior(new FlyWithWings());
		duck.setQuackBehavior(new QuackWithG());
		duck.perporm();
	}

}
