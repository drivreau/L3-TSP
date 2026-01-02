package util;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Locale;
import java.util.Scanner;

import model.EuclidianTSP;

import model.TSPInstance;

public class EuclidianTSPFactory implements TSPInstanceFactory {

	
	@Override
	public TSPInstance getFromFile(String name) {
		
		File file = new File(name);
    	// create scanner
		double[] x = null;
        double[] y = null;
        Scanner sc;
		try {
			sc = new Scanner(file);
			sc.useLocale(Locale.US);
	        // read instance name
	        sc.next();
	        // read number of cities
	        int n = sc.nextInt();
	        // initialize x and y
	        x = new double[n];
	        y = new double[n];
	        // fill distance matrix
	        for(int i=0; i<n; i++){
	        	assert sc.nextInt() == i+1;
	        	x[i] = sc.nextDouble();
	        	y[i] = sc.nextDouble();
	        }
	        sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new EuclidianTSP(x,y);
        
	}
	
	@Override
	public  TSPInstance getRandomTSP(int numberOfCities) {

		double x[], y[];
		int i;
		x = new double[numberOfCities];
		y = new double[numberOfCities];
		for (i = 0; i < numberOfCities; i++) {
			x[i] = 707.0 * Math.random();
			y[i] = 707.0 * Math.random();
		}
		return new EuclidianTSP(x,y);
	}

}
