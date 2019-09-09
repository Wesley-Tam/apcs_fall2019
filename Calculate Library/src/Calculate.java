//Wesley Tam
//APCS Period 3
//August 29, 2019
//This is a library of math methods and functions

public class Calculate {
	
	public static int square(int number) {
		//A call to square returns the square of the value passed. The method accepts and integer and returns an integer.
		int answer;
		answer = number * number;
		return answer;
	}
	
	public static int cube(int number) {
		//A call to cube returns the cube of the value passed. The method accepts and integer and returns an integer.
		int answer;
		answer = number * number * number;
		return answer;
	}
		
	public static double average(double number, double secnum) {
		//A call to average returns the average of the values passed to it. The method accepts two doubles and returns two doubles.
		return (number + secnum)/2.0;
	}
	
	public static double average(double number, double secnum, double thirdnum) {
		//Another average method. This one accepts three doubles and returns a double. The name is the same, the difference is in the header and the calculation. (The ability to define two or more different methods with the same name but different method signatures is called "overloading". This average method is an example of an "overloaded method".)
		return (number + secnum + thirdnum)/3;
	}
		
	public static double toDegrees(double radians) {
		//A call to toDegrees converts an angle measure given in radians into degrees. This method accepts a double and returns a double. The method should use 3.14159 as an approx. for pi.
		return (radians * 180 / 3.14159);
	}
	
	public static double toRadians(double degrees) {
		//A call to toRadians converts an angle measure given in degrees into radians. The method accepts a double and returns a double. This method should use 3.14159 as an approx. for pi.
		return (degrees * 3.14159 / 180);
	}
	
	public static double discriminant(double a, double b, double c) {
		//A call to discriminant provides the coefficients of a quadratic formula in standard form (a, b, and c) and returns the value of the discriminant. The method accepts three doubles and returns a double.
		return ((b * b) - (4 * a * c));
	}
		
	public static String toImproperFrac(int wholenum, int numerator, int denominator) {
		//A call to toImproperFrac converts a mixed number (with pieces provided separately in the order of a whole number, numerator, then denominator) into an improper fraction. The method accepts three integers and returns a String (For example, to convert 3 and 1/2 into an improper fraction: toImproperFrac (3, 1, 2). This call would return the String: "7/2").
		return (wholenum * denominator + numerator + "/" + denominator); 
	}
	
	public static String toMixedNum(int numerator, int denominator) {
		//A call to toMixedNum converts an improper fraction (with pieces provided separately in the order numerator then denominator) into a mixed number. The method accepts two integers and returns a String (For example, to convert 7/2 into a mixed number: toMixedNum (7, 2). This call would return the String: "3_1/2").
		return (numerator/denominator + "_" + numerator%denominator + "/" + denominator); 
	}
	
	public static String foil(int a,int b, int c, int d, String x) {
		//A call to foil converts a binomial multiplication of the form (ax + b)(cx + d) into a quadratic equation of the form ax^2 + bx + c. The method accepts four integers and a String and then returns a String.
		return (a*c + "x^2 + " + (a*d + b*c) + "x + " + b*d);
	}
}