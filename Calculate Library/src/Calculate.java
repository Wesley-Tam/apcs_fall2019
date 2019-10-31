//Wesley Tam
//APCS Period 3
//August 29, 2019
//This is a library of math methods and functions

public class Calculate {
	
	public static int square(int number) {
		//A call to square returns the square of the value passed. The method accepts and integer and returns an integer.
		return number * number;
	}
	
	public static int cube(int number) {
		//A call to cube returns the cube of the value passed. The method accepts and integer and returns an integer.
		return number * number * number;
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
	
	public static boolean isDivisibleBy(int numerator, int denominator) {
		//A call to isDivisibleBy determines whether or not one integer is evenly divisible by another. The method accepts two integers and returns a boolean.
		if (denominator == 0) {
			throw new IllegalArgumentException("Cannot divide by zero");
		}
		if (numerator % denominator == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static double absValue(double num) {
		//A call to absValue returns the absolute value of the number passed. The method accepts a double and returns a double.
		if (num >= 0) {
			return num;
		} else {
			return (num * -1);
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
	
	public static double max(double num1, double num2, double num3) {
		//Overload the max method. This one accepts three doubles and returns a double.
		if (num1 > num2 && num1 > num3) {
			return num1;
		} else if (num2 > num3 && num2 > num1) {
			return num2;
		} else {
			return num3;
		}
	}
			
	
	public static int min(int num1, int num2) {
		//A call to min returns the smaller of the values passed. The method accepts two doubles and returns an int.
		if (num1 < num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	public static double round2(double num) {
		//A call to round2 rounds a double a double correctly to 2 decimal places and returns a double.
		num =  (num * 100);
		num = (num + 0.5);
		num = (int)num;	
		num = num/100;
		num = (double)num;
		return num;
	}
	
	public static double exponent(double num, int exp) {
		//A call to exponent raises a value to a positive integer power. The method accepts a double and an integer and returns a double. For the time being, you can assume that the exponent is positive.
		int i = 1;
		double answer = num;
		if (exp < 0) {
			throw new IllegalArgumentException("This code cannot use negative exponents");
		} else if (exp == 0) {
			answer = 1;
		} else if (exp == 0 && num == 0) {
			throw new IllegalArgumentException("Zero to the power of 0 is undefined");
		}
		while (i != exp) {
			answer *= num;
			i++;
		}
		return answer;
	}
	
	public static int factorial(int num) {
		//A call to factorial returns the factorial of the value passed. The method accepts an integer and returns an integer. For the time being, you can assume that the exponent is positive.
		int answer = num;
		if (num < 0) {
			throw new IllegalArgumentException("This code cannot handle negative numbers");
		} else if (num == 0) {
			answer = 0;
		}
		for (int i = 1; i < num; i++) {
			 answer = answer * i;
		}
		return answer;
	}
	
	public static boolean isPrime(int num) {
		//A call to isPrime determines whether or not an integer is prime. The method accepts an integer and returns a boolean. To receive full credit, the method should call another method in your library.
		boolean answer = true;
		for (int i = 2; i < num; i++) {
			boolean result = isDivisibleBy(num, i);
			if (result == true) {
				answer = false;
			}
		}
		return answer;
	}

	public static int gcf(int x, int y) {
		//A call to gcf finds the greatest common factor of two integers. The method accepts two positive integers and returns an integer. To receive full credit, the method should call another method you've already written for this library.
		//Done with the help of Caleb Ng and Sabien
		int max = (int)max(x, y);
		int min = min(x, y);
		int gcf = 1;
		if (isDivisibleBy(max, min) == true) {
			return min;
		} else if (max - min == 1) {
			gcf = 1;
		} else if (isPrime(max) == true || isPrime(min) == true) {
			gcf = 1;
		} else {
			for (int i = min; i > 1; i--) {
				if (isDivisibleBy(max, i) == true && isDivisibleBy(min, i) == true) {
					gcf = i;
				}
			}
		}
		return gcf;
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
	
	public static String quadForm(int a, int b, int c) {
		//A call to quadform uses the coefficients of a quadratic equation in standard form and uses the quadratic formula to approximate the real roots, if any.
		if (discriminant(a, b, c) < 0) {
			return "No real roots";
		}
		double root1 = (-b + (sqrt(discriminant(a, b, c)))) / (2 * a);
		double root2 = (-b - (sqrt(discriminant(a, b, c)))) / (2 * a);
		if (root1 == root2) {
			return "The repeated root is " + round2(root1);
		} else {
			double rootmin = min((int)root1, (int)root2);
			double rootmax = max(root1, root2);
			return "The roots are " + round2(rootmin) + "and " + round2(rootmax);
		}
	}
}