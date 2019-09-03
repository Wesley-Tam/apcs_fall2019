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
		return (number * secnum)/2;
	}
}