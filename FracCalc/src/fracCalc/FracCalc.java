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
        int whole1 = 0;		//whole number of frac1
        int num1 = 0;		//numerator of frac1
        int denom1 = 0;		//denominator of frac1
        int whole2 = 0;		//whole number of frac2
        int num2 = 0;		//numerator of frac2
        int denom2 = 0;		//denominator of frac2
        int numer1 = 0;		//improper numerator of frac1
        int numer2 = 0;		//improper numerator of frac2
        
    	String[] operators = input.split(" ");
    	
        String val1 = operators[0];
        String[] test1 = val1.split("_");	//tests if there is an underscore
        if (test1.length == 1) {	//either integer or fraction
        	String[] sectest1 = test1[0].split("/");
        	if (sectest1.length > 1) {	//fraction
        		val1 = "0_" + val1;
        		String[] desc1 = wholeNumDenom(val1);
        		whole1 = Integer.parseInt(desc1[0]);
        		num1 = Integer.parseInt(desc1[1]);
        		denom1 = Integer.parseInt(desc1[2]);
        	} else if (sectest1.length == 1) {	//integer
        		whole1 = Integer.parseInt(test1[0]);
        		num1 = 0;
        		denom1 = 1;
        	}
        } else {
        	String[] desc1 = wholeNumDenom(val1);
        	whole1 = Integer.parseInt(desc1[0]);
        	num1 = Integer.parseInt(desc1[1]);
        	denom1 = Integer.parseInt(desc1[2]);
        }
        
        String op = operators[1];
        
        String val2 = operators[2];
        String[] test2 = val2.split("_");
        if (test2.length == 1) {	//either integer or fraction
        	String[] sectest2 = test2[0].split("/");
        	if (sectest2.length > 1) {	//fraction
        		val2 = "0_" + val2;
        		String[] desc2 = wholeNumDenom(val2);
        		whole2 = Integer.parseInt(desc2[0]);
        		num2 = Integer.parseInt(desc2[1]);
        		denom2 = Integer.parseInt(desc2[2]);
        	} else if (sectest2.length == 1) {	//integer
        		whole2 = Integer.parseInt(test2[0]);
        		num2 = 0;
        		denom2 = 1;
        	}
        } else {
        	String[] desc2 = wholeNumDenom(val2);
        	whole2 = Integer.parseInt(desc2[0]);
        	num2 = Integer.parseInt(desc2[1]);
        	denom2 = Integer.parseInt(desc2[2]);
        }
        
        if (whole1 != 0) {
        	numer1 = improp(whole1, num1, denom1);	//improper frac1
        } else if (whole2 != 0) {
        	numer2 = improp(whole2, num2, denom2);	//improper frac2
        }
        
        if (op.equals("+")) {
        	//return add(numer1, denom1, numer2, denom2);
        } else if (op.contentEquals("-")) {
        	//return sub(numer1, denom1, numer2, denom2);
        }
        
        String desc = "whole:" + whole2 + " numerator:" + num2 + " denominator:" + denom2;
        return desc;
    }

    public static String[] wholeNumDenom (String input) {
    	String[] frac1 = input.split("_");
        String whole1 = frac1[0];
        String[] numdenom1 = frac1[1].split("/");
        String num1 = numdenom1[0];
        String denom1 = numdenom1[1];
        String[] answer = {whole1, num1, denom1};
        return answer;
    }
    
    public static int improp (int whole1, int num1, int denom1) {
    	int numer1 = whole1 * denom1 + num1;
    	return numer1;
    }
    
    public static int comdenom (int denom1, int denom2) {
    	int max = (int)max(denom1, denom2);
		int min = min(denom1, denom2);
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
    
    public static String add (int numer1, int denom1, int numer2, int denom2) {
    	int ansnum = numer1 + numer2;
    	return (ansnum + "/" + denom1);
    }
    
    public static String sub (int numer1, int denom1, int numer2, int denom2) {
    	int ansnum = numer1 - numer2;
    	return (ansnum + "/" + denom1);
    }
    
    public static String times (int numer1, int denom1, int numer2, int denom2) {
    	
    }
}