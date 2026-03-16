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
		
		// On cr�e le solver
		TSPSolver solver = new greedy.NaturalOrder();
		
		// On cr�e la fonction objectif retenue (co�t total)
		TSPObjective objective = new TSPTotalCost();
		
		
		// On cr�e la fabrique � instance pour des TSP d�finit par des matrices de distance
		TSPInstanceFactory matrixFactory = new MatrixTSPFactory();
		
		
		// On cr�e une instance � partir du fichier small5.tsp
		TSPInstance instance = matrixFactory.getFromFile("data/symmetric/small5.tsp");
		
		// Les variables start et end permettent de calculer le temps �coul� entre le top d�part et la fin d'ex�cution en ms.
		long start, end;
		
		start = System.currentTimeMillis();
		
		// On ex�cute le solveur sur l'instance pour l'objectif donn�
		TSPSolution solution = solver.getSolution(instance,objective);
		
		end = System.currentTimeMillis();
		
		// On v�rifie que la solution est valide
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
