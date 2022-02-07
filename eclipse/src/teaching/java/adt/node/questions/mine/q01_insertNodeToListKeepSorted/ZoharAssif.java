package teaching.java.adt.node.questions.mine.q01_insertNodeToListKeepSorted;

import java.util.Scanner;
import utilities.adt.moe.Node;

public class ZoharAssif {

		public static <T> Node<Integer> insertNode(Node<Integer> nodes, Scanner s) {
			
			int temp = 0;
			
			if (nodes == null) {
				System.out.println("create new node list");
				temp = s.nextInt();
				nodes = new Node<Integer>(temp);
				return nodes;
			} else if(nodes.getNext() == null) {
				System.out.println("create one node");
				temp = s.nextInt();
				Node<Integer> first;
				Node<Integer> tempN = new Node<Integer>(temp);
				
				if (nodes.getValue() >= tempN.getValue()) {
					tempN.setNext(nodes);
					first = tempN;
				} else {
					nodes.setNext(tempN);
					first = nodes;
				}
				
				return first;
			} else if(nodes.getNext() != null) {
				return hasMoreThanOneNode(nodes, temp, s);
			}
			
			return nodes;
		}
		
		public static <T> Node<Integer> hasMoreThanOneNode(Node<Integer> nodes, int temp, Scanner s) {
			
			System.out.println("create new nodes when u wanna stop press -1");
			temp = s.nextInt();
			Node<Integer> first = nodes;
			Node<Integer> tempN = new Node<Integer>(temp);
			
			while(temp != -1) {
				nodes = first;
				tempN = new Node<Integer>(temp);
				
				while (nodes != null) {
					
					if(nodes.getNext() != null && tempN.getValue() >= nodes.getNext().getValue()) {
						tempN.setNext(nodes.getNext());
						nodes.setNext(tempN);
						break;
					} else if (nodes.getNext() == null) {
						nodes.setNext(tempN);
						break;
					} else {
						nodes = nodes.getNext();
					}
				}
				
				temp = s.nextInt();
			}
			
			return first;
		}
}