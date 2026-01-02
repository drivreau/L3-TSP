package model;

import java.util.List;

public class TSPTotalCost implements TSPObjective {

	public int evaluate(TSPSolution solution, TSPInstance instance) {
		List<Integer> tour = solution.getCities();
		if (tour.isEmpty())
			return 0;
		else {
			int totalCost = 0;
			int i = tour.get(0);
			for (int k = 1; k < tour.size(); k++) {
				int j = tour.get(k);
				totalCost += instance.getDistance(i, j);
				i = j;
			}
			return totalCost;
		}
	}

}



