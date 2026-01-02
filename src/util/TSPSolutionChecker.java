package util;

import java.util.List;

import model.TSPInstance;
import model.TSPObjective;
import model.TSPSolution;

/**
 * Solution checker for Symmetric Traveling Salesman problem.
 *
 * @author David Rivreau
 */
public class TSPSolutionChecker {

	/**
	 * Check if given solution is a valid tour for a TSP instance.
	 * 
	 * @param sol
	 *            solution
	 * @param instance
	 *            tsp instance
	 * @return true if the solution is valid
	 */
	public static boolean isValid(TSPSolution sol, TSPInstance instance) {
		List<Integer> tour = sol.getCities();
		if (tour.size()-1 != instance.getNumberOfCities() || tour.get(0)!=tour.get(tour.size()-1))
			return false;
		else {
			boolean visited[] = new boolean[instance.getNumberOfCities()];		
			for (int k = 0; k < instance.getNumberOfCities(); k++) {
				int i = tour.get(k);
				if (visited[i])
					return false;
				else
					visited[i] = true;
			}
			return true;
		}
	}

	/**
	 * Check if given solution is a valid tour for a TSP instance and that cost is correct.
	 * 
	 * @param sol
	 *            solution
	 * @param instance
	 *            tsp instance
	 * @return true if the solution is valid
	 */
	public static boolean isValid(TSPSolution sol, TSPInstance instance, int cost, TSPObjective objective) {
		return cost==objective.evaluate(sol, instance) && isValid(sol, instance);
	}

}
