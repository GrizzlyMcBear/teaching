package eclipse.teaching.java.oop.interfaces;

public class Chicken extends Animal implements ILayable {

	public Chicken(String name) {
		super(name);
	}
	
	@Override
	public void layEgg(String offspringName) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void procreate() {
		layEgg("Chickpea");
	}
}