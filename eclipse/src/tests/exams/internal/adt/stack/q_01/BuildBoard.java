package tests.exams.internal.adt.stack.q_01;

/**
 * This class creates a board game for the game "Snakes and Ladders" with further info in the {@link Question} class.
 * @author Ronen Cohen
 */
// TODO: finish writing the code for this question's solution.
// TODO: write testing code for this solution.
public class BuildBoard {
	
	private static final Character CELL_SEPARATOR = ',';
	
	private static final Character CELL_CONTENT_SEPARATOR = '_';

	private String description;
	
	private boolean isDescValid(String description) {
		boolean result = true;
		
		if (description == null)
			result = false;
		
		return result;
	}

	public BuildBoard() {
		this("");
	}
	
	public BuildBoard(String description) {
		setDescription(description);
		parseDescription();
	}
	
	private void parseDescription() {
//		String[] cellsDesc = getDescription().spli
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		if (!isDescValid(description)) {
			System.out.println("Input isn't valid");
			description = "";
		}
		
		this.description = description.strip();
	}
}