package tests.exams.internal.adt.node.q_01;

import utilities.adt.moe.Node;

// TODO: make sure this question has both a working solution and code for testing.
public class Series {
	
	private int duplication;
	
	private char tav;
	
	public Series(int duplication, char tav) {
		super();
		setDuplication(duplication);
		setTav(tav);
	}
	
	public int getDuplication() {
		return this.duplication;
	}
	
	public void setDuplication(int duplication) {
		this.duplication = duplication;
	}
	
	public char getTav() {
		return this.tav;
	}
	
	public void setTav(char tav) {
		this.tav = tav;
	}
	
	@Override
	public String toString() {
		return String.format("[ duplication: %s, tav: %s ... ]", 
				getDuplication(), getTav());
	}
	
	/**
	 * This method creates nodes, each contains a {@link Series Series} object by a given string,
	 * the string's format is "[duplication].[tav],[duplication].[tav],[duplication].[tav]"
	 * for example: "5.t,3.x,2.y" should result in "tttttxxxyy"
	 * 
	 * @param seriesAsCsv
	 * @return
	 */
	public static Node<Series> createSeriesNodes(String seriesAsCsv) {
		Node<Series> result = null,
				currSeriesNode = result;
		
		if (seriesAsCsv != null && !seriesAsCsv.equals("")) {
			
			// Split data into multiple strings, each represents a `Series` object
			String[] series = seriesAsCsv.split("[,]");
			
			for (int currSeriesIndex = 0; currSeriesIndex < series.length; currSeriesIndex++) {
				
				/* Split each string which represents a `Series` object into 2 strings -
				 * 1. The 1st to represent the dupcliations
				 * 2. The 2nd to represent the `tav` (character) to duplicate */
				String currSerie = series[currSeriesIndex];
				String[] serieData = currSerie.split("[.]");

				// Create a `Series` object
				Series currSeries = new Series(Integer.parseInt(serieData[0]), serieData[1].charAt(0));
				
				// Insert it into `result`
				if (result == null) {
					result = new Node<Series>(currSeries);
					currSeriesNode = result;
				} else {
					currSeriesNode.setNext(new Node<Series>(currSeries));
					currSeriesNode = currSeriesNode.getNext();
				}
			}
		}
		
		return result;
	}
}
