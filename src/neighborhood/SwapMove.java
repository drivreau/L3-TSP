package neighborhood;

import model.TSPInstance;
import model.TSPSolution;

/**
 * Implements swap move for the Symmetric Traveling Salesman problem.
 *
 * @author David Rivreau
 */

class SwapMove implements TSPMove {

	/**
	 * First position.
	 */
	private int i;

	/**
	 * Second position.
	 */
	private int j;

	/**
	 * Represent a swap move in a tour : cities in position i and j are
	 * exchanged.
	 * 
	 * @param i first city position
	 * @param j second city position
	 */
	public SwapMove(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

	/**
	 * @return the first city position of swap move
	 */
	public int getI() {
		return i;
	}

	/**
	 * @param i the first city position to set
	 */
	void setI(int i) {
		this.i = i;
	}

	/**
	 * @return the second city position of swap move
	 */
	public int getJ() {
		return j;
	}

	/**
	 * @param j the second city position to set
	 */
	void setJ(int j) {
		this.j = j;
	}

	@Override
	public int evaluate(TSPSolution sol, TSPInstance instance) {
		// TODO Complete method
		return 0;
	}

	@Override
	public void apply(TSPSolution sol, TSPInstance instance) {
		// TODO Complete method
	}

	/*
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(e);
		}
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SwapMove [i=" + i + ", j=" + j + "]";
	}

}
