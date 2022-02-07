package teaching.java.adt.stack.questions.page;

import utilities.adt.moe.Queue;

/** Copy of the code of 
 * <a href="https://docs.google.com/document/d/1KPUQBaA16m296SG6L7m4-c7B87tDjCuE3OyFcm1E10I/edit#heading=h.kod1jfkevzg2">this question</a>.
 * @author ?
 */
public class Q_02 {
	
	public static void sectionA() {
		Queue<Integer> q1 = new Queue<Integer>();
		Queue<Integer> q2 = new Queue<Integer>();
		
		q1.insert(32);
		q1.insert(-6);
		q2.insert(q1.head());
		q1.insert(q1.remove() + q1.remove());
		
		if (q1.isEmpty())
			q1.insert(9);
		else
			q2.insert(17);
	}
	
	public static void sectionB() {
		Queue<String> q1 = new Queue<String>();
		Queue<String> q2 = new Queue<String>();
		
		q1.insert("Hello");
		q1.insert("World");
		q2.insert(q1.remove());
		q2.insert(q1.head());
		q1.remove();
		q1.insert("Hello" + q2.head());
	}
}
