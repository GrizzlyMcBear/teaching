package eclipse.tests.exams.matriculation.cs.y2014;

import eclipse.utilities.adt.moe.BinTreeNode;

/**
 * @author Ronen Cohen
 * 
 * @implNote This class contains the solution for question #1.
 * @implSpec
 * 	<ul>
 * 		<li>The exam questions could be found <a href="http://blog.csit.org.il/UpLoad/FilesUpload/t205_14.pdf">here</a>.</li>
 * 		<li>The exam solutions could be found <a href="http://blog.csit.org.il/UpLoad/FilesUpload/pitaron_205_2014.pdf">here</a>.</li>
 * 		<li>The MOE topic id is 899205</li>
 * 	</ul>
 *
 */
public class Question1 {

	public static void main(String[] args) {
		testTree(buildTree1());
		testTree(buildTree2());
		testTree(buildTree3());
	}
	
	private static void testTree(BinTreeNode<Integer> tree) {
		System.out.println("Test tree:");
		System.out.println("==========");
		System.out.println(String.format("The tree:\n%s\n", tree.toString()));
		System.out.println(String.format("Balance status is: %b", isBalanced(tree)));
	}
	private static BinTreeNode<Integer> buildTree1() {
		return new BinTreeNode<Integer>(5);
	}
	private static BinTreeNode<Integer> buildTree2() {
		BinTreeNode<Integer> result = new BinTreeNode<Integer>(5);
		BinTreeNode<Integer> node2 = new BinTreeNode<Integer>(2);
		result.setLeft(node2);
		
		BinTreeNode<Integer> node3 = new BinTreeNode<Integer>(3);
		node2.setRight(node3);
		
		BinTreeNode<Integer> node1 = new BinTreeNode<Integer>(1);
		node2.setLeft(node1);
		
		return result;
	}
	private static BinTreeNode<Integer> buildTree3() {
		BinTreeNode<Integer> root = new BinTreeNode<Integer>(3);
		
		BinTreeNode<Integer> node2 = new BinTreeNode<Integer>(2);
		root.setLeft(node2);
		BinTreeNode<Integer> node1 = new BinTreeNode<Integer>(1);
		node2.setLeft(node1);
		
		BinTreeNode<Integer> node4 = new BinTreeNode<Integer>(4);
		root.setRight(node4);
		BinTreeNode<Integer> node6 = new BinTreeNode<Integer>(6);
		node4.setRight(node6);
		BinTreeNode<Integer> node5 = new BinTreeNode<Integer>(5);
		node6.setLeft(node5);
		
		return root;
	}
	
	private static <T> boolean isBalanced(BinTreeNode<T> tree) {
		/* If this binary tree node is null - the tree is balanced. */
		if (tree == null) 
			return true;
		
		/* If the difference in depths of the left and right children is greater than 1 -
		 * the current binary tree (`tree`) isn't balanced. */
		if (Math.abs(getDepth(tree.getLeft()) - getDepth(tree.getRight())) > 1)
			return false;
		
		/* Whether this tree is/isn't balanced would be determined now
		 * by the balance of its children. */
		return isBalanced(tree.getLeft()) && isBalanced(tree.getRight());
	}
	
	private static <T> int getDepth(BinTreeNode<T> tree) {
		/* If this binary tree node is null - we assume its depth is -1
		 * 
		 * Note: if we name this method `getHeight` we could return 0,
		 * this is just semantics. */
		if (tree == null) 
			return -1;
		
		/* The depth of this binary tree node is the maximum depth of its children plus 1. */
		return 1 + Math.max(getDepth(tree.getLeft()), getDepth(tree.getRight()));
	}
	
	private static <T> boolean isBalancedDetailed(BinTreeNode<T> tree) {
		if (tree == null) return true;
		
		int leftChildDepth = getDepth(tree.getLeft());
		int rightChildDepth = getDepth(tree.getRight());
		int childrenDepthDiff = Math.abs(leftChildDepth - rightChildDepth);
		
		if (childrenDepthDiff > 1)
			return false;
		
		return isBalanced(tree.getLeft()) && isBalanced(tree.getRight());
	}
	
	private static <T> int getDepthDetailed(BinTreeNode<T> tree) {
		if (tree == null)
			return -1;
		
		int childrenDepth = Math.max(getDepth(tree.getLeft()), getDepth(tree.getRight()));
		return childrenDepth + 1;
	}
}
