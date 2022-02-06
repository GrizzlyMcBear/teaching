package eclipse.tests.exams.matriculation.cs.y2012;

import java.text.Format;

import utilities.adt.moe.BinTreeNode;
import utilities.adt.moe.Stack;

/**
 * This is my solution for question 2 in <a href="http://blog.csit.org.il/UpLoad/FilesUpload/t205_12.pdf">this</a> exam.
 * @author Ronen Cohen
 */
public class Question2 {
	
	public static void main(String[] args) {
		testQuestion();
	}
	
	public static void testQuestion() {
		BinTreeNode<Stack<Integer>> tree = buildTree();
		System.out.println(tree.toString());
		
		Stack<Integer> minifiedData = scanTree(tree);
		System.out.println(String.format("The minified tree's data is:\n%s", minifiedData.toString()));
	}
	
	private static BinTreeNode<Stack<Integer>> buildTree() {
		Stack<Integer> currNodeStack = new Stack<Integer>();
		currNodeStack.push(7);
		currNodeStack.push(9);
		currNodeStack.push(4);
		currNodeStack.push(8);
		BinTreeNode<Stack<Integer>> result = new BinTreeNode<Stack<Integer>>(currNodeStack);
		
		currNodeStack = new Stack<Integer>();
		currNodeStack.push(2);
		currNodeStack.push(1);
		currNodeStack.push(8);
		currNodeStack.push(1);
		result.setRight(new BinTreeNode<Stack<Integer>>(currNodeStack));
		
		BinTreeNode<Stack<Integer>> currNode = result.getRight();
		currNodeStack = new Stack<Integer>();
		currNodeStack.push(1);
		currNodeStack.push(3);
		currNode.setLeft(new BinTreeNode<Stack<Integer>>(currNodeStack));
		
		currNodeStack = new Stack<Integer>();
		currNode.setRight(new BinTreeNode<Stack<Integer>>(currNodeStack));
		
		currNode = currNode.getRight();
		currNodeStack = new Stack<Integer>();
		currNodeStack.push(1);
		currNodeStack.push(4);
		currNodeStack.push(9);
		currNodeStack.push(2);
		currNode.setLeft(new BinTreeNode<Stack<Integer>>(currNodeStack));
		
		return result;
	}
	
	/**
	 * This method implements basic logic required from us -</br>
	 * to extract a number from the stack of integers inside each node in the given tree.
	 * @implNote This method sums the topmost items stored in the current node's stack,</br>
	 * it uses the following logic, determined by the amount of items stored in the stack:</br>
	 * 	<ul>
	 * 		<li><b>Empty stack: </b>returns 0</li>
	 * 		<li><b>Stack has 1 item: </b>returns the item.</li>
	 * 		<li><b>Stack has 2 items: </b>returns the sum of the 2 items.</li>
	 * 		<li><b>Stack has 3 items or more: </b>returns the sum of the topmost 3 items.</li>
	 * 	</ul>
	 * @author Ronen Cohen
	 * @author Maayan Fadida
	 * @param nodeStack
	 * @param result
	 */
	private static void processNode(Stack<Integer> nodeStack, Stack<Integer> result) {
		Integer topItemsSum = 0;
		
		for (int i = 0; i < 3 && !nodeStack.isEmpty(); i++) 
			topItemsSum += nodeStack.pop();
		
		result.push(topItemsSum);
	}
	
	/**
	 * This method recursively scans (In-Order) a sub-tree inside the given tree</br>
	 * and extracts an integer from each of its nodes.
	 * @implNote This method sums the topmost items from each node in the given tree (argument `node`),</br>
	 * it does so using an <b>in-order</b> scan of the tree and uses the {@link #processNode(Stack, Stack)} method.
	 * @param node
	 * @param result
	 */
	private static void scanSubTree(BinTreeNode<Stack<Integer>> node, Stack<Integer> result) {
		
		// 1. Recursively sum nodes in the left sub-tree (if exist)
		if (node.hasLeft())
			scanSubTree(node.getLeft(), result);
		
		// 2. Sum the topmost (up to 3) items
		processNode(node.getValue(), result);
		
		// 3. Recursively sum nodes in the right sub-tree 
		if (node.hasRight())
			scanSubTree(node.getRight(), result);
	}
	
	/**
	 * This method sums (up to 3 of) the highest values stored in each of the tree's nodes -
	 * each node contains a stack with Integers (could be empty).
	 * @implNote This method scans the tree using in-order logic and does so by calling the {@link #scanSubTree(BinTreeNode, Stack)}
	 * @param root
	 * @return
	 */
	private static Stack<Integer> scanTree(BinTreeNode<Stack<Integer>> root) {
		/* In this solution we create an empty stack before calling the recursive method -
		 * this way we'll be able to return and update it easily. */
		Stack<Integer> result = new Stack<Integer>();
		
		// Not validating input because question stated the input is valid (tree isn't empty)
		scanSubTree(root, result);
		
		return result;
	}
}