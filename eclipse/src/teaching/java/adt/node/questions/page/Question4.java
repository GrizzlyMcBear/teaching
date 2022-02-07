package teaching.java.adt.node.questions.page;
import java.util.Random;
import utilities.adt.moe.*;

public class Question4 {
	
	/**
	 * This method returns the length of the given list.
	 * @param firstNode is the first node in a list.
	 * @return the length of the list
	 */
	public static int solveQuestion(Node<Integer> firstNode) {
		int length;
		Node<Integer> currNode;
		
		for (length = 0, currNode = firstNode; 
				currNode != null; 
				length++, currNode = currNode.getNext());
		
		return length;
	}
	
	public static void checkSolution() {
		Node<Integer> firstNode = null;
		Node<Integer> currNode;
		int listLength;
		
		
		// List length is 0:
		// =================
		
		String userMsg = String.format("An empty list has a length of %s\nPrinting list: %s\n", 
				solveQuestion(firstNode), "-|");
		System.out.println(userMsg);
		
		
		// List length is 1 or longer:
		// ===========================
		
		// Initialization
		listLength = 1;
		firstNode = new Node<Integer>(listLength);
		currNode = firstNode;
		
		while (listLength < 5) {
			
			userMsg = String.format("List with length of %s has a calculated length of %s\nPrinting list: %s\n", 
					listLength, solveQuestion(firstNode), firstNode.toString());
			System.out.println(userMsg);
			
			// Advancing step
			listLength++;
			currNode.setNext(new Node<Integer>(listLength));
			currNode = currNode.getNext();
		}
		
		// We could've write this using a `for` loop, but it would have been less readable.
	}
}
