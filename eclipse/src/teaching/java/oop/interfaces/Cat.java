package eclipse.teaching.java.oop.interfaces;

import java.time.Duration;

public class Cat extends Animal implements INursable {

	public Cat(String name) {
		super(name);
	}
	
	@Override
	public Duration nursingDuration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void procreate() {
		nursingDuration();
	}
}