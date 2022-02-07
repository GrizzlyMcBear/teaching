package teaching.java.oop.interfaces;

import java.time.Duration;

public class Platypus extends Animal implements INursable, ILayable {

	public Platypus(String name) {
		super(name);
	}
	
	@Override
	public void layEgg(String offspringName) {
		// TODO Auto-generated method stub
	}

	@Override
	public Duration nursingDuration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void procreate() {
		layEgg(String.format("%s Junior", getName()));
		nursingDuration();
	}
	
	@Override
	public String toString() {
		return String.format("Platypus: name - %s", getName());
	}
}