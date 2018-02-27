package Functions;

import Models.Chromosome;
import Models.Utils;

public class Function1 extends Chromosome {
	
	private double minX;
	private double maxX;
	private double precision;

	public Function1(double minX, double maxX, double precision) {
		this.minX = minX;
		this.maxX = maxX;
		this.precision = precision;
	}
	
	@Override
	public void init() {
		int length = this.getLength(minX, maxX, precision);
		boolean gens [] = new boolean[length];
		
		for(int i = 0; i < length; i ++)
			gens[i] = Math.random() < 0.5 ? false : true;
		
		this.setGens(gens);		
	}

	@Override
	public double test() {
		return 20 + Math.E - 20 * (Math.pow(Math.E, -0.2 * Math.abs(getPhenotype()))) 
				- Math.pow(Math.E, Math.cos(2 * Math.PI * getPhenotype()));
	}

	@Override
	public double getPhenotype() {
		return (minX + (maxX - minX) * Utils.bin2dec(gens)) 
				/ (Math.pow(2, getLength(minX, maxX, precision)) - 1) ;
	}
}