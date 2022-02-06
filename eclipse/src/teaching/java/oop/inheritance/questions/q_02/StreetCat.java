package eclipse.teaching.java.oop.inheritance.questions.q_02;

	
/**
 * This class represents a street cat as requested in
 * <a href="https://86d98cb5-ca6b-4f81-9ecd-6350645ed93b.filesusr.com/ugd/0535b1_c73d41b9a455420f9a7f93a66b3d2085.pptx?dn=01-%20inheritance.pptx">this question</a>.
 * @author Ronen Cohen
 * @author Zohar Asif
 */
public class StreetCat extends Cat {

	protected int fightsAmount;
	
	/* Question 1: what would happen if we don't define any c'tors for this class,
	 * and the `Cat` class has a c'tor other than Cat()? */
	
	/**
	 * By calling the {@link Cat#Cat(String, int, String)} c'tor in this derived class we reduce code,
	 * and by so - also reduce the chance of errors.
	 * @param name
	 * @param mustacheLength
	 * @param color
	 * @param fightsAmount
	 */
	public StreetCat(String name, int mustacheLength, String color, int fightsAmount) {
		super(name, mustacheLength, color);
		setFightsAmount(fightsAmount);
	}

	public int getFightsAmount() {
		return fightsAmount;
	}

	public void setFightsAmount(int fightsAmount) {
		if (fightsAmount >= 0)
			this.fightsAmount = fightsAmount;
	}
	
	@Override
	public String toString() {
		return String.format("%s, Fights: %d", super.toString(), getFightsAmount());
	}

	/* Answer 1: 
	 * Implicit super constructor Cat() is undefined for default constructor. Must define an explicit constructor */
}
