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
        int whole1 = 0;				//whole number of frac1
        int num1 = 0;				//numerator of frac1
        int denom1 = 0;				//denominator of frac1
        int whole2 = 0;				//whole number of frac2
        int num2 = 0;				//numerator of frac2
        int denom2 = 0;				//denominator of frac2
        int numer1 = 0;				//improper numerator of frac1
        int numer2 = 0;				//improper numerator of frac2
        int[] ans = new int[2];		//Array of numerator and denominator of fraction after add, sub, multi, div
        int wholeans = 0;			//Whole number of return value
        int numans = 0;				//Numerator of return value
        
    	String[] operators = input.split(" ");
    	
        String val1 = operators[0];
        String[] test1 = val1.split("_");					//tests if there is an underscore
        if (test1.length == 1) {							//either integer or fraction
        	String[] sectest1 = test1[0].split("/");
        	if (sectest1.length > 1) {							//if fraction
        		val1 = "0_" + val1;
        		String[] desc1 = wholeNumDenom(val1);
        		whole1 = Integer.parseInt(desc1[0]);
        		num1 = Integer.parseInt(desc1[1]);
        		denom1 = Integer.parseInt(desc1[2]);
        	} else if (sectest1.length == 1) {					//if integer
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
        if (test2.length == 1) {							//either integer or fraction
        	String[] sectest2 = test2[0].split("/");
        	if (sectest2.length > 1) {							//if fraction
        		val2 = "0_" + val2;
        		String[] desc2 = wholeNumDenom(val2);
        		whole2 = Integer.parseInt(desc2[0]);
        		num2 = Integer.parseInt(desc2[1]);
        		denom2 = Integer.parseInt(desc2[2]);
        	} else if (sectest2.length == 1) {					//if integer
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
        } else {
        	numer1 = num1;
        } 
        
        if (whole2 != 0) {
        	numer2 = improp(whole2, num2, denom2);	//improper frac2
        } else {
        	numer2 = num2;
        }
        
        if (op.equals("+")) {
        	int[] addfrac = add(numer1, denom1, numer2, denom2);
        	ans[0] = addfrac[0];
        	ans[1] = addfrac[1];
        } else if (op.equals("-")) {
        	int[] subfrac = sub(numer1, denom1, numer2, denom2);
        	ans[0] = subfrac[0];
        	ans[1] = subfrac[1];
        } else if (op.equals("*")) {
        	int[] multifrac = multi(numer1, denom1, numer2, denom2);
        	ans[0] = multifrac[0];
       		ans[1] = multifrac[1];
        } else {
        	int[] divfrac = divide(numer1, denom1, numer2, denom2);
        	ans[0] = divfrac[0];
        	ans[1] = divfrac[1];
        }
        
        if (ans[0] == 0) {								//improper fraction, right after add/sub/multi/div math
        	return "0";
        } else {										//Reduces fraction (GCF CANNOT ACCOUNT FOR NEGATIVE NUMBERS)
        	int gcf = gcf(ans[0], ans[1]);
        	ans[0] = ans[0] / gcf;
        	ans[1] = ans[1] / gcf;
        }
        
        if (absValue(ans[0]) > absValue(ans[1])) {		//if num > denom
        	wholeans = ans[0] / ans[1];
        	if (ans[0] > ans[1]) {							//positive num
        		numans = ans[0] % ans[1];
        	} else if (ans[0] < ans[1]) {					//negative num
        		numans = ans[0] % ans[1] * -1;
        	}
        	if (numans == 0) {
        		return wholeans + "";
        	} else {
        		return wholeans + "_" + numans + "/" + ans[1];
        	}
        } else if (ans[0] == ans[1]) {					//if num and denom are same number
        	wholeans = wholeans + 1;
        	return wholeans + "";
        } else {										//if num < denom
        	return ans[0] + "/" + ans[1];
        }
        //return whole1 + " " + num1 + " " + denom1 + " " + whole2 + " " + num2 + " " + denom2 + " " + numer1 + " " + numer2 + " " + ans[0] + " " + ans[1] + " " + wholeans + " " + numans; 
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
    
    public static int improp (int whole, int num, int denom) {
    	int numer;
    	if (whole > 0) {
    		numer = (whole * denom) + num;
    	} else {
    		numer = (whole * denom) - num;
    	}
    	return numer;
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
    
    public static int min(int num1, int num2) {
		//A call to min returns the smaller of the values passed. The method accepts two doubles and returns an int.
		if (num1 < num2) {
			return num1;
		} else {
			return num2;
		}
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

	public static int gcf(int denom1, int denom2) {
		//A call to gcf finds the greatest common factor of two integers. The method accepts two positive integers and returns an integer. To receive full credit, the method should call another method you've already written for this library.
		//Done with the help of Caleb Ng and Sabien
		int max = (int)max(denom1, denom2);
		int min = min(denom1, denom2);
		int gcf = 1;
		if (isDivisibleBy(max, min) == true) {
			return min;
		} else if (max - min == 1) {
			gcf = 1;
		} else if (isPrime(max) == true && isPrime(min) == true) {
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
    
    public static int[] add (int numer1, int denom1, int numer2, int denom2) {
    	int gcf = gcf(denom1, denom2);
    	int lcm = (denom1 / gcf) * denom2;	//common denominator
    	numer1 = numer1 * (lcm / denom1);
    	numer2 = numer2 * (lcm / denom2);
    	int num = numer1 + numer2;
    	int[] frac = {num, lcm};
    	return frac;
    }
    
    public static int[] sub (int numer1, int denom1, int numer2, int denom2) {
    	int gcf = gcf(denom1, denom2);
    	int lcm = (denom1 / gcf) * denom2;
    	numer1 = numer1 * (lcm / denom1);
    	numer2 = numer2 * (lcm / denom2);
    	int num = numer1 - numer2;
    	int[] frac = {num, lcm};
    	return frac;
    }
    
    public static int[] multi (int numer1, int denom1, int numer2, int denom2) {
    	int num = numer1 * numer2;
    	int denom = denom1 * denom2;
    	int[] frac = {num, denom};
    	return frac;
    }
    
    public static int[] divide (int numer1, int denom1, int numer2, int denom2) {
    	int num = numer1 * denom2;
    	int denom = denom1 * numer2;
    	if (denom < 0) {
    		num = num * -1;
    		denom = denom * -1;
    	}
    	int[] frac = {num, denom};
    	return frac;
    }
}