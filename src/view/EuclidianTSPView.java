package view;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import model.EuclidianTSP;
import model.TSPSolution;

public class EuclidianTSPView implements TSPSolverObserver {

	// underlying graph
	private final Graph graph;
	
	// utility list
	private List<Edge> edges;
		
	// style
	protected String styleSheet = "node {" + "	fill-color: black;" + "}" + "edge.green {" + "	fill-color: green; size: 2px;" + "}"
			+ "edge.red {" + "fill-color: #F005; size: 1px;" + "}" + "edge.black {" + "fill-color: black; size: 2px;" + "}";
	
	// delay between update
	private int delay;
	
	public EuclidianTSPView (EuclidianTSP data, int delay) {
		graph = new SingleGraph("");
		
		graph.setAttribute("ui.title", "Vue TSP Euclidien");
		
		this.delay = delay;
		
		edges = new ArrayList<Edge>();
		for (int i = 0; i < data.getNumberOfCities(); i++) {
			Node n = graph.addNode(i + "");
			n.addAttribute("ui.label", n.getId());
			n.setAttribute("xyz", data.getX(i), data.getY(i), 0);
		}
		
		graph.addAttribute("ui.stylesheet", styleSheet);
		graph.display(false);
		
	}
	
	
	
	public void setPath(List<Integer> cities) {
		int n = cities.size();
		edges.clear();
		for(int i=0; i<n-1; i++){
            int fromCity = cities.get(i);
            int toCity = cities.get((i+1));
            String id = edgeId(fromCity, toCity);
            Edge e = graph.getEdge(id);
            
            if (e==null) {
            	e = graph.addEdge(id,fromCity+"",toCity+"");
    			e.addAttribute("ui.class", "green");
            }
            else if (e.getAttribute("ui.class")=="red")
            	e.setAttribute("ui.class", "green");
            else
            	e.setAttribute("ui.class", "black");
            
            edges.add(e);
            
		}
		
		Iterator<Edge> it = graph.getEdgeIterator();
		while (it.hasNext()) {
			Edge e = it.next();
			if (!edges.contains(e))
				if (e.getAttribute("ui.class").equals("red"))
					graph.removeEdge(e);
				else
					e.setAttribute("ui.class", "red");
		}
	}
	
	
	private String edgeId(int fromCity, int toCity) {
		if (fromCity<toCity)
			return fromCity+"_"+toCity;
		else
			return toCity+"_"+fromCity;
	}
	
	public void newCurrentSolution(TSPSolverObservable solver, TSPSolution solution, int cost ) {
		setPath(solution.getCities());
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		setPath(solution.getCities());
	}



	@Override
	public void newBestSolution(TSPSolverObservable solver, TSPSolution solution, int cost) {
	}
	
	
}
