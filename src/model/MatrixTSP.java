package model;


/**
 * Symmetric Traveling Salesman Instance.
 *
 * @author David Rivreau
 */
public class MatrixTSP implements TSPInstance {

	/**
	 * Number of cities.
	 */
	private int numberOfCities;

	/**
	 * Distance matrix.
	 */
	private int distance[][];

	/**
	 * Builds an symmetric TSP with given distance matrix.
	 * @param distance distance matrix
	 */
	public MatrixTSP(int[][] distance) {
		this.numberOfCities = distance.length;
		this.distance = distance;
	}
	

	/* (non-Javadoc)
	 * @see data.TSPInstance#getNumberOfCities()
	 */
	@Override
	public int getNumberOfCities() {
		return numberOfCities;
	}

	/* (non-Javadoc)
	 * @see data.TSPInstance#getDistance(int, int)
	 */
	@Override
	public int getDistance(int i, int j) {
		return distance[i][j];
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(numberOfCities+"\n");
		for (int i = 0; i < numberOfCities; i++) {
			for (int j = 0; j < numberOfCities-1; j++) {
				str.append(distance[i][j]+"\t");
			}
			str.append(distance[i][numberOfCities-1]+"\n");
		}
		return str.toString();
	}
	

}
