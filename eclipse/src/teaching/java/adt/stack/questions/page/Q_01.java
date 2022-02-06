package eclipse.teaching.java.adt.stack.questions.page;

import eclipse.utilities.adt.moe.Stack;

/** Copy of the code in question 1 of 
 * <a href="https://docs.google.com/document/d/1KPUQBaA16m296SG6L7m4-c7B87tDjCuE3OyFcm1E10I/edit#heading=h.yfhw5rz11jzk">this</a> page.
 * @author ?
 */
public class Q_01 {
	
	public static void sectionA() {
		Stack<Character> s1 = new Stack<Character>();
		Stack<Character> s2 = new Stack<Character>(); 
		s1.push('a'); 
		s1.push('b'); 
		s1.push('c'); 
		s1.push('d'); 
		char ch = s1.pop(); 
		s2.push(ch); 
		ch = s2.pop(); 
		s1.push('e');
		
		System.out.println(String.format("Stack 1:\n%s\n", s1.toString()));
		System.out.println(String.format("Stack 2:\n%s\n", s2.toString()));
	}
	
	public static void sectionB() {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>(); 
		s1.push(1); 
		s2.push(2); 
		s1.push(3); 
		s2.push(4); 
		s1 = s2; 
		s1.push(5); 
		s2.push(6);

		System.out.println(String.format("Stack 1:\n%s\n", s1.toString()));
		System.out.println(String.format("Stack 2:\n%s\n", s2.toString()));
	}
}
