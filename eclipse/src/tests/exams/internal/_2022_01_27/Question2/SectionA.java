package tests.exams.internal._2022_01_27.Question2;

import java.util.Arrays;

import utilities.adt.moe.BinTreeNode;

public class SectionA {

	public static void main(String[] args) {
		testSubSectionA();
	}
	
	private static BinTreeNode<Integer> buildTree() {
		BinTreeNode<Integer> l4n1 = new BinTreeNode<Integer>(4);
		BinTreeNode<Integer> l4n2 = new BinTreeNode<Integer>(7);
		BinTreeNode<Integer> l4n3 = new BinTreeNode<Integer>(9);
		
		BinTreeNode<Integer> l3n1 = new BinTreeNode<Integer>(1);
		BinTreeNode<Integer> l3n2 = new BinTreeNode<Integer>(null, 3, l4n1);
		BinTreeNode<Integer> l3n3 = new BinTreeNode<Integer>(null, 6, l4n2);
		BinTreeNode<Integer> l3n4 = new BinTreeNode<Integer>(l4n3, 10, null);
		
		BinTreeNode<Integer> l2n1 = new BinTreeNode<Integer>(l3n1, 2, l3n2);
		BinTreeNode<Integer> l2n2 = new BinTreeNode<Integer>(l3n3, 8, l3n4);
		
		BinTreeNode<Integer> l1n1 = new BinTreeNode<Integer>(l2n1, 5, l2n2);
		
		return l1n1;
	}
	
	private static void testSubSectionA() {
		BinTreeNode<Integer> tree = buildTree();
		int[] numsArray = new int[15];
		
		System.out.println(Arrays.toString(numsArray));
		doSomething(0, tree, numsArray);
		System.out.println(Arrays.toString(numsArray));
	}
	
	public static void doSomething(int a, BinTreeNode<Integer> b, int[] c) {
		c[a] = b.getValue();	
		if (b.hasLeft())
			doSomething(a * 2 + 1, b.getLeft(), c);	
		if (b.hasRight())
			doSomething(a * 2 + 2, b.getRight(), c);
	}
}
