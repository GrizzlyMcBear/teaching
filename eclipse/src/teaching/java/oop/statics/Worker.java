package teaching.java.oop.statics;

public class Worker extends Person {

	private int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Worker() {
		this("");
	}
	
	public Worker(String name) {
		super(name);
	}
	
//	@Override
//	protected void instanceIncrement2(String name) {
//		lastNameCreated = name;
//		updateAmount();
//	}
	
	protected static void staticIncrement(String name) {
		/* Question #1: what type of errors each line would generate (when we remove the comments)? */
//		amount++;
//		lastNameCreated = name;
//		privateLastNameCreated = name;
	}
	
	@Override
	public String toString() {
		return String.format("%s, salary: %d", super.toString(), getSalary());
	}
}
