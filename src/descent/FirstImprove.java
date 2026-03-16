package descent;

import neighborhood.TSPMove;
import neighborhood.TSPNeighborhood;
import model.TSPInstance;
import model.TSPObjective;
import model.TSPSolution;
import model.TSPSolver;
import view.TSPSolverObservable;

/**
 * First improve descent method : from initial solution a first improve descent
 * is performed according to given neighborhood.
 *
 * @author David Rivreau
 */
public class FirstImprove extends TSPSolverObservable {

	/**
	 * Initial solution.
	 */
	private TSPSolution initSolution;

	/**
	 * Neighborhood used for descent.
	 */
	private TSPNeighborhood neighborhood;

	/**
	 * Builds a new FirstImprove object.
	 * @param initSolution initial solution
	 * @param neighborhood neighborhood used for first improve descent
	 */
	public FirstImprove(TSPSolution initSolution, TSPNeighborhood neighborhood) {
		super();
		initialize(initSolution, neighborhood);
	}

	/**
	 * Initialize first solution and neighborhood used.
	 * 
	 * @param initSolution initial solution
	 * @param neighborhood neighborhood used for descent
	 */
	public final void initialize(TSPSolution initSolution,
			TSPNeighborhood neighborhood) {
		this.initSolution = initSolution;
		this.neighborhood = neighborhood;
	}

	/*
	 * First improve descent:
	 * 1. Copy initSolution as current solution
	 * 2. Loop:
	 *    a. Initialize the neighborhood for the current solution
	 *    b. Scan moves until a strictly improving one is found
	 *    c. If found, apply it and restart from 2a
	 *    d. If no improving move exists, stop (local optimum reached)
	 */
	@Override
	public TSPSolution getSolution(TSPInstance instance, TSPObjective objective) {

		// On copie la solution initiale qui est le point départ
		TSPSolution currentSol = (TSPSolution) initSolution.clone();

		// TODO Complete method

		return currentSol;
	}

}
