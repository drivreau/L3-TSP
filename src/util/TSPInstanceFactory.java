package util;

import model.TSPInstance;

public interface TSPInstanceFactory {

	/**
	 * Creates a TSP instance from file.
	 * @param name name file
	 * @return a TSPInstance
	 */
	public TSPInstance getFromFile(String name);
	
	/**
	 * Generates a random TSP instance with cost between 1 and 999.
	 * 
	 * @param numberOfCities
	 *            number of nodes
	 * @return a random TSP instance
	 */
	public TSPInstance getRandomTSP(int numberOfCities);
	
}