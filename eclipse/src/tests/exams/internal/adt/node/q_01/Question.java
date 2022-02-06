package eclipse.tests.exams.internal.adt.node.q_01;

import eclipse.utilities.adt.mine.Utilities;
import eclipse.utilities.adt.moe.Node;

/**
 * 
 * @author GrizzlyMcBear
 * 
 * @implNote This class contains my solution for 
 * <a href="https://docs.google.com/document/d/18H1zezsieuzGekiTb2MMEHNzYeYYYzbr4AKQZFc_o9Q/edit#heading=h.355112zdd0q2">this question</a>
 *
 */
public class Question {

	/**
	 * @implSpec This is part 1 of the question.
	 * 
	 * @param pos
	 * @return
	 */
	public static Node<Character> zip1(Node<Character> pos) {
		
		// 1st thing we do - declare the returned value and add a `return` statement at the end.
		Node<Character> zippedNodes = null;
		
		// If the nodes list is empty, no need to do any work.
		if (pos != null) {
			Node<Character> lastZippedNodes = zippedNodes;
			Node<Character> currSeqNode = pos;
			Node<Character> firstSeqNode;
			Node<Character> newNode;
			
			// Loop until we reach the end of the nodes list.
			while (currSeqNode != null) {
				
				/*	1. Set the `firstSeqNode` to the new (and different valued) `currSeqNode`
				 *	2. Advance `currSeqNode` to its next node */
				for (firstSeqNode = currSeqNode, currSeqNode = currSeqNode.getNext(); 
						/*	Loop while
						 * 1. We haven't reached the end of the nodes list
						 * 2. `firstSeqNode` is equal to `currSeqNode` */
						currSeqNode != null && firstSeqNode.getValue().equals(currSeqNode.getValue()); 
						/*	Advance:
						 * 	1. Set `currSeqNode` to its next node. */
						currSeqNode = currSeqNode.getNext());
				
				/* At this point the only situation is one of the following:
				 * 1. `currSeqNode` has reached the end of the nodes list (i.e. null)
				 * 2. `currSeqNode` has a value different than `firstSeqNode`
				 * 
				 * Either way the only thing we should do is add a new node with the value in `firstSeqNode`
				 * into the end of the `zippedNodes` */
				
				newNode = new Node<Character>(new Character(firstSeqNode.getValue()));
				
				if (zippedNodes == null) {
					zippedNodes = newNode;
					lastZippedNodes = zippedNodes;
				} else {
					lastZippedNodes.setNext(newNode);
					lastZippedNodes = lastZippedNodes.getNext();
				}
			}
		}
		
		return zippedNodes;
	}
	
	/**
	 * @author Zohar Assif
	 * 
	 * @implSpec This function returns a zipped node list from the given one (as an argument)
	 * @param node
	 * @return
	 */
	private static Node<Character> zip2(Node<Character> node) {
		Node<Character> result = null;
		Node<Character> first = result;
		
		if (node != null) {// Check and continue only if the list isn't empty
			
			/* Notice the difference between the two code lines:
			 * 1. (former):		result = new Node<Character>(node.getValue());
			 * 2. (current):	result = new Node<Character>(new Character(node.getValue()));
			 */
			result = new Node<Character>(new Character(node.getValue()));
			
			first = result;
			Node<Character> nextNode;
			
			// Go over nodes while haven't reached the end of the list
			while (node != null) {
				
				nextNode = node.getNext();// helper variable
				
				// while haven't reached the end of the list
				// and the current node's value isn't the same as the next node's value
				if (node.getNext() != null && node.getValue() != nextNode.getValue()) {
					
					// Create a new node with the same value as the next
					Node<Character> nextNodeCopy = new Node<Character>(new Character(nextNode.getValue()));
					
					// Add the new (and different node) to the result
					result.setNext(nextNodeCopy);
					
					// Advance to the next node in the result
					result = result.getNext();
				}
				
				// Continue to the next node to check if should be zipped
				node = node.getNext();
			}
		}
		
		/* Issue was this line was:
		 * return result;
		 * 
		 * The `result` var contains the last added node, while `first` contains the
		 * 1st node in the zipped list.
		 */
		return first;
	}
	
