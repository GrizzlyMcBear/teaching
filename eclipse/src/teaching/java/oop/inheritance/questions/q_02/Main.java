package teaching.java.oop.inheritance.questions.q_02;

/**
 * This is the entry point for the solution of the 1st question of
 * <a href="https://86d98cb5-ca6b-4f81-9ecd-6350645ed93b.filesusr.com/ugd/0535b1_c73d41b9a455420f9a7f93a66b3d2085.pptx?dn=01-%20inheritance.pptx">this</a>
 * power-point presentation (slide 36). 
 * @author Grizzly McBear
 */
public class Main {
	
	public static void main(String[] args) {
		Cat myCat = new Cat("Kitty", 5, "Pink");
		StreetCat myStreetCat = new StreetCat("Miko", 1, "Black", 10);
		SiameseCat mySiameseCat = new SiameseCat("Fufu", 20, "Creame", "Expensive food");
		
		System.out.println(myCat.toString());
		System.out.println(myStreetCat.toString());
		System.out.println(mySiameseCat.toString());
		
		/* Question 1: is there anything wrong with the code in the next line? */
		//StreetCat myNewCat = new Cat("Bongo", 3, "Transparent");
		
		/* Question 2: is there anything wrong with the code in the next line? */
		//StreetCat myNewCat = (StreetCat) new Cat("Bongo", 3, "Transparent");
		
		/* Question 3: same here - */
		//Cat myNewCat = (Cat)(new StreetCat("Bongo", 3, "Transparent", 5));
		//System.out.println(myNewCat.toString());
		
		Cat[] cats = new Cat[3];
		cats[0] = new Cat("Cat1", 1, "Color1");
		cats[1] = new StreetCat("StreetCat1", 2, "Color2", 2);
		cats[2] = new SiameseCat("SiameseCat1", 3, "Color3", "Food3");
		
		for (int i = 0; i < cats.length; i++) {
			System.out.println(cats[i].toString());
//			System.out.println(((Cat)cats[i]).toString());
		}
//		Cat myNewestCat = new StreetCat("Yuji", 5, "White", 3);
//		System.out.println(myNewestCat.toString());
	}
	
	/* Answer 1:
	 * The code won't even compile and would show this error -
	 * Type mismatch: cannot convert from Cat to StreetCat
	 * 
	 * Elaboration: how would "java" know what fields to add `Cat` in order to create a `StreetCat` object?
	 */
	
	/* Answer 2:
	 * Running the code would generate this runtime exception -
	 * Exception in thread "main" java.lang.ClassCastException: class Cat cannot be cast to class StreetCat
	 * 
	 * Elaboration: see explanation in answer 1
	 */
}
