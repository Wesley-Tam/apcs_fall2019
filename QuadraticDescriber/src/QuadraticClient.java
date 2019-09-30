//Wesley Tam
//APCS period 3
//August 26, 2019
//This is the scanner client that takes in the user's data values and prints out the description.

import java.util.Scanner;

public class QuadraticClient {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println();
		System.out.println("Welcome to the Quadratic Describer\nProvide values for coefficients a, b, and c");
		boolean done = false;
		do {
			System.out.print("a: ");
			double a = userInput.nextDouble();
			System.out.print("b: ");
			double b = userInput.nextDouble();
			System.out.print("c: ");
			double c = userInput.nextDouble();
			System.out.println();
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println();
			System.out.println("Do you want to keep going? (Type \"quit\" to end");
			if ((userInput.nextLine()).toLowerCase() == "quit") {
				done = true;
			} else {
				done = false;
			}
		while (done = false);
		}
	}
}
