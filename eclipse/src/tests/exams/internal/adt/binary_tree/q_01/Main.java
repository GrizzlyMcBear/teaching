package eclipse.tests.exams.internal.adt.binary_tree.q_01;

import java.util.Arrays;

import utilities.adt.moe.BinTreeNode;

/**
 * This is the code for <a href="https://docs.google.com/document/d/1T9Uy2Wc5nHX4jKjNv2Nmm21BpTn4fpjbVnUmVFDMiZs/edit#heading=h.lwzuwiwfmmsq">this question</a>
 * which scans (reads) a binary tree and inserts its items into an array. 
 * @author Ronen Cohen
 * @implNote When an item in the tree is placed in the array at index p,</br>
 * 	<ul>
 * 		<li>Its <b>left child</b> would be located at index <i>2*p+1</i></li>
 * 		<li>Its <b>right child</b> would be located at index <i>2*p+2</i></li>
 * 	</ul>
 */
public class Main {
	public static void main(String[] args) {
		runProgram();
	}
	
	public static void runProgram() {
		BinTreeNode<Integer> tree = buildTree();
		System.out.println(String.format("This is the tree:\n%s", tree.toString()));
		
		int[] array = new int[getSomething(tree)];
		doSomething(0, tree, array);
		System.out.println(String.format("This is the array:\n%s", Arrays.toString(array)));
	}
	
	public static BinTreeNode<Integer> buildTree() {
		
		BinTreeNode<Integer> level2child1 = new BinTreeNode<Integer>(2);
		BinTreeNode<Integer> level2child2 = new BinTreeNode<Integer>(8);
		BinTreeNode<Integer> root = new BinTreeNode<Integer>(level2child1, 5, level2child2);
		
		BinTreeNode<Integer> level3child1 = new BinTreeNode<Integer>(1);
		BinTreeNode<Integer> level3child2 = new BinTreeNode<Integer>(3);
		level2child1.setLeft(level3child1);
		level2child1.setRight(level3child2);
		BinTreeNode<Integer> level3child3 = new BinTreeNode<Integer>(6);
		BinTreeNode<Integer> level3child4 = new BinTreeNode<Integer>(10);
		level2child2.setLeft(level3child3);
		level2child2.setRight(level3child4);
		
		BinTreeNode<Integer> level4child1 = new BinTreeNode<Integer>(4);
		level3child2.setRight(level4child1);
		BinTreeNode<Integer> level4child2 = new BinTreeNode<Integer>(7);
		level3child3.setRight(level4child2);
		BinTreeNode<Integer> level4child3 = new BinTreeNode<Integer>(9);
		level3child4.setLeft(level4child3);
		
		return root;
	}

	public static int getSomething(BinTreeNode<Integer> root) {
		return 15;
	}
	
	public static void doSomething(int a, BinTreeNode<Integer> b, int[] c) {
		c[a] = b.getValue();
		
		if (b.hasLeft())
			doSomething(a * 2 + 1, b.getLeft(), c);
		
		if (b.hasRight())
			doSomething(a * 2 + 2, b.getRight(), c);
	}
}
