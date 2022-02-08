package tests.exams.internal.adt.stack.q_01;

/**
 * This class represents a cell in the game "Snakes and Ladders" with further info in the {@link Question} class. 
 * @author Ronen Cohen
 */
// TODO: finish writing the solution for this question.
// TODO: write testing code for this question.
public class BoardCell {
	
	private String content;
	
	private int index;
	
	private BoardCell next;
	
	public BoardCell(String content) {
		this(content, -1, null);
	}
	
	public BoardCell(String content, int index, BoardCell next) {
		this.index = index;
		this.content = content;
		this.next = next;
	}
	
	public String getContent() {
		return content;
	}
	public int getIndex() {
		return index;
	}
	public BoardCell getNext() {
		return next;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public void setNext(BoardCell next) {
		this.next = next;
	}
	
	@Override
    public String toString() {
		BoardCell next = getNext();
		int nextIndex = (next != null) ? next.getIndex() : -1;
		
    	return String.format(" [ %s (%d) ] ", getContent(), getIndex(), next == null ? "-|" : getNext());
    }
}