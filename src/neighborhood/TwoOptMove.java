package neighborhood;

import model.TSPInstance;
import model.TSPSolution;

/**
 * Implements two opt move for the Symmetric Traveling Salesman problem.
 *
 * @author David Rivreau
 */

class TwoOptMove implements TSPMove {

	/**
	 * First edge starting position in permutation.
	 */
	private int i;

	/**
	 * Second edge starting position in permutation.
	 */
	private int j;

	/**
	 * @param i starting position of first edge
	 * @param j starting position of second edge
	 */
	public TwoOptMove(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

	/**
	 * @return starting position of first edge of two opt move.
	 */
	public int getI() {
		return i;
	}

	/**
	 * Set starting position of first edge of two opt move.
	 * @param i starting position of first edge
	 */
	void setI(int i) {
		this.i = i;
	}

	/**
	 * @return the starting position of second edge of two opt move.
	 */
	public int getJ() {
		return j;
	}

	/**
	 * Set starting position of second edge of two opt move.
	 * @param j starting position of second edge
	 */
	void setJ(int j) {
		this.j = j;
	}

	/*
	 * Evaluate the variation of cost induced by the two opt move.
	 * 
	 * Hint: identify the 4 endpoints a, b, c, d from positions i and j
	 * then compute d(a,c) + d(b,d) - d(a,b) - d(c,d)
	 * 
	 * @see neighborhood.TSPMove#evaluate()
	 */
	@Override
	public int evaluate(TSPSolution sol, TSPInstance instance) {
		// TODO Complete method
		return 0;
	}

	/*
	 * Apply the two opt move: reverse the portion of the permutation
	 * between positions i+1 and j.
	 * 
	 * @see neighborhood.TSPMove#apply()
	 */
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
		return "TwoOptMove [i=" + i + ", j=" + j + "]";
	}

}
