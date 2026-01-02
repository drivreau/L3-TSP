package greedy;


import java.util.Arrays;
import java.util.List;

import model.TSPInstance;
import model.TSPObjective;
import model.TSPSolution;
import model.TSPSolver;
import view.TSPSolverObservable;

/**
 * Implements best insertion greedy heuristic for Symmetric Traveling Salesman
 * problem.
 *
 * @author David Rivreau
 */
public class BestInsertion extends TSPSolverObservable {

	@Override
	public TSPSolution getSolution(TSPInstance instance, TSPObjective objective) {

		int[] next = new int[instance.getNumberOfCities()];
		TSPSolution solution = new TSPSolution();
		List<Integer> tour = solution.getCities();
	
		// TODO A compl�ter
		
		return solution;
	}

}
