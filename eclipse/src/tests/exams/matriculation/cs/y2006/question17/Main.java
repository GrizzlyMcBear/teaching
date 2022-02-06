package eclipse.tests.exams.matriculation.cs.y2006.question17;

public class Main {

	public static void main(String[] args) {
		MultiOne container = new MultiOne();
		SingleOne s1 = new SingleOne(11, 35);
		container.add(s1);
		s1 = new SingleOne(47, 22);
		container.add(s1);
		s1 = new SingleOne (8, 17);
		container.add(s1);
		MultiOne subContainer = new MultiOne();
		s1 = new SingleOne(53, 40);
		subContainer.add(s1);
		s1 = new SingleOne(21, 13);
		subContainer.add(s1);
		s1 = new SingleOne(39, 62);
		subContainer.add(s1);
		container.add(subContainer);
		container.print();
	}
}
