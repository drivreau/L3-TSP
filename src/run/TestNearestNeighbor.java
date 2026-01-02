package run;



import java.io.FileReader;

import model.MatrixTSP;
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
public class TestNearestNeighbor {

	
	
	
	public static void main(String[] args) throws Exception {
		
		TSPSolver solver = new greedy.NearestNeighbor();
		TSPObjective objective = new TSPTotalCost();
		TSPInstanceFactory factory = new MatrixTSPFactory();
		
		// Instances à tester
		String[] instances = {"small5","bayg29","bays29","brazil58"};
		
		for (String instanceName : instances) {
			TSPInstance instance = factory.getFromFile("data/symmetric/"+instanceName+".tsp");
		
			// Test de NearestNeighbor
			long start, end;
			start = System.currentTimeMillis();
			TSPSolution solution = solver.getSolution(instance,objective);
			boolean solValide = TSPSolutionChecker.isValid(solution, instance);
			end = System.currentTimeMillis();
			if (!solValide) {
				System.out.println( "Attention : solution non valide !!!" );
			}
			System.out.println( instanceName+";greedy.NearestNeighbor;"+objective.evaluate(solution, instance)+";"+(end-start)+";"+solValide);

		}
	}

}
