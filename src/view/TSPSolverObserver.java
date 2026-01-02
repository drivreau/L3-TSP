package view;

import model.TSPSolution;

public interface TSPSolverObserver {

	/**
	 * Listen to new current solution.
	 * @param solver calling solver 
	 * @param solution new current solution
	 */
	public void newCurrentSolution(TSPSolverObservable solver, TSPSolution solution, int cost );
	
	/**
	 * Listen to new best solution.
	 * @param solver calling solver 
	 * @param solution new best solution
	 */
	public void newBestSolution(TSPSolverObservable solver, TSPSolution solution, int cost );	

	
}
