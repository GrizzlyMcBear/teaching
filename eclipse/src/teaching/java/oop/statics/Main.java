package teaching.java.oop.statics;

public class Main {

	public static void main(String[] args) {
		System.out.println("Step #1:");
		// Create a new person and print his details
		Person person1 = new Person();
		System.out.println(person1.toString());
		
		// Create a new worker and print his details
		Worker worker2 = new Worker();
		System.out.println(worker2.toString());
		
		// Create a new person with a name, then print his details
		Person person3 = new Person("Someone");
		System.out.println(person3.toString());
		
		// Create a new worker with a name, then print his details
		Worker worker4 = new Worker("Otherone");
		System.out.println(worker4.toString());
		
		// Update amount to all people
		System.out.println("\nUpdating amounts:");
		person1.updateAmount();
		worker2.updateAmount();
		person3.updateAmount();
		worker4.updateAmount();
		
		// Print details by reading the `lastNameCreated` field for both classes (Person and Worker)
		System.out.println("\nPrinting new people:");
		System.out.println(person1.toString());
		System.out.println(worker2.toString());
		System.out.println(person3.toString());
		System.out.println(worker4.toString());
		System.out.println(String.format("Person.lastNameCreated = %s", Person.lastNameCreated));
		System.out.println(String.format("Worker.lastNameCreated = %s", Worker.lastNameCreated));
		
		// Call `staticIncrement` in both classes (Person and Worker)
		System.out.println("\nCalling static increment method:");
		Person.staticIncrement("Last person name");
		System.out.println(person1.toString());
		System.out.println(String.format("Amount: %d, Last name: %s", person1.getAmount(), Person.lastNameCreated));
		Worker.staticIncrement("Last worker name");
		System.out.println(String.format("Amount: %d, Last name: %s", person1.getAmount(), Worker.lastNameCreated));
		System.out.println(String.format("Amount: %d, Last name: %s", person1.getAmount(), Person.lastNameCreated));
		
		// Call `staticIncrementImproved`
		System.out.println("\nCalling improved static increment method:");
		Person.staticIncrementImproved("New last person name", person1);
		System.out.println(person1.toString());
		System.out.println(worker2.toString());
		System.out.println(person3.toString());
		System.out.println(worker4.toString());
	}
}
