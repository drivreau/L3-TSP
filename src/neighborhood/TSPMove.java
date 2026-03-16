package neighborhood;

import model.TSPInstance;
import model.TSPSolution;

/**
 * Interface for move operators dedicated to Symmetric Traveling Salesman
 * problem.
 *
 * @author David Rivreau
 */

public interface TSPMove extends Cloneable {

	/**
	 * Evaluate variation of cost induced by a move on given solution.
	 * 
	 * @param sol initial solution
	 * @param instance underlying tsp instance
	 * @return variation of cost if move is applied to initial solution
	 */
	public int evaluate(TSPSolution sol, TSPInstance instance);

	/**
	 * Apply a move on given solution.
	 * 
	 * @param sol solution to modify
	 * @param instance underlying tsp instance
	 */
	public void apply(TSPSolution sol, TSPInstance instance);

	/**
	 * Clone move.
	 * 
	 * @return a clone
	 */
	public Object clone();

}
