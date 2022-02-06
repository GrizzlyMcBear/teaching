package eclipse.tests.exams.matriculation.cs.y2015;

import eclipse.utilities.adt.moe.BinTreeNode;

/**
 * This class is a suggested solution for question 1 in the 2015 summer matriculation.
 * @author Ronen Cohen
 */
public class Question1 {

	public static void checkSolution() {
		testTree1();
		testTree2();
		testTree3();
	}
	/**
	 * This is the required solution for the question (sub-section B).
	 * @param tree
	 * @return
	 */
	private static boolean treeValue(BinTreeNode<String> tree) {
		if (tree.getValue().equals("T"))
			return true;
		if (tree.getValue().equals("F"))
			return false;
		
		if (tree.getValue().equals("AND"))
			return treeValue(tree.getLeft()) && treeValue(tree.getRight());
		
		return treeValue(tree.getLeft()) || treeValue(tree.getRight());
	}
	/**
	 * This is the improved solution for the question.
	 * @implSpec This solution contains expansion to handle the following cases:</br>
	 * 	<ul>
	 * 		<li>Multiple values for leafs</br>
	 * 			The `true` value could be represented by several strings such as: "T", "t", "True", "TRUE", "true".</br>
	 * 			And could be expanded.</li>
	 * 		<li>A tree node could be any of the following boolean operators:</br>
	 * 			<ul>
	 * 				<li><b>AND: </b>the binary `and` operator.</li>
	 * 				<li><b>OR: </b>the binary `or` operator.</li>
	 * 				<li><b>XOR: </b>the binary `xor` operator.</li>
	 * 				<li><b>NOT: </b>the unary `not` operator.</li>
	 * 			</ul>
	 * 		</li>
	 * 	</ul>
	 * @param tree
	 * @return
	 */
	private static boolean treeValueImproved(BinTreeNode<String> tree) {
		/* Tree can't be null: not checking this edge case. */
		if (!tree.hasLeft() && !tree.hasRight())
			return leafValue(tree);
		
		if (isAndOp(tree.getValue()))
			return treeValueImproved(tree.getLeft()) && treeValueImproved(tree.getRight());
		else if (isOrOp(tree.getValue()))
			return treeValueImproved(tree.getLeft()) || treeValueImproved(tree.getRight());
		else if (isXorOp(tree.getValue()))
			return treeValueImproved(tree.getLeft()) ^ treeValueImproved(tree.getRight());
		else if (isNotOp(tree.getValue())) {
			if (tree.getLeft() == null)
				return treeValueImproved(tree.getRight());
			else
				return treeValueImproved(tree.getLeft());
		} else
			return false;
	}
	
	/* Helper method: the following logic can be greatly simplified. */
	private static boolean leafValue(BinTreeNode<String> leaf) {
		if (leaf.getValue().equals("T") || leaf.getValue().equals("t") ||
				leaf.getValue().equals("True") || leaf.getValue().equals("TRUE") ||
				leaf.getValue().equals("true"))
			return true;
		else
			return false;
	}
	private static boolean isAndOp(String value) {
		return (value.equals("AND") || value.equals("and") || value.equals("And") || value.equals("&&"));
	}
	private static boolean isOrOp(String value) {
		return (value.equals("OR") || value.equals("or") || value.equals("Or") || value.equals("||"));
	}
	private static boolean isXorOp(String value) {
		return (value.equals("XOR") || value.equals("xor") || value.equals("Xor") || value.equals("^"));
	}
	private static boolean isNotOp(String value) {
		return (value.equals("NOT") || value.equals("not") || value.equals("Not") || value.equals("!"));
	}
	private static void testTree1() {
		BinTreeNode<String> tree = buildTree1();
		System.out.println(String.format("testTree1:"));
		System.out.println(tree.toString());
		System.out.println(String.format("Tree represents: %b\n", treeValueImproved(tree)));
	}
	private static BinTreeNode<String> buildTree1() {
		BinTreeNode<String> result = new BinTreeNode<String>("AND");
		
		BinTreeNode<String> leftChild = new BinTreeNode<String>("AND");
		leftChild.setLeft(new BinTreeNode<String>("F"));
		leftChild.setRight(new BinTreeNode<String>("T"));
		
		result.setRight(new BinTreeNode<String>("T"));
		result.setLeft(leftChild);
		
		return result;
	}
	private static void testTree2() {
		BinTreeNode<String> tree = buildTree2();
		System.out.println(String.format("testTree2:"));
		System.out.println(tree.toString());
		System.out.println(String.format("Tree represents: %b\n", treeValueImproved(tree)));
	}
	private static BinTreeNode<String> buildTree2() {
		BinTreeNode<String> result = new BinTreeNode<String>("OR");
		
		BinTreeNode<String> leftChild = new BinTreeNode<String>("AND");
		leftChild.setLeft(new BinTreeNode<String>("T"));
		leftChild.setRight(new BinTreeNode<String>("F"));
		
		BinTreeNode<String> rightChild = new BinTreeNode<String>("OR");
		rightChild.setLeft(new BinTreeNode<String>("F"));
		rightChild.setRight(new BinTreeNode<String>("T"));
		
		result.setLeft(leftChild);
		result.setRight(rightChild);
		
		return result;
	}
	private static void testTree3() {
		BinTreeNode<String> tree = buildTree3();
		System.out.println(String.format("testTree2:"));
		System.out.println(tree.toString());
		System.out.println(String.format("Tree represents: %b\n", treeValueImproved(tree)));
	}
	private static BinTreeNode<String> buildTree3() {
		BinTreeNode<String> result = new BinTreeNode<String>("OR");
		
		BinTreeNode<String> leftChild = new BinTreeNode<String>("AND");
		leftChild.setLeft(new BinTreeNode<String>("F"));
		leftChild.setRight(new BinTreeNode<String>("T"));
		result.setLeft(leftChild);
		
		BinTreeNode<String> rightChild = new BinTreeNode<String>("AND");
		rightChild.setRight(new BinTreeNode<String>("T"));
		BinTreeNode<String> rightChildChild = new BinTreeNode<String>("AND");
		rightChildChild.setLeft(new BinTreeNode<String>("T"));
		rightChildChild.setRight(new BinTreeNode<String>("T"));
		rightChild.setLeft(rightChildChild);
		result.setRight(rightChild);
		
		return result;
	}
}
