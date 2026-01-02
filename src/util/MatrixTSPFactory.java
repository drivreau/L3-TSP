package util;

import java.io.File;
import java.io.FileNotFoundException;


import java.util.Scanner;


import model.MatrixTSP;
import model.TSPInstance;

public class MatrixTSPFactory implements TSPInstanceFactory {

	@Override
	public TSPInstance getFromFile(String name) {	
		File file = new File(name);
		int[][] distance = null;
		Scanner in;
		try {
			in = new Scanner(file);
			int numberOfCities = in.nextInt();
			distance = new int[numberOfCities][numberOfCities];
			for (int i = 0; i < numberOfCities; i++)
				for (int j = 0; j < numberOfCities; j++)
					distance[i][j] = in.nextInt();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new MatrixTSP(distance);	
	}
		
	@Override
	public TSPInstance getRandomTSP(int numberOfCities) {
		int i, j;
		java.util.Random alea = new java.util.Random();
		int[][] distance = new int[numberOfCities][numberOfCities];
		for (i = 0; i < numberOfCities; i++)
			for (j = i + 1; j < numberOfCities; j++) {
				distance[j][i] = distance[i][j] = alea.nextInt(999)+1;
			}
		return new MatrixTSP(distance);
	}
}
