package eclipse.teaching.java.oop.interfaces;

public class Animal {
	
	private String name;

	public Animal() {
		this("N/A");
	}
	
	public Animal(String name) {
		super();
		setName(name);
	}
	
	public String getName() {
		String result = "N/A";
		
		if (name != null && !name.equals(""))
			result = name;
		
		return result;
	}

	public void setName(String name) {
		if (name != null && !name.equals(""))
			this.name = name;
	}
	
	public void procreate() {
		System.out.println("Undefined for a generic animal!");
	}
	
	@Override
	public String toString() {
		return String.format("Animal: name - %s", getName());
	}
}