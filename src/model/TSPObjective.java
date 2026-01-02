package model;

public interface TSPObjective {

	public int evaluate(TSPSolution solution, TSPInstance instance);

}