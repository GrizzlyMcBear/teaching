package teaching.java.loops.foreach;

public class Main {

	private static final int NUMBERS_AMOUNT = 10;
	
	public static void main(String[] args) {
//		example1();
		example2();
	}
	
	private static void example1() {
		int[] numbers = new int[NUMBERS_AMOUNT];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (i+1) * 2;
		}
		
		for (int number : numbers) {
			System.out.println(String.format("Curr multiplication of 2 is: %d", number));
		}
	}
	
	private static void example2() {
		String[] words = new String[] { "teaching", "java", "loops", "foreach" };
		
		for (String currWord : words) {
			System.out.println(String.format("Curr part of package name: %s", currWord));
		}
	}
}
