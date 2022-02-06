package eclipse.tests.exams.matriculation.cs.y2009;

import eclipse.utilities.adt.*;
import eclipse.utilities.adt.mine.Utilities;
import eclipse.utilities.adt.moe.Node;

/**
 * @author GrizzlyMcBear
 * 
 * @implNote This class contains the solution for question #1.
 * @implSpec
 * 	<ul>
 * 		<li>The exam questions could be found <a href="http://blog.csit.org.il/UpLoad/FilesUpload/t205_09.pdf">here</a>.</li>
 * 		<li>The MOE topic id is 899205</li>
 * 	</ul>
 *
 */
public class Question1 {
	
	public static boolean isTrinityList(Node<Integer> list) {
		boolean result = false;
		
		if (list != null) {// Only if list isn't empty - continue checking.
			int length = getListLengthRecursive(list);
			
			if (length % 3 == 0) {// Only if list's length divides by 3 without remainder - continue checking.
				
				// Check that nodes in the 1st and 2nd thirds are equal
				Node<Integer> firstThirdNode = list;
				Node<Integer> secondThirdNode = getListNodeByIndex(list, (length / 3) + 1);
				
				if (checkNodesEqual(firstThirdNode, secondThirdNode, length / 3)) {
					
					// Check that nodes in the 1st and 3rd thirds are equal.
					Node<Integer> thirdThirdNode = getListNodeByIndex(list, (length / 3) * 2 + 1);
					if (checkNodesEqual(firstThirdNode, thirdThirdNode, length / 3))
						result = true;
				}
			}
		}
		
		return result;
	}
	
	// Find the length of a list using a loop.
	public static int getListLengthLoop(Node<Integer> list) {
		int length = 0;
		Node<Integer> currNode = list;
		
		while (currNode != null) {
			currNode = currNode.getNext();
			length++;
		}
		
		return length;
	}
	
	// Find the length of a list using a recursive method.
	public static int getListLengthRecursive(Node<Integer> list) {
		int length = 0;
		
		if (list != null)
			length += 1 + getListLengthRecursive(list.getNext());
		
		return length;
	}

	// Return a node in the list at the given index.
	public static Node<Integer> getListNodeByIndex(Node<Integer> list, int index) {
		Node<Integer> result = null;
		int currIndex = 0;
		
		if (list != null && index >= 0) {// If the list isn't empty and the index is positive
			
			result = list;
					
			// Advance along the list's nodes:
			for (currIndex = 1; result != null && currIndex < index; currIndex++) {
				result = result.getNext();
			}
		} 
		
		return result;
	}
	
	public static Node<Integer> getListNodeByIndexWhileLoop(Node<Integer> list, int index) {
		Node<Integer> result = null;
		int currIndex = 0;
		
		if (list != null && index >= 0) {// If the list isn't empty and the index is positive
			
			// Reset values
			result = list;
			currIndex = 1;
			
			// Advance along the list's nodes:
			while (result != null && currIndex < index) {// While not at the end of the list and haven't reached the desired index yet
				
				// Advance to the next node and increment the current index (counter)
				result = result.getNext();
				currIndex++;
			}
		} 
		
		return result;
	}
	
	// Same as method above, only `for` loop is more compact, also we could've used a `while` loop
	public static Node<Integer> getListNodeByIndexCompactForLoop(Node<Integer> list, int index) {
		Node<Integer> result = null;
		int currIndex = 0;
		
		if (list != null && index >= 0) {// If the list isn't empty and the index is positive
			
			// Advance along the list's nodes:
			for (result = list, currIndex = 1; // Reset values
					result != null && currIndex < index; // While not at the end of the list and haven't reached the desired index yet
					result = result.getNext(), currIndex++); // Advance to the next node and increment the current index (counter)
		} 
		
		return result;
	}

	/* Checks if `amount` nodes are equal, comparing between 2 node lists:
	 * `first` and `second`. */
	public static boolean checkNodesEqual(Node<Integer> first, Node<Integer> second, int amount) {
		boolean nodesEqual = true;
		Node<Integer> currFirst;
		Node<Integer> currSecond;
		int checkedNodes;
		
		for (currFirst = first, currSecond = second, checkedNodes = 0;// Initialize variables
				currFirst != null && currSecond != null && checkedNodes < amount && nodesEqual;
				currFirst = currFirst.getNext(), currSecond = currSecond.getNext(), checkedNodes++) {
			nodesEqual = currFirst.getValue().equals(currSecond.getValue());
		}
		
		return nodesEqual;
	}

	// Runs tests to make sure that the solution is correct
	public static void checkSolution() {
		
		// Empty list
		Node<Integer> newList = Utilities.createIntegerNodes(null);
		System.out.println(String.format("The following list is%s a trinity list:\n%s", 
				isTrinityList(newList) ? "" : "n't", "-|"));
		
		// List with 1 item
		newList = Utilities.createIntegerNodes("13");
		System.out.println(String.format("The following list is%s a trinity list:\n%s", 
				isTrinityList(newList) ? "" : "n't", newList.toString()));
		
		// List in question
				newList = Utilities.createIntegerNodes("2, 5, 3, 7, 2, 5, 3, 7, 2, 5, 3, 7");
				System.out.println(String.format("The following list is%s a trinity list:\n%s", 
						isTrinityList(newList) ? "" : "n't", newList.toString()));
	}
}
