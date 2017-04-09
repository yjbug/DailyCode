package design_pattern.strategy;

public class QuackWithA implements QuackBehavior {
	 
    @Override
    public void quack() {
        System.out.println("QUACK: A A A A");
    }
}
