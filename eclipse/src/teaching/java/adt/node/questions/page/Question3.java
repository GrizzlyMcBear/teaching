package teaching.java.adt.node.questions.page;
import utilities.adt.moe.*;

public class Question3 {
	
	/**
	 * @implSpec Write a program which gets the first node to a list of Integer items,
	 * the program would return the amount of even numbers in the list.
	 * @param firstNode Is the first node in a list of nodes (each contains an Integer).
	 * @return The amount of even numbers in the list.
	 */
	public static int solveQuestion(Node<Integer> firstNode) {
		int count = 0;
		
		Node<Integer> currNode = firstNode;
		
		while (currNode != null) {
			if (currNode.getValue() % 2 == 0)
				count++;
			
			currNode = currNode.getNext();
		}
		
		return count;
	}
	
	public static void checkSolution() {
		Node<Integer> firstNode = null;
		int itemsAmount = Question3.solveQuestion(firstNode);
		System.out.println(String.format("In list %s,\nWe have %s even numbers\n",
				firstNode, itemsAmount));
		
		firstNode = new Node<Integer>(0);
		itemsAmount = Question3.solveQuestion(firstNode);
		System.out.println(String.format("In list %s,\nWe have %s even numbers\n",
				firstNode.toString(), itemsAmount));
		
		firstNode = new Node<Integer>(1);
		itemsAmount = Question3.solveQuestion(firstNode);
		System.out.println(String.format("In list %s,\nWe have %s even numbers\n",
				firstNode.toString(), itemsAmount));
		
		firstNode = new Node<Integer>(1, new Node<Integer>(2));
		itemsAmount = Question3.solveQuestion(firstNode);
		System.out.println(String.format("In list %s,\nWe have %s even numbers\n",
				firstNode.toString(), itemsAmount));
		
		firstNode = new Node<Integer>(2, new Node<Integer>(1, new Node<Integer>(0)));
		itemsAmount = Question3.solveQuestion(firstNode);
		System.out.println(String.format("In list %s,\nWe have %s even numbers\n",
				firstNode.toString(), itemsAmount));
		
		firstNode = new Node<Integer>(1, new Node<Integer>(-2, new Node<Integer>(3)));
		itemsAmount = Question3.solveQuestion(firstNode);
		System.out.println(String.format("In list %s,\nWe have %s even numbers\n",
				firstNode.toString(), itemsAmount));
	}
}