	/**
	 * @author Elad Krasanti
	 * @param pos
	 * @return
	 */
	public static Node<Character> zip(Node<Character> pos) {
		// Handle the case where the list is empty
		Node<Character> result = null;

		if (pos != null) {
			Node<Character> first = pos;
			Node<Character> check;

			// Start by adding a new node to the result nodes list
			result = new Node<Character>(new Character((char)first.getValue()));
			Node<Character> currResNode = result;

			/* Go over nodes while:
			 * 1. Haven't reached the end of the nodes list
			 * 2. The nodes are equal  
			 */
			for (check = first.getNext();
					check != null && first.getValue().equals(check.getValue());
					check = check.getNext());

			/* When reaching here there are only 2 options:
			 * 1. Reached the end of the nodes list
			 * 2. There's a new node to insert into `result`
			 */
			if (check == null) {
				// Previous code was:
				currResNode.setNext(check);
			} else {
				currResNode.setNext(new Node<Character>(check.getValue()));
			}

			/* Solution seems nice but missing a loop -
			 * what seems to happen is that we only zip the first 2 nodes. */
		}

		return result;
	}
	
	/**
	 * Check the solution for this question's 1st part. 
	 */
	private static void checkSolution1() {
		Node<Character> nodes;
		
		nodes = Utilities.createCharacterNodes(null);
		System.out.println(String.format("Initial list:\n%s\nZipped list:\n%s\n", nodes, zip(nodes)));
		
		nodes = Utilities.createCharacterNodes("");
		System.out.println(String.format("Initial list:\n%s\nZipped list:\n%s\n", nodes, zip(nodes)));
		
		nodes = Utilities.createCharacterNodes("aaaowwqqqqpp");
		System.out.println(String.format("Initial list:\n%s\nZipped list:\n%s\n", nodes, zip(nodes)));
		
		nodes = Utilities.createCharacterNodes("a");
		System.out.println(String.format("Initial list:\n%s\nZipped list:\n%s\n", nodes, zip(nodes)));
		
		nodes = Utilities.createCharacterNodes("aaabaabbbabcccca");
		System.out.println(String.format("Initial list:\n%s\nZipped list:\n%s\n", nodes, zip(nodes)));
	}
	
	/**
	 * @author Ronen Cohen
	 * 
	 * @param pos
	 * @return
	 */
	private static Node<Character> archive(Node<Series> pos) {
		// 1st thing we do - declare the `sequence` and return it for the basic edge case.
		Node<Character> sequence = null,
				currCharNode = sequence;
		
		// In case `pos` contains at least 1 node insert new nodes into `sequence` by parsing the data in `pos`.
		if (pos != null) {
			
			/* Go over every node in `pos`
			 ****************************/
			
			// Initialize variables
			Node<Series> currSeriesNode = pos;
			
			
			// Continue while haven't reached the last `Series` node
			while (currSeriesNode != null) {
				
				/* Parse each `Series` node into the desired `Character` nodes
				 ************************************************************/
				Series currSeries = currSeriesNode.getValue();
				for (int currDup = 0; currDup < currSeries.getDuplication(); currDup++) {
					if (sequence == null) {
						sequence = new Node<Character>(new Character(currSeries.getTav()));
						currCharNode = sequence;
					} else {
						currCharNode.setNext(new Node<Character>(new Character(currSeries.getTav())));
						currCharNode = currCharNode.getNext();
					}
				}
				
				// Advance to the next `Series` node
				currSeriesNode = currSeriesNode.getNext();
			}
		}
		
		return sequence;
	}
	
	/**
	 * Check the solution for this question's 2nd part. 
	 */
	private static void checkSolution2() {
		Node<Series> series;
		
		series = Series.createSeriesNodes(null);
		System.out.println(String.format("Series:\n%s\nArchived:\n%s", series, archive(series)));
		
		series = Series.createSeriesNodes("");
		System.out.println(String.format("Series:\n%s\nArchived:\n%s", series, archive(series)));
		
		series = Series.createSeriesNodes("3.m,2.a,4.x,2.p,1.y");
		System.out.println(String.format("Series:\n%s\nArchived:\n%s", series, archive(series)));
	}
	
	public static void checkSolution() {
		checkSolution1();
//		checkSolution2();
	}
}
