package view;

import java.util.ArrayList;
import java.util.List;

import model.TSPSolution;
import model.TSPSolver;

public abstract class TSPSolverObservable implements TSPSolver {

	/**
	 * Listeners.
	 */
	private List<TSPSolverObserver> observers = new ArrayList<TSPSolverObserver>();

	public TSPSolverObservable() {
		super();
	}

	/**
	 * Add a new listener.
	 * @param l listener to add
	 */
	public void addObserver(TSPSolverObserver l) {
		observers.add(l);
	}

	/**
	 * Tell listeners that a new current solution has been set.
	 * @param solver current solver 
	 * @param solution new current solution 
	 */
	protected void fireNewCurrentSolution(TSPSolver solver, TSPSolution solution, int cost) {
		for(TSPSolverObserver l : observers)
			l.newCurrentSolution(this, solution, cost);
	}

	/**
	 * Tell listeners that a new best solution has been found.
	 * @param solver current solver 
	 * @param solution new best solution 
	 */
	protected void fireNewBestSolution(TSPSolver solver, TSPSolution solution, int cost) {
		for(TSPSolverObserver l : observers)
			l.newBestSolution(this, solution, cost);
	}

}