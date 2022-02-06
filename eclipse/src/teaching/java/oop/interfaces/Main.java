package eclipse.teaching.java.oop.interfaces;

public class Main {
	public static void main(String[] args) {
		
		INursable[] nursables = createNursables();
		Animal[] animals = createAnimals();
		
		System.out.println("Printing nursables:");
		System.out.println("===================");
		printItems(nursables);
		System.out.println();
		System.out.println("Printing animals:");
		System.out.println("=================");
		printItems(animals);
	}
	
	private static void printItems(Object[] items) {
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null)
				System.out.println(items[i].toString());
		}
	}
	
	private static INursable[] createNursables() {
		INursable[] result = new INursable[3];

		result[0] = new Cat("Tom");
		result[1] = new Platypus("Perry");
		
		return result;
	}

	private static Animal[] createAnimals() {
		Animal[] result = new Animal[3];
		
		result[0] = new Cat("Tom");
		result[1] = new Platypus("Perry");
		result[2] = new Chicken("Bigbird");
		
		return result;
	}
}