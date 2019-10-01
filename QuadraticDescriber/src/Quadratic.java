//Wesley Tam
//ACPS period 3
//August 26, 2019
//This class will be responsible for doing all the calculations.

public class Quadratic {
	public static String quadrDescriber(double a, double b, double c) {
		//equation
		String equation = "Description of the graph of:\ny= " + a + "x^2 + " + b + "x + " + c + "\n";
		//direction
		String direction = "";
		if (a < 0) {
			direction = "Opens: Down.";
		} else {
			direction = "Opens: Up.";
		}
		//axis of symmetry
		double xaxis = round2(-b / (2 * a));
		String axis = "Axis of Symmetry: x = " + xaxis;
		//vertex
		double ycoord = round2((a * (xaxis * xaxis)) + (b * xaxis) + c);
		String vertex = "Vertex: (" + xaxis + ", " + ycoord + ")";
		//x intercepts
		String roots = "x-intercept(s): " + quadform(a, b, c);
		//y-intercepts
		String yint = "y-intercept: " + c;
		String console = equation + "\n" + direction + "\n" + axis + "\n" + vertex + "\n" + roots + "\n" + yint;
		return console;
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static double round2(double num) {
		//A call to round2 rounds a double a double correctly to 2 decimal places and returns a double.
		num =  (num * 100);
		num = (num + 0.5);
		num = (int)num;	
		num = num/100;
		num = (double)num;
		return num;
	}
	
	public static int min(int num1, int num2) {
		//A call to min returns the smaller of the values passed. The method accepts two doubles and returns an int.
		if (num1 < num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	public static double max(double num1, double num2) {
		//A call to max returns the larger of the values passed. The method accepts two doubles and returns a double.
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	public static double discriminant(double a, double b, double c) {
		//A call to discriminant provides the coefficients of a quadratic formula in standard form (a, b, and c) and returns the value of the discriminant. The method accepts three doubles and returns a double.
		return ((b * b) - (4 * a * c));
	}
	
	public static double absValue(double num) {
		//A call to absValue returns the absolute value of the number passed. The method accepts a double and returns a double.
		if (num >= 0) {
			return num;
		} else {
			return (num * -1);
		}
	}
	
	public static double sqrt(double num) {
		//A call to sqrt returns an approximation of the square root of the value passed, rounded to two decimal places. the method accepts a double and returns a double.
		//Done with the help of Caleb Ng
		if (num < 0) {
			throw new IllegalArgumentException("Cannot take the square root of a negative number");
		}
		double guess = 1;
		if (num == 0) {
			guess = 0;
		}
		while (absValue((guess * guess) - num) >= (0.005)) {
			guess = 0.5 * (num / guess + guess);
		}
		guess = round2(guess);
		return guess;
	}
	
	public static String quadform(double a, double b, double c) {
		//A call to quadform uses the coefficients of a quadratic equation in standard form and uses the quadratic formula to approximate the real roots, if any.
		if (discriminant(a, b, c) < 0) {
			return "No x-intercepts";
		}
		double root1 = (-b + (sqrt(discriminant(a, b, c)))) / (2 * a);
		double root2 = (-b - (sqrt(discriminant(a, b, c)))) / (2 * a);
		if (root1 == root2) {
			return "(" + round2(root1) + ")";
		} else {
			double rootmin = min((int)root1, (int)root2);
			double rootmax = max(root1, root2);
			return round2(rootmin) +  " and " + round2(rootmax);
		}
	}
}
