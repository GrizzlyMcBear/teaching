package eclipse.tests.exams.matriculation.cs.y2006.question17;

public class SingleOne extends Basis {
	protected int num2;
	
	public SingleOne(int n1, int n2) {
		super(n1);
		this.num2 = n2;
	}
	
	public void print() {
		super.print();
		System.out.println(this.num2);
	}
}