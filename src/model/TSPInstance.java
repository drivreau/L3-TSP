package model;

public interface TSPInstance {

	/**
	 * @return the nbNodes
	 */
	int getNumberOfCities();

	/**
	 * @param i
	 *            start node
	 * @param j
	 *            end node
	 * @return the length of arc (i,j)
	 */
	int getDistance(int i, int j);


}