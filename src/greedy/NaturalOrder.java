package greedy;


import java.util.List;

import model.TSPInstance;
import model.TSPObjective;
import model.TSPSolution;
import model.TSPSolver;
import view.TSPSolverObservable;

/**
 * Builds a solution from natural order.
 *
 * @author David Rivreau
 */
public class NaturalOrder extends TSPSolverObservable {

	@Override
	public TSPSolution getSolution(TSPInstance instance, TSPObjective objective) {
		
		TSPSolution solution = new TSPSolution();
		List<Integer> tour = solution.getCities();
		
		// TODO A compl�ter
		
		// On construit dans tour la liste {0, 1, 2, 3, ..., n, 0}
				
		// On renvoie la solution
		return solution;
	}

}
