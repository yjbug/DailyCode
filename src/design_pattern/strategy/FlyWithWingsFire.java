package design_pattern.strategy;

public class FlyWithWingsFire extends FlyWithWings {
	public void fly() {
		System.out.println("fly with fire");
	}
	public void error(){
		System.out.println("touch here");
	}
	
	public static void main(String[] args) {
		FlyWithWings T1 = new FlyWithWings();
		T1.fly();
		FlyWithWingsFire T2 = new FlyWithWingsFire();
		T2.fly();
		FlyWithWings T3 = new FlyWithWingsFire();
		T3.fly();
		
		// T3 doesn't have method error()
	
	}
}
