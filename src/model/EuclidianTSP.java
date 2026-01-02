package model;

public class EuclidianTSP implements TSPInstance {


	/**
	 * x coordinate.
	 */
	private double x[];
	
	/**
	 * y coordinate.
	 */
	private double y[];

	
	
	/**
	 * Builds an euclidian TSP from given coordinates.
	 * @param x
	 * @param y
	 */
	public EuclidianTSP(double[] x, double[] y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		int n = x.length;
		StringBuffer str = new StringBuffer();
		str.append("NoName+\n"+n+"\n");
		for (int i = 0; i < n; i++) {
			str.append( i+1 + "\t"+ x[i] + "\t" + y[i] + "\n" );
		}
		return str.toString();
	}

    
    // get travel distance from the given city to the given other city
    /* (non-Javadoc)
	 * @see model.TSPData#getDistance(int, int)
	 */
    @Override
	public int getDistance(int from, int to){
        return dist(from,to);
    }
    
    // tsplib euclidian distance rounding
    private int dist(int from, int to) {
    	double xd = x[from]-x[to];
    	double yd = y[from]-y[to];
    	return (int) (Math.sqrt(xd*xd+yd*yd)+0.5);
    }
    

	// retrieve number of cities
    /* (non-Javadoc)
	 * @see model.TSPData#getNumCities()
	 */
    @Override
	public int getNumberOfCities(){
        return x.length;
    }


    /**
     * Return x coordinate for city i. 
     * @param i city
     * @return x coordinate
     */
	public double getX(int i) {
		return x[i];
	}

	/**
     * Return y coordinate for city i. 
     * @param i city
     * @return y coordinate
     */
	public double getY(int i) {
		return y[i];
	}

    
}
