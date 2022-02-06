package eclipse.teaching.java.adt.node.questions.mine.q02_sortNodeList;
import eclipse.utilities.adt.moe.Node;

/** TBD: implement this class and its methods. */
public class Q02_sortNodeList {
	
	public static Node<Integer> bubbleSortNodeList(Node<Integer> firstNode) {
		
		/* We make sure these aren't the most naive cases:
		 * 1. The list is empty
		 * 2. The list contains only 1 node.
		 */
		if (firstNode != null && firstNode.getNext() != null) {
			Node<Integer> lastNode = null;
			
			// Sort all nodes starting from `firstNode` until (not including) `lastNode`
			while (firstNode.getNext() != lastNode) {
				Node<Integer> currNode = firstNode;
				Node<Integer> nextNode = currNode.getNext();
				Node<Integer> helpNode;
				
				while (nextNode != null) {
					if (currNode.getValue() > nextNode.getValue()) {
						helpNode = currNode;
						currNode.setNext(nextNode);
						
					}
				}
			}
		}
		
		return firstNode;
	}
	
	public static void checkSolution() {
	}
	
}