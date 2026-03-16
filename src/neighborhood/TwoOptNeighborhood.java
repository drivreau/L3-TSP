package neighborhood;

import model.TSPSolution;

/**
 * Implements a two opt neighborhood iterator for the Symmetric Traveling Salesman
 * problem.
 *
 * @author David Rivreau
 */

public class TwoOptNeighborhood extends TSPNeighborhood {

	/**
	 * Current move.
	 */
	private TwoOptMove current;
	
	/**
	 * Number of cities.
	 */
	private int n;
	
	
	/**
	 * Builds a new TwoOptNeighborhood.
	 */
	public TwoOptNeighborhood() {
		super();
		current = new TwoOptMove(0,1);
		n = 0;
	}

	
	/**
	 * Builds a new TwoOptNeighborhood for given solution.
	 * 
	 * @param solution current solution
	 */	
	public TwoOptNeighborhood(TSPSolution solution) {
		super();
		current = new TwoOptMove(0,1);
		init(solution);
	}

	/*
	 * Initialize the iterator for the given solution.
	 * Reset current to (0,1).
	 */
	@Override
	public void init(TSPSolution solution) {
		// TODO Complete method
	}

	/*
	 * Return true if there are more moves to enumerate after current.
	 * 
	 * Hint: the last move is (n-3, n-1)
	 */
	@Override
	public boolean hasNext() {
		// TODO Complete method
		return false;
	}

	/*
	 * Advance current to the next move and return it.
	 * 
	 * Enumerate pairs (i,j) with i in {0,...,n-3}, j in {i+2,...,n-1}
	 * excluding (0, n-1).
	 */
	@Override 
	public TSPMove next() {
		// TODO Complete method
		return current;
	}	

}
