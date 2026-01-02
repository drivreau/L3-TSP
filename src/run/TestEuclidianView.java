package run;


import model.EuclidianTSP;
import model.TSPObjective;
import model.TSPSolution;
import model.TSPTotalCost;
import view.TSPSolverObservable;
import util.EuclidianTSPFactory;
import util.TSPSolutionChecker;
import view.EuclidianTSPView;

/**
 * This class tests some greedy heuristics for TSP problems.
 * 
 * @author David Rivreau
 */
public class TestEuclidianView {

	public static void main(String[] args) throws Exception {

		TSPSolverObservable solver = new greedy.NearestNeighbor();

	
		// On cr�e la fabrique � instance pour des TSP Euclidiens
		EuclidianTSPFactory factory = new EuclidianTSPFactory();

		TSPObjective objective = new TSPTotalCost();
		
		EuclidianTSP instance = (EuclidianTSP) factory.getFromFile("data/euclidian/small10.tsp");

		// On ajoute l'observateur pour une instance Euclidienne sur le solver 
		solver.addObserver(new EuclidianTSPView(instance, 500));
		
		// Test de NearestNeighbor
		long start, end;
		start = System.currentTimeMillis();
		TSPSolution solution = solver.getSolution(instance,objective);
		end = System.currentTimeMillis();
		
		boolean solValide = TSPSolutionChecker.isValid(solution, instance);
			
		if (!solValide) {
			System.out.println("Attention : solution non valide !!!");
		}
		System.out.println("small10;greedy.NearestNeighbor;" + objective.evaluate(solution, instance) + ";"
				+ (end - start) + ";" + solValide);

	}

}
