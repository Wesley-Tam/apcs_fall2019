//Wesley Tam
//October 29, 2019
//This code is a calculator for fractions and returns fractions in mixed number form

package fracCalc;
import java.util.*;

public class FracCalc {
    public static void main(String[] args) {
    	// TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	boolean done = false;
		while (done != true) {
			System.out.println("What integers and/or fractions do you want to add/subtract/multiply/divide?");
			String equation = userInput.nextLine();
			System.out.println(produceAnswer(equation));
			System.out.println("-------");
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			String end = userInput.nextLine();
			System.out.println();
			if (end.toLowerCase().equals("quit")) {
				done = true;
			}
		}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"    
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
    public static String produceAnswer(String input) { 
        // TODO: Implement this function to produce the solution to the input
        String[] operators = input.split(" ");
        String val1 = operators[0];
        String op = operators[1];
        String val2 = operators[2];
        return val2;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}