//Wesley Tam
//APCS period 3
//August 26, 2019
//This is the scanner client that takes in the user's data values and prints out the description.

import java.util.Scanner;

public class QuadraticClient {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to the quadratic describer!\nPlease input values for a, b, and c below!");
		System.out.print("a: ");
		double a = userInput.nextDouble();
		System.out.print("b: ");
		double b = userInput.nextDouble();
		System.out.print("c: ");
		double c = userInput.nextDouble();
		System.out.println();
		System.out.println(Quadratic.quadrDescriber(a, b, c));
		System.out.println();
		System.out.println("Do you want to go again? Type \"quit\" to end, type anything else to continue.");
		if ((userInput.nextLine()).toLowerCase() == "quit") {
			
		}
	}
}
