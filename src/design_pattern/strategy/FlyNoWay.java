package design_pattern.strategy;

public class FlyNoWay implements FlyBehavior {
	 
    @Override
    public void fly() {
        System.out.println("This duck can't fly");
    }
}
