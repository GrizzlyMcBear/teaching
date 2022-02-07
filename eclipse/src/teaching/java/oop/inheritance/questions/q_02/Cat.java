package teaching.java.oop.inheritance.questions.q_02;

/**
 * This class represents a cat as requested in 
 * <a href="https://86d98cb5-ca6b-4f81-9ecd-6350645ed93b.filesusr.com/ugd/0535b1_c73d41b9a455420f9a7f93a66b3d2085.pptx?dn=01-%20inheritance.pptx">this question</a>.
 * @author Grizzly McBear
 * @author Zohar Asif
 */
public class Cat {

	protected String name;
	
	protected int mustacheLength;
	
	protected String color;

	public Cat(String name, int mustacheLength, String color) {
		super();
		setName(name);
		setMustacheLength(mustacheLength);
		setColor(color);
	}
	
	public String getName() {
		String result = "N/A";
		
		if (name != null && !name.equals(""))
			result = name;
			
		return result;
	}

	public void setName(String name) {
		if (name != null && !name.equals(""))
			this.name = name;
	}

	public int getMustacheLength() {
		return mustacheLength;
	}

	public void setMustacheLength(int mustacheLength) {
		if (mustacheLength >= 0)
			this.mustacheLength = mustacheLength;
	}

	public String getColor() {
		String result = "N/A";
		
		if (color != null && !color.equals(""))
			result = color;
			
		return result;
	}

	public void setColor(String color) {
		if (color != null && !color.equals(""))
			this.color = color;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, Mustache: %d [mm], Color: %s", getName(), getMustacheLength(), getColor());
	}
}