package neighborhood;

import java.util.Iterator;

import model.TSPSolution;

/**
 * Common abstract class to derive neighborhood iterators dedicated to Symmetric
 * Traveling Salesman problem.
 *
 * @author David Rivreau
 */
public abstract class TSPNeighborhood implements Iterator<TSPMove> {

	/**
	 * Initialize neighborhood.
	 * 
	 * @param solution under investigation
	 */
	public abstract void init(TSPSolution solution);

	/*
	 * Remove is not supported for a neighborhood iterator.
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException("remove");
	}

}
