package run;

import model.EuclidianTSP;
import model.TSPObjective;
import model.TSPSolution;
import model.TSPTotalCost;
import util.EuclidianTSPFactory;
import util.TSPInstanceFactory;
import util.TSPSolutionChecker;
import view.BasicObserver;
import view.EuclidianTSPView;
import view.TSPSolverObservable;
import neighborhood.TwoOptMove;

/**
 * This class tests nearest neighbor heuristic for TSP problems.
 * @author David Rivreau
 */
public class TestTwoOpt {

	
	
	
	public static void main(String[] args) throws Exception {
		
		
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

		// On utilise le solver plus proche voisin
		TSPSolverObservable solver = new greedy.NearestNeighbor();
		
		// On utilise l'objectif classique
		TSPObjective objective = new TSPTotalCost();
		
		// On cr�e l'instance � tester
		String instanceName = "small10";
		TSPInstanceFactory factory = new EuclidianTSPFactory();
		EuclidianTSP instance = (EuclidianTSP) factory.getFromFile("data/euclidian/"+instanceName+".tsp");
		
		// On configure l'observateur basique
		BasicObserver basicObserver = new BasicObserver();
		solver.addObserver(basicObserver);
	
		// On configure la vue graphique
		EuclidianTSPView graphicObserver = new EuclidianTSPView(instance,500);
		solver.addObserver(graphicObserver);
			
		// Application de NearestNeighbor
		TSPSolution solution = solver.getSolution(instance,objective);
		boolean solValide = TSPSolutionChecker.isValid(solution, instance);
		if (!solValide) {
			System.out.println( "Attention : solution non valide !!!" );
		}
		
		// Construction du mouvement TwoOpt(3,9)
		TwoOptMove move = new TwoOptMove(3,9);
		
		// Evaluation de l'impact en terme de co�t
		System.out.println( "Evaluation de l'impact du mouvement : " +move.evaluate(solution, instance) );
		
		// Application du mouvement sur la solution
		move.apply(solution, instance);
		
		// On informe les observateurs de la mise � jour de la solution
		basicObserver.newCurrentSolution(null, solution, objective.evaluate(solution, instance));
		graphicObserver.newCurrentSolution(null, solution, objective.evaluate(solution, instance));

	}

}
