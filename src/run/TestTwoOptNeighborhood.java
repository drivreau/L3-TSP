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
import neighborhood.TSPMove;
import neighborhood.TwoOptNeighborhood;

/**
 * This class tests nearest neighbor heuristic for TSP problems.
 * @author David Rivreau
 */
public class TestTwoOptNeighborhood {

	
	
	
	public static void main(String[] args) throws Exception {
		
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

		// On utilise le solver plus proce voisin
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
		
		// Construction du voisinage
		TwoOptNeighborhood neighborhood = new TwoOptNeighborhood(solution);
		
		while (neighborhood.hasNext()) {
			
			TSPMove m = neighborhood.next();
			System.out.println( "Mouvement : "+m.toString()+", impact : " + m.evaluate(solution, instance) ); 
			
		}
		

	}

}
