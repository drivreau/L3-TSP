package descent;

import neighborhood.TSPMove;
import neighborhood.TSPNeighborhood;
import model.TSPInstance;
import model.TSPObjective;
import model.TSPSolution;
import model.TSPSolver;
import view.TSPSolverObservable;

/**
 * Best improve descent method : from initial solution a best improve descent is
 * performed according to given neighborhood.
 *
 * @author David Rivreau
 */
public class BestImprove extends TSPSolverObservable {

	/**
	 * Initial solution.
	 */
	private TSPSolution initSolution;

	/**
	 * Neighborhood used for descent.
	 */
	private TSPNeighborhood neighborhood;

	/**
	 * Builds a new BestImprove object.
	 * @param initSolution initial solution
	 * @param neighborhood neighborhood used for best improve descent
	 */
	public BestImprove(TSPSolution initSolution, TSPNeighborhood neighborhood) {
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
	 * Best improve descent:
	 * 1. Copy initSolution as current solution
	 * 2. Loop:
	 *    a. Initialize the neighborhood for the current solution
	 *    b. Scan ALL moves, keep track of the best improving move
	 *    c. If a strictly improving move was found, apply it
	 *    d. Otherwise stop (local optimum reached)
	 */
	@Override
	public TSPSolution getSolution(TSPInstance instance, TSPObjective objective) {

		// On copie la solution initiale qui est le point départ
		TSPSolution currentSol = (TSPSolution) initSolution.clone();

		

		// TODO Complete method

		return currentSol;
	}

}
