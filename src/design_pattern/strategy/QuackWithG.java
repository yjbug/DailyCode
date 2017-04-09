package design_pattern.strategy;

public class QuackWithG implements QuackBehavior {
	 
    @Override
    public void quack() {
        System.out.println("QUACK: G G G G");
    }
}
