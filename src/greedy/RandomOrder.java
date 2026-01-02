package greedy;


import java.util.Collections;
import java.util.List;

import model.TSPInstance;
import model.TSPObjective;
import model.TSPSolution;
import model.TSPSolver;
import view.TSPSolverObservable;

/**
 * Builds a greedy solution from random permutation.
 *
 * @author David Rivreau
 */

public class RandomOrder extends TSPSolverObservable {

	@Override
	public TSPSolution getSolution(TSPInstance instance, TSPObjective objective) {
		
		TSPSolution solution = new TSPSolution();
		List<Integer> tour = solution.getCities();
		
		// On part de 0
		for (int i=0;i<instance.getNumberOfCities();i++) 
			tour.add(i);
		
		// On melange la tourn�e
		Collections.shuffle(tour);
		
		// On ferme la tourn�e
		tour.add(tour.get(0));
						
		return solution;
	
	}

}
