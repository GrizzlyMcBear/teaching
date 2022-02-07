package teaching.java.adt.node.questions.page;
import utilities.adt.moe.*;

/* Write a program which receives a reference to the first node in a node list
 * and an `int` n.
 * Your method should return the amount of times n appears in the list. */
public class Question1 {
	
	public static int solveQuestion(Node<Integer> firstNode, int n) {
		int count = 0;
		Node<Integer> currNode = firstNode;
		
		while (currNode != null) {
			if (currNode.getValue() == n)
				count++;
			
			currNode = currNode.getNext();
		}
		
		return count;
	}
	
	public static void checkSolution() {
		Node<Integer> firstNode = null;
		int number = 1;
		int itemsAmount = Question1.solveQuestion(firstNode, number);
		System.out.println(String.format("In list %s,\nWe have the number %s appear %s times\n",
				firstNode, number, itemsAmount));
		
		firstNode = new Node<Integer>(1);
		number = 1;
		itemsAmount = Question1.solveQuestion(firstNode, number);
		System.out.println(String.format("In list %s,\nWe have the number %s appear %s times\n",
				firstNode.toString(), number, itemsAmount));
		
		firstNode = new Node<Integer>(1);
		number = 2;
		itemsAmount = Question1.solveQuestion(firstNode, number);
		System.out.println(String.format("In list %s,\nWe have the number %s appear %s times\n",
				firstNode.toString(), number, itemsAmount));
		
		firstNode = new Node<Integer>(1, new Node<Integer>(2));
		number = 2;
		itemsAmount = Question1.solveQuestion(firstNode, number);
		System.out.println(String.format("In list %s,\nWe have the number %s appear %s times\n",
				firstNode.toString(), number, itemsAmount));
		
		firstNode = new Node<Integer>(1, new Node<Integer>(2, new Node<Integer>(1)));
		number = 2;
		itemsAmount = Question1.solveQuestion(firstNode, number);
		System.out.println(String.format("In list %s,\nWe have the number %s appear %s times\n",
				firstNode.toString(), number, itemsAmount));
		
		firstNode = new Node<Integer>(1, new Node<Integer>(2, new Node<Integer>(1)));
		number = 1;
		itemsAmount = Question1.solveQuestion(firstNode, number);
		System.out.println(String.format("In list %s,\nWe have the number %s appear %s times\n",
				firstNode.toString(), number, itemsAmount));
	}
}
