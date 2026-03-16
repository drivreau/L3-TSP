package neighborhood;

import model.TSPSolution;

/**
 * Implements a swap neighborhood iterator for the Symmetric Traveling Salesman
 * problem.
 *
 * @author David Rivreau
 */

public class SwapNeighborhood extends TSPNeighborhood {

	/**
	 * Current move.
	 */
	private SwapMove current;

	/**
	 * Number of cities.
	 */
	private int numberOfCities;

	/**
	 * Builds a new SwapNeighborhood.
	 */
	public SwapNeighborhood() {
		super();
		current = new SwapMove(0, 0);
		numberOfCities = 0;
	}

	/**
	 * Builds a new SwapNeighborhood for given solution.
	 * 
	 * @param solution current solution
	 */
	public SwapNeighborhood(TSPSolution solution) {
		super();
		current = new SwapMove(0, 0);
		init(solution);
	}

	@Override
	public void init(TSPSolution solution) {
		numberOfCities = solution.getNumberOfCities();
		current.setI(0);
		current.setJ(0);
	}

	@Override
	public boolean hasNext() {
		return current.getI() < numberOfCities - 2;
	}

	@Override
	public TSPMove next() {
		int i = current.getI();
		int j = current.getJ();
		if (j < numberOfCities - 1)
			current.setJ(j + 1);
		else {
			current.setI(i + 1);
			current.setJ(i + 2);
		}
		return current;
	}

}
