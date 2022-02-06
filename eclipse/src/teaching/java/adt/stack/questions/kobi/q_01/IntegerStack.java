package eclipse.teaching.java.adt.stack.questions.kobi.q_01;

/**
 * 
 * @author Ronen Cohen
 * 
 * @implSpec in order to test this class, copy the following code to main:
 		
 		IntegerStack myIntStack = new IntegerStack();
		
		System.out.println(String.format("Printing myIntStack:\n%s\n", myIntStack.toString()));
		
		System.out.println(String.format("myIntStack is empty? %s\n", myIntStack.isEmpty()));
		
		System.out.println("Inserting an item (1)\n");
		myIntStack.push(new Integer(1));
		System.out.println(String.format("myIntStack is empty? %s\n", myIntStack.isEmpty()));
		System.out.println(String.format("Printing myIntStack:\n%s\n", myIntStack.toString()));
		
		System.out.println("Inserting more items (2, 3, 4, 5, 6)\n");
		myIntStack.push(new Integer(2));
		myIntStack.push(new Integer(3));
		myIntStack.push(new Integer(4));
		myIntStack.push(new Integer(5));
		myIntStack.push(new Integer(6));
		
		System.out.println(String.format("Printing myIntStack:\n%s\n", myIntStack.toString()));
		
		System.out.println(String.format("Topmost item in myIntStack is: %s\n", myIntStack.top()));
		
		System.out.println(String.format("Popping out topmost item in myIntStack: %s\n", myIntStack.pop()));
		
		System.out.println(String.format("Printing myIntStack:\n%s\n", myIntStack.toString()));
 *
 */
public class IntegerStack {

	private Integer[] mainData;
	
	private Integer[] tempData;
	
	private int topItemIndex;
	
	private final int DEFAULT_INITIAL_STACK_SIZE = 10;
	
	private final int STACK_EMPTY_INDEX = -1;
	
	public IntegerStack() {
		mainData = new Integer[DEFAULT_INITIAL_STACK_SIZE];
		tempData = new Integer[DEFAULT_INITIAL_STACK_SIZE];
		topItemIndex = STACK_EMPTY_INDEX;
	}
	
	/**
	 * @return true if this stack is empty, otherwise - false.
	 */
	public boolean isEmpty() {
		return (topItemIndex == STACK_EMPTY_INDEX);
	}
	
	/** This method simulates the `pop` method in the original `Stack` class.
	 * 
	 * @implNote This method throws the `nullPointerException` instead of the `indexOutOfBoundException`.
	 * 
	 * @return the topmost item in this "Stack".
	 */
	public Integer pop() {
		Integer result = mainData[topItemIndex];

		mainData[topItemIndex] = null;
		topItemIndex--;
		
		return result;
	}
	
	/** This method copies items from the `origin` to the `destination`. 
	 * @param origin the source from which to copy items.
	 * @param destination the destination into which items would be copied.
	 * @param itemsAmount the amount of items to copy.
	 */
	private void copyArrayContent(Integer[] origin, Integer[] destination, int itemsAmount) {
		for (int currIndex = 0; currIndex < itemsAmount; currIndex++) {
			destination[currIndex] = origin[currIndex];
		}
	}
	
	public void push(Integer newItem) {
		if (topItemIndex == mainData.length - 1) {
			
			// Copy existing items from `mainData` to `tempData`
			copyArrayContent(mainData, tempData, mainData.length);
			
			// Create a bigger `mainData` array
			mainData = new Integer[mainData.length * 2];
			
			// Copy back the items from `tempData` into `mainData`
			copyArrayContent(tempData, mainData, tempData.length);
			
			// Increase the size of `tempData` (for the next copying)
			tempData = new Integer[mainData.length];
		}
		
		// Insert the new item
		topItemIndex++;
		mainData[topItemIndex] = newItem;
	}
	
	public Integer top() {
		return mainData[topItemIndex];
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilderResult = new StringBuilder("[");
		
		for (int currIndex = 0; currIndex <= topItemIndex; currIndex++) {
			stringBuilderResult.append(mainData[currIndex].toString());
			
			if (currIndex != topItemIndex)
				stringBuilderResult.append(", ");
		}
		
		return stringBuilderResult.append("]").toString();
	}

}
