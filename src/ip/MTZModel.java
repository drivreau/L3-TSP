package ip;

import java.util.List;
import java.util.logging.Logger;

import ilog.concert.IloException;
import ilog.concert.IloIntVar;
import ilog.concert.IloLinearIntExpr;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;
import model.TSPInstance;
import model.TSPObjective;
import model.TSPSolution;
import view.TSPSolverObservable;


/**
 * IP TSP model from Miller, Tucker and Zemlin 1960.
 * 
 * @author D. Rivreau
 *
 */
public class MTZModel extends TSPSolverObservable {
	
	/**
	 * Cplex object for IP model.
	 */
	private IloCplex cplex;
	
	/**
	 * Binary variable x[i][j] is equal to on if arc (i,j) is selected in tour.
	 */
	private IloIntVar[][] x;
	
	/**
	 * Numeric variable u[i]+1 is index rank of city i in tour.
	 * u[0] is assumed to be equal to zero. 
	 */
	private IloNumVar[] u;

	/**
	 * Turn off cplex messages if mute is true;
	 */
	private boolean muteMode;
	
	/**
	 * Time limit in seconds (if <= 0.0 no time limit is set) 
	 */
	private double timeLimit;
	
	
	/**
	 * Default constructor.
	 */
	public MTZModel() {
		super();
	}

	/**
	 * Creates a MTZModel with give time limit.
	 * @param timeLimit
	 */
	public MTZModel(double timeLimit) {
		super();
		this.timeLimit = timeLimit;
	}
	
	/**
	 * Creates a MTZModel with give time limit and mute mode.
	 * @param timeLimit
	 */
	public MTZModel(double timeLimit, boolean muteMode) {
		super();
		this.timeLimit = timeLimit;
		this.muteMode = muteMode;
	}
	

	/**
	 * Creates variables.
	 * 
	 * @param instance TSP instance to solve
	 * @throws IloException
	 */
	private void createVariables(TSPInstance instance) throws IloException {

		// création de variables binaires
		
		// TODO : compléter code
	
		// création de variables réelles
		
		// TODO : compléter code

	}
	
	/**
	 * Creates constraints.
	 * 
	 * @param instance TSP instance to solve
	 * @throws IloException
	 */
	private void createConstraints(TSPInstance instance) throws IloException {

		// création d'un objet manipulant des expressions linéaires entiéres
		
		// TODO : compléter code
		
		// jeu de contraintes (1)

		// TODO : compléter code
		
		// jeu de contraintes (2)

		// TODO : compléter code
		
		// jeu de contraintes (3) [expression linéaires réelles]
		
		// TODO : compléter code		
		
	}
	
	/**
	 * Creates objective.
	 * 
	 * @param instance TSP instance to solve
	 * @throws IloException
	 */
	private void createObjective(TSPInstance instance) throws IloException {

		IloLinearIntExpr expr = cplex.linearIntExpr();
	
		// création de l'expression linéaire de la fonction objectif
		
		// TODO : compléter code
		
		// on minimisise l'objectif

		// TODO : compléter code

	}

	/**
	 * Gets solution.
	 * @throws IloException
	 */
	private TSPSolution getSolution() throws IloException {

		TSPSolution solution = new TSPSolution();
		List<Integer> tour = solution.getCities();
		for (int i=0;i<u.length+1;i++)
			tour.add(i % u.length);
		
		// on récupère les valeurs affectées aux variables de décision après l'optimisation
		for (int i=1;i<u.length;i++) {
						
			// TODO : récupérer la valeur de u[i]
			double u_i = 0.0;
			
			tour.set( (int)Math.round(u_i)+1, i);		
		}
		tour.set(u.length, tour.get(0));
		
		// on génére la solution associée à la tournée calculée
		return solution;
		
	}

	/**
	 * Fixes if Cplex gives messages on console.
	 * @param muteMode the muteMode to set
	 */
	public void setMuteMode(boolean muteMode) {
		this.muteMode = muteMode;
	}

	/**
	 * Fixes maximum time for solving a problem.
	 * If timeLimit = 0 then there is no limit.
	 * @param timeLimit the timeLimit to set
	 */
	public void setTimeLimit(double timeLimit) {
		this.timeLimit = timeLimit;
	}

	/*
	 * Solve by IP model due to Miller, Tucker and Zemlin.
	 * 
	 * (non-Javadoc)
	 * @see util.TSPSolver#getSolution(data.TSPInstance)
	 */
	@Override
	public TSPSolution getSolution(TSPInstance instance, TSPObjective objective) {
	
		TSPSolution solution = null;
		
		
		try {
			// on créé l'objet qui gére le modéle

			// TODO : compléter code			
			
			// on configure l'affichage (muet ou pas)
			if (muteMode)
				cplex.setOut(null);
			
			// on fixe éventuellement un temps limite
			if (timeLimit > 0)
				cplex.setParam(IloCplex.DoubleParam.TiLim, timeLimit);

			
			// on crée les variables
			
			// TODO : compléter code
			
			// on crée les contraintes

			// TODO : compléter code
		
			// on crée la fonction objectif

			// TODO : compléter code
			
			// on lance le solveur
			
			// TODO : compléter code
					
			// nettoyage de fin
			
			// TODO : compléter code
			
			
		} catch (IloException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		return solution;
	
	}

}
