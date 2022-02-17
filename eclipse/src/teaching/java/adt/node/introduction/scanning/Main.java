package teaching.java.adt.node.introduction.scanning;

import java.util.ArrayList;
import java.util.Arrays;

import utilities.adt.moe.Node;
import utilities.adt.node.NodeUtilities;

public class Main {

	public static void main(String[] args) {
		ArrayList<Node<Integer>> lists = createLists();
//		testIterativeSolution(lists);
		testRecursiveSolution(lists);
	}
	
	private static ArrayList<Node<Integer>> createLists() {
		ArrayList<Node<Integer>> lists = new ArrayList<Node<Integer>>();
		
		lists.add(null);
		lists.add(NodeUtilities.createNodes(""));
		lists.add(NodeUtilities.createNodes("1"));
		lists.add(NodeUtilities.createNodes("1,2"));
		lists.add(NodeUtilities.createNodes("1,2,3"));
		lists.add(NodeUtilities.createNodes("1,2,3,4,5,6,7,8,9"));
		
		return lists;
	}
	
	private static void testIterativeSolution(ArrayList<Node<Integer>> lists) {
		System.out.println("Printing the linked lists iteratively:");
		System.out.println("======================================");
		for (Node<Integer> list : lists) {
			System.out.println(String.format("List: %s", list));
			printNodesIteratively(list);
			System.out.println("\n");
		}
	}
	
	private static void printNodesIteratively(Node<Integer> nodes) {
		while (nodes != null) {
			System.out.print(String.format("%d, ", nodes.getValue()));
			nodes = nodes.getNext();
		}
		
		return;
	}
	
	private static void testRecursiveSolution(ArrayList<Node<Integer>> lists) {
		System.out.println("Printing the linked lists recursively:");
		System.out.println("======================================");
		for (Node<Integer> list : lists) {
			System.out.println(String.format("List: %s", list));
			printNodesRecursively(list);
			System.out.println("\n");
		}
	}
	
	private static void printNodesRecursively(Node<Integer> node) {
		if (node == null) {
			System.out.print(" -| ");
			return;
		}
		
		// Question 1: what would happen if I wouldn't call `toString()` after `node.getValue()`?
		String value = node.getValue() == null ? "null" : node.getValue().toString();
		System.out.print(String.format("[ %s ] -> ", value));
		
		printNodesRecursively(node.getNext());
	}
}