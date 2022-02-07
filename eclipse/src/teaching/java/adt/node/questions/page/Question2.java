package teaching.java.adt.node.questions.page;
import utilities.adt.moe.*;
public class Question2 {
	
	/**
	 * @implSpec Write a program which gets the first node and a name (type String),
	 * this program would return how many times does that name appear in the list.
	 * @param firstNode The first node in a Node list (each node contains a String).
	 */
	public static int solveQuestion(Node<String> firstNode, String name) {
		int count = 0;
		Node<String> currNode = firstNode;
		
		while (currNode != null) {
			if (currNode.getValue().equals(name))
				count++;
			
			currNode = currNode.getNext();
		}
		
		return count;
	}
	
	public static void checkSolution() {
		Node<String> firstNode = null;
		String name = "Moses";
		int itemsAmount = Question2.solveQuestion(firstNode, name);
		System.out.println(String.format("In list %s,\nWe have the name %s appear %s times\n",
				firstNode, name, itemsAmount));
		
		firstNode = new Node<String>("Moses");
		name = "Moses";
		itemsAmount = Question2.solveQuestion(firstNode, name);
		System.out.println(String.format("In list %s,\nWe have the name %s appear %s times\n",
				firstNode.toString(), name, itemsAmount));
		
		firstNode = new Node<String>("Moses");
		name = "Dan";
		itemsAmount = Question2.solveQuestion(firstNode, name);
		System.out.println(String.format("In list %s,\nWe have the name %s appear %s times\n",
				firstNode.toString(), name, itemsAmount));
		
		firstNode = new Node<String>("Dan", new Node<String>("Moses"));
		name = "Moses";
		itemsAmount = Question2.solveQuestion(firstNode, name);
		System.out.println(String.format("In list %s,\nWe have the name %s appear %s times\n",
				firstNode.toString(), name, itemsAmount));
		
		firstNode = new Node<String>("Dan", new Node<String>("Sara", new Node<String>("Mike")));
		name = "Sara";
		itemsAmount = Question2.solveQuestion(firstNode, name);
		System.out.println(String.format("In list %s,\nWe have the name %s appear %s times\n",
				firstNode.toString(), name, itemsAmount));
		
		firstNode = new Node<String>("Sara", new Node<String>("Mike", new Node<String>("Sara")));
		name = "Sara";
		itemsAmount = Question2.solveQuestion(firstNode, name);
		System.out.println(String.format("In list %s,\nWe have the name %s appear %s times\n",
				firstNode.toString(), name, itemsAmount));
	}
}
