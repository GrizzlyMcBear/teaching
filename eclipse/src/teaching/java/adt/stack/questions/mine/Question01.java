package eclipse.teaching.java.adt.stack.questions.mine;

import java.util.Scanner;

import eclipse.utilities.adt.moe.Stack;

public class Question01 {

	/**
	 * @author Ronen Cohen
	 * @implNote This method reads a user input text (line), reverses it and then
	 * prints it using `syso`. It implements the solution for the question located
	 * <a href="https://docs.google.com/document/d/1KPUQBaA16m296SG6L7m4-c7B87tDjCuE3OyFcm1E10I/edit#heading=h.7guyxwi9mwei">here.</a>
	 */
	public static void readAndReverseLine() {
		Stack<Character> reversingStack = new Stack<Character>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a string to revert:");

		String userInput = scanner.nextLine();
		for (int inputIndex = 0; inputIndex < userInput.length(); inputIndex++) {
			reversingStack.push(new Character(userInput.charAt(inputIndex)));
		}
		
		String reversedInput = "";
		while (!reversingStack.isEmpty()) {
			reversedInput = reversedInput.concat(reversingStack.pop().toString());
		}

		System.out.println(String.format("Input before mirroring: %s", userInput));
		System.out.println(String.format("Input after mirroring: %s", reversedInput));
	}
}
