package view;

import model.TSPSolution;

public class BasicObserver implements TSPSolverObserver {

	@Override
	public void newCurrentSolution(TSPSolverObservable solver, TSPSolution solution, int cost) {
		System.out.println( "Nouvelle solution de coût "+cost+" par "+solver.getClass()+" : "+solution.getCities().toString() );
	}

	@Override
	public void newBestSolution(TSPSolverObservable solver, TSPSolution solution, int cost) {
		System.out.println( "Nouvelle meilleure solution de coût "+cost+" par "+solver.getClass()+" : "+solution.getCities().toString() );
	}

}


