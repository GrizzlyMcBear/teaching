package teaching.java.adt.node.questions.page;
import utilities.adt.moe.*;

/**
 * Write a program which would get a list of nodes and a number.
 * then it would calculate the amount of sequences of that number in that list.  
 * @author GrizzlyMcBear
 */
public class Question5 {
	
	
	public static int solveQuestion(Node<Integer> firstNode, int number) {
		int count = 0;
		Node<Integer> currNode, nextNode;
		
		if (firstNode != null) {
			currNode = firstNode;
			
			while (currNode != null) {
				
				if (currNode.getValue() == number) {// The current node's value equals `number`
					count++;
					
					nextNode = currNode.getNext();
					while (nextNode != null && currNode.getValue() == nextNode.getValue()) {
						nextNode = nextNode.getNext();
					}
					currNode = nextNode;
				} else {// The current node's value isn't the desired `number`
					// Show my mistake and ask what happened here:
					// currNode.setNext(currNode.getNext());
					currNode = currNode.getNext();
				}
			}
		}
		
		return count;
	}
	
	public static void checkSolution() {
		Node<Integer> nodeList = null;
		String userMsg;
		int number = 0;
		
		// Empty list
		// ==========
		userMsg = String.format("The number %s appears %s times in the list:\n%s",
				number, solveQuestion(nodeList, number), "-|");
		System.out.println(userMsg);
		
		number = 1;
		userMsg = String.format("The number %s appears %s times in the list:\n%s",
				number, solveQuestion(nodeList, number), "-|");
		System.out.println(userMsg);
		
		// List with 1 item
		// ================
		nodeList = new Node<Integer>(number);
		userMsg = String.format("The number %s appears %s times in the list:\n%s",
				number, solveQuestion(nodeList, number), nodeList.toString());
		System.out.println(userMsg);
		
		number = 2;
		userMsg = String.format("The number %s appears %s times in the list:\n%s",
				number, solveQuestion(nodeList, number), nodeList.toString());
		System.out.println(userMsg);
		
		// List with more than 1 item
		// ==========================
		nodeList.setNext(new Node<Integer>(3));
		userMsg = String.format("The number %s appears %s times in the list:\n%s",
				number, solveQuestion(nodeList, number), nodeList.toString());
		System.out.println(userMsg);
		
		number = 1;
		userMsg = String.format("The number %s appears %s times in the list:\n%s",
				number, solveQuestion(nodeList, number), nodeList.toString());
		System.out.println(userMsg);
		
		// List in question's example
		// ==========================
		
		nodeList = new Node<Integer>(5);
		Node<Integer> currNode = nodeList;
		int[] numbers = { 20, 88, 9, 5, 5, 11, 5, 5, 5, 12 };
		for (int index = 0; index < numbers.length; index++) {
			currNode.setNext(new Node<Integer>(numbers[index]));
			currNode = currNode.getNext();
		}
		number = 5;
		userMsg = String.format("The number %s appears %s times in the list:\n%s",
				number, solveQuestion(nodeList, number), nodeList.toString());
		System.out.println(userMsg);
	}
}
