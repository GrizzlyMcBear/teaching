package teaching.java.oop.statics;

/**
 * A class representing a person for the purpose of showing the difference between
 * static/non-static field/method
 * @author Grizzly McBear
 */
public class Person {

	/** 
	 * A public field 
	 */
	public int amount;
	
	/**
	 * A (public) static field, this field belongs to the class {@link Person}
	 */
	public static String lastNameCreated;
	
	/**
	 * A (private) static field.
	 */
	private static String privateLastNameCreated;
	
	/**
	 * Default c'tor with no arguments.
	 */
	public Person() {
		this("");
	}
	
	/**
	 * C'tor with 1 argument.
	 * @param name The name of the person.
	 */
	public Person(String name) {
		super();
		staticIncrement(name);
	}
	
	/**
	 * This is a static (class-level method), inside it we can only access static variables.
	 * @param name
	 * @implNote If we try to access an object's field from this method - 
	 * is wouldn't know which object we mean.
	 */
	protected static void staticIncrement(String name) {
		//amount++;
		lastNameCreated = name;
		privateLastNameCreated = name;
	}
	
	/**
	 * This is a static method (somewhat similar to {@link Person#staticIncrement(String)}),
	 * only this method gets a {@link Person} object as an argument so it could be updated.
	 * @param name The name of the person.
	 * @param object The object we wish to update its {@link Person#amount} instance (non-static) field.
	 */
	protected static void staticIncrementImproved(String name, Person object) {
		lastNameCreated = name;
		object.updateAmount();
	}
	
	/**
	 * An instance (non-static) method for updating data.
	 * @implNote This method updates several values:</br>
	 * 	<ol>
	 * 		<li><b>lastNameCreated: </b>a static (class-level) field.</li>
	 * 		<li><b>amount: </b>an instance (non-static, object-level) field,</br>
	 * 		it does so by calling {@link Person#updateAmount()}.</li>
	 * 	</ol>
	 * @param name
	 */
	protected void instanceIncrement(String name) {
		lastNameCreated = name;
		updateAmount();
	}
	
	/**
	 * An instance method which updates the {@link Person#amount} field.
	 */
	protected void updateAmount() {
		amount++;
	}
	
	public int getAmount() {
		return amount;
	}
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("Person - name: %s, Amount: %d, Last name (static): %s", 
				getName(), getAmount(), lastNameCreated);
	}
}
