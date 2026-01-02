package model;

/**
 * Abstract class for all solver for Symmetric Traveling Salesman problem (greedy
 * heuristics, descent methods, simulated annealing, tabu search, etc.).
 *
 * @author David Rivreau
 */
public interface TSPSolver {

	/**
	 * Generates a solution for instance according to the strategy of the
	 * implementing subclass.
	 * 
	 * @param instance
	 *            tsp instance
	 * @return tsp solution
	 */
	public TSPSolution getSolution(TSPInstance instance, TSPObjective objective);
}
