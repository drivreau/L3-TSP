package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Symmetric Traveling Salesman Solution.
 *
 * @author David Rivreau
 */
public class TSPSolution implements Cloneable {
	
	
	/**
	 * Solution tour.
	 */
	private List<Integer> tour;

	/**
	 * Builds a new empty solution.
	 */
	public TSPSolution() {
		super();
		this.tour = new ArrayList<Integer>();
	}
	
	/**
	 * Builds a new solution with given cost and tour.
	 * @param cost
	 * @param tour
	 */
	public TSPSolution(int cost, int[] tour) {
		super();
		this.tour = new ArrayList<Integer>();
		for (int k : tour)
			this.tour.add(k);
	}
	
	/**
	 * Returns the number of cities.
	 */
	public int getNumberOfCities() {
		return tour.size()-1;
	}

	/**
	 * Returns kth city in tour.
	 * @param k rank of city in tour
	 * @return kth city in tour
	 */
	public int getCity(int k) {
		return tour.get(k);
	}

	/**
	 * Returns city tour.
	 * @return city tour
	 */
	public List<Integer> getCities(){
	     return tour;
	}
	
	/**
	 * Set kth city in tour.
	 * @param k rank of city in tour
	 * @param city to set in tour
	 */
	public void setCity(int k, int city) {
		tour.set(k, city);
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		TSPSolution sol = new TSPSolution();
		sol.tour.addAll(tour);
		return sol;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (int i : tour)
			str.append(i+"\t");
		str.append("\n");
		return str.toString();
	}


	 
}
