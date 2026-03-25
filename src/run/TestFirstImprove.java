package run;



import descent.FirstImprove;
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
import neighborhood.TwoOptNeighborhood;

/**
 * This class tests nearest neighbor heuristic for TSP problems.
 * @author David Rivreau
 */
public class TestFirstImprove {

	
	
	
	public static void main(String[] args) throws Exception {
		
		
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
	
		// On cr�e un solver plus proche voisin
		TSPSolverObservable solverNN = new greedy.NearestNeighbor();
						
		// On utilise l'objectif classique
		TSPObjective objective = new TSPTotalCost();
				
		// On cr�e l'instance � tester
		String instanceName = "d198";
		TSPInstanceFactory factory = new EuclidianTSPFactory();
		EuclidianTSP instance = (EuclidianTSP) factory.getFromFile("data/euclidian/"+instanceName+".tsp");
				
		// On configure l'observateur basique
		BasicObserver basicObserver = new BasicObserver();
		solverNN.addObserver(basicObserver);
			
		// On configure la vue graphique
		EuclidianTSPView graphicObserver = new EuclidianTSPView(instance,100);
		solverNN.addObserver(graphicObserver);
			
		
		// Application de NearestNeighbor pour construire une solution de d�part
		System.out.println( "Using NearestNeighbor on "+instanceName+"..." );
		TSPSolution initSolution = solverNN.getSolution(instance,objective);
		boolean solValide = TSPSolutionChecker.isValid(initSolution, instance);
		if (!solValide) {
			System.out.println( "Attention : solution non valide !!!" );
		}
		
		// Construction du voisinage
		TwoOptNeighborhood neighborhood = new TwoOptNeighborhood(initSolution);
		
		// Construction du solver First Improve
		FirstImprove solverFI = new FirstImprove(initSolution, neighborhood);

		// On ajoute le solveur aux observateurs
		solverFI.addObserver(basicObserver);
		solverFI.addObserver(graphicObserver);
		
		System.out.println( "Using FirstImprove on "+instanceName+"..." );

		// On lance le solveur First Improve
		long start, end;
		start = System.currentTimeMillis();
		TSPSolution solution = solverFI.getSolution(instance,objective);
		end = System.currentTimeMillis();
		
		System.out.println( "Done FirstImprove on "+instanceName+" in "+(end-start)+" ms, solution value : "+objective.evaluate(solution, instance) );
		

	}

}
