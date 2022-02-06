package eclipse.teaching.java.adt.node.questions.mine.q01_insertNodeToListKeepSorted;

import java.util.Scanner;

import eclipse.utilities.adt.moe.Node;

/** 
 * @author GrizzlyMcBear
 *
 * @implNote This class contains an application which asks the user for numbers
 * 	(ending with -999) and after reading each number - insert it into a nodes list
 * 	in a sorted (increasing) manner. The question is available <a href="https://docs.google.com/document/d/1hMfG4rxyvFmFHduFg7tV-f6-lkRAnrF-wpqH656X_gk/edit#heading=h.ehqhuwcfgk0n">here</a>
 */
public class Question {
	
	public static Node<Integer> insertNodeAndKeepListSorted(Node<Integer> firstNode, int numToInsert) {
		
		/* Categorize by situation (when inserting a new node):
		 * 1.	Empty list to begin with.
		 * 2.	Insert new node before first node.
		 * 3.1. Insert new node between 2 existing nodes.
		 * 3.2.	Insert new node after last node. 
		 * */
		
		if (firstNode == null) {// The list is empty
			// Insert the new node as the first (and only) node.
			firstNode = new Node<Integer>(numToInsert);
		} else if (numToInsert < firstNode.getValue()) {// We should insert the node as the first node
			Node<Integer> tempNode = firstNode;
			firstNode = new Node<Integer>(numToInsert, tempNode);
			// Question: could we write it shorter?
		} else {// We should insert the node between `prevNode` and `nextNode`
			Node<Integer> prevNode = firstNode;
			Node<Integer> nextNode = prevNode.getNext();

			// Find `prevNode` and `nextNode` so that the new node should be inserted between both of them
			while (nextNode != null && nextNode.getValue() <= numToInsert) {
				prevNode = nextNode;
				nextNode = nextNode.getNext();
			}

			// Insert the new node
			prevNode.setNext(new Node<Integer>(numToInsert, nextNode));
		}
		
		return firstNode;
	}
	
	public static Node<Integer> removeNodeFromList(Node<Integer> firstNode, Node<Integer> nodeToRemove) {
		// TODO: Finish implementing this method.
		return firstNode;
	}
	
	public static void checkSolution() {
		Scanner scanner = new Scanner(System.in);
		Node<Integer> numbersList = null;
		
		System.out.println("Please enter numbers to be sorted while inserted into a Nodes list\n" +
				"to exit the program enter -999");
		for (int currNum = scanner.nextInt(); currNum != -999; currNum = scanner.nextInt()) {
			numbersList = insertNodeAndKeepListSorted(numbersList, currNum);
			System.out.println("Current list is:");
			System.out.println(numbersList);
		}
		
		System.out.println("\nThe final list is:");
		System.out.println(numbersList);
	}
}
