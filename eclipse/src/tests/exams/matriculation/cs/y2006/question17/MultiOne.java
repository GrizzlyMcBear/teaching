package eclipse.tests.exams.matriculation.cs.y2006.question17;

public class MultiOne extends Basis {
	
	private int count = 0;
	
	private Basis[] arr;
	
	public MultiOne() {
		this.arr = new Basis[5];
	}
	
	public void print() {
		for (int i = 0; i < count; i++)
			arr[i].print();
	}
	
	public void add(Basis b) {
		arr[count] = b;
		count++;
	}
}