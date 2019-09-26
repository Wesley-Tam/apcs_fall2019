//Wesley Tam
//ACPS period 3
//August 26, 2019
//This class will be responsible for doing all the calculations.

public class Quadratic {
	public static String quadrDescriber(double a, double b, double c) {
		//equation
		String equation = a + "x^2 + " + b + "x + " + c;
		//direction
		if (a < 0) {
			String direction = "The parabola opens down.";
		} else {
			String direction = "The parabola opens up.";
		}
		//axis of symmetry
		double xaxis = round2(-b / (2 * a));
		double ycoord = round2()
	}
//----------------------------------------------------------------------------------------------------------
	public static double round2(double num) {
		//A call to round2 rounds a double a double correctly to 2 decimal places and returns a double.
		num =  (num * 100);
		num = (num + 0.5);
		num = (int)num;	
		num = num/100;
		num = (double)num;
		return num;
	}
}
