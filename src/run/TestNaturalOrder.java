package run;


import model.TSPInstance;
import model.TSPObjective;
import model.TSPSolution;
import model.TSPSolver;
import model.TSPTotalCost;
import util.MatrixTSPFactory;
import util.TSPInstanceFactory;
import util.TSPSolutionChecker;

/**
 * This class tests nearest neighbor heuristic for TSP problems.
 * @author David Rivreau
 */
public class TestNaturalOrder {

	public static void main(String[] args) throws Exception {
		
		// On crée le solver
		TSPSolver solver = new greedy.NaturalOrder();
		
		// On crée la fonction objectif retenue (coût total)
		TSPObjective objective = new TSPTotalCost();
		
		
		// On crée la fabrique à instance pour des TSP définit par des matrices de distance
		TSPInstanceFactory matrixFactory = new MatrixTSPFactory();
		
		
		// On crée une instance à partir du fichier small5.tsp
		TSPInstance instance = matrixFactory.getFromFile("data/symmetric/small5.tsp");
		
		// Les variables start et end permettent de calculer le temps écoulé entre le top départ et la fin d'exécution en ms.
		long start, end;
		
		start = System.currentTimeMillis();
		
		// On exécute le solveur sur l'instance pour l'objectif donné
		TSPSolution solution = solver.getSolution(instance,objective);
		
		end = System.currentTimeMillis();
		
		// On vérifie que la solution est valide
		boolean solValide = TSPSolutionChecker.isValid(solution, instance);

		if (!solValide) {
				System.out.println( "Attention : solution non valide !!!" );
		}
		else { 
			System.out.println( "Solution : "+solution.toString()+ ", coût : "+objective.evaluate(solution, instance) );
		}			
			
		System.out.println( "Temps écoulé : " + (end-start) +" ms.");
		
	}

}
