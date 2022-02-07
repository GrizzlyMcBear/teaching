package teaching.java.oop.inheritance.questions.q_02;

/**
 * This class represents a siamese cat as requested in
 * <a href="https://86d98cb5-ca6b-4f81-9ecd-6350645ed93b.filesusr.com/ugd/0535b1_c73d41b9a455420f9a7f93a66b3d2085.pptx?dn=01-%20inheritance.pptx">this question</a>.
 * @author Grizzly McBear
 * @author Zohar Asif
 */
public class SiameseCat extends Cat {

	protected String favoriteFood;

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public SiameseCat(String name, int mustacheLength, String color, String favoriteFood) {
		super(name, mustacheLength, color);
		setFavoriteFood(favoriteFood);
	}

	@Override
	public String toString() {
		return String.format("%s, Favorite food: %s", super.toString(), getFavoriteFood());
	}
}