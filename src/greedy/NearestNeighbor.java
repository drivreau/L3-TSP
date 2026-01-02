package greedy;

import java.util.List;

import model.TSPInstance;
import model.TSPObjective;
import model.TSPSolution;
import model.TSPSolver;
import view.TSPSolverObservable;

/**
 * Implements nearest neighbor greedy heuristic for Symmetric Traveling Salesman
 * problem.
 *
 * @author David Rivreau
 */

public class NearestNeighbor extends TSPSolverObservable {

	@Override
	public TSPSolution getSolution(TSPInstance instance, TSPObjective objective) {

		TSPSolution solution = new TSPSolution();
		List<Integer> tour = solution.getCities();
		boolean[] visited = new boolean[instance.getNumberOfCities()];
	
		int last = 0;
		tour.add(last);
		visited[last] = true;
		
		for (int k = 0; k < instance.getNumberOfCities() - 1; k++) {
			
			// TODO A compl�ter
			
			// On cherche le sommet non visit� le plus proche du dernier visit� (sommet last)			
			
		}
		
		last = 0;
		tour.add(last);
		

		return solution;
	}
}

