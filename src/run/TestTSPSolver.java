package run;

import ip.MTZModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.EuclidianTSPFactory;
import util.MatrixTSPFactory;
import util.TSPInstanceFactory;
import util.TSPSolutionChecker;
import model.TSPSolver;
import model.TSPTotalCost;
import model.TSPInstance;
import model.TSPObjective;
import model.TSPSolution;

/**
 * This class test various solver for TSP problems.
 * @author David Rivreau
 */
public class TestTSPSolver {

	/**
	 * Test solver on instance 
	 * @param solver solver used
	 * @param instance instance to solve
	 * @param instanceName name of instance
	 * @throws IOException 
	 */
	private static void test( TSPSolver solver, TSPInstance instance, TSPObjective objective, String instanceName, BufferedWriter resu ) throws IOException {
			
		long start, end;
		start = System.currentTimeMillis();
		TSPSolution solution = solver.getSolution(instance,objective);
		end = System.currentTimeMillis();
		
		boolean isValid = false;
		if (solution!=null) {
			isValid = TSPSolutionChecker.isValid(solution, instance);
			System.out.println( instanceName+";"+solver.getClass().getSimpleName()+";"+objective.evaluate(solution, instance)+";"+(end-start)+";"+isValid);
			resu.write( instanceName+";"+solver.getClass().getSimpleName()+";"+objective.evaluate(solution, instance)+";"+(end-start)+";"+isValid+"\n");
			resu.flush();
		}
		else {
			System.out.println( instanceName+";"+solver.getClass().getSimpleName()+"; - ;"+(end-start)+";"+isValid);
			resu.write( instanceName+";"+solver.getClass().getSimpleName()+"; - ;"+(end-start)+";"+isValid+"\n");
			resu.flush();			
		}
		
		if (!isValid)
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).warning( " -> solution non valide" );
		
	}
	
	
	public static void main(String[] args) throws Exception {
		
		
		// On fixe le niveau d'information du log
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.WARNING);

		// Solver générique
		TSPSolver solver;
		
		// Fonction objectif
		TSPObjective objective = new TSPTotalCost();
		
		// Factories
		TSPInstanceFactory matrixFactory = new MatrixTSPFactory();
		TSPInstanceFactory euclidianFactory = new EuclidianTSPFactory();
		
		
		// Fichier de résultat
		BufferedWriter resu = new BufferedWriter( new FileWriter("output/resu_test.csv") );
		
		// Instances à tester
		String[] instances = {"symmetric/small5","symmetric/bayg29","symmetric/bays29","symmetric/brazil58", "euclidian/d198"};
		
		
		for (String instanceName : instances) {
			
			TSPInstance instance;
			
			if (instanceName.contains("symmetric"))
				instance  = matrixFactory.getFromFile("data/"+instanceName+".tsp");
			else
				instance  = euclidianFactory.getFromFile("data/"+instanceName+".tsp");
			
			// Test des méthodes gloutons
			String[] methods = {"greedy.NearestNeighbor","greedy.BestInsertion"};
			for (String method : methods) {
				solver = (TSPSolver) Class.forName(method).newInstance();		
				test(solver, instance, objective, instanceName, resu );
			}
		

			// Test du modèle MTZ
			solver = new MTZModel(30, true );
			test(solver, instance, objective, instanceName, resu );
						
		}

		
		// Fermeture du fichier de résultat
		resu.close();
		
	}
	

}
