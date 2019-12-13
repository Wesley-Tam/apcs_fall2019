//Wesley Tam
//October 29, 2019
//This code is a calculator for fractions and returns fractions in mixed number form

package fracCalc;
import java.util.*; 

public class FracCalc {
    public static void main(String[] args) {
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
        int[] ans = new int[3];		//Array of numerator and denominator of fraction (whole, numerator, denominator)
        int wholeans = 0;			//Whole number of return value
        int numans = 0;				//Numerator of return value
    	String[] operators = input.split(" ");
    	
    	if (operators.length != 3) {
    		return "ERROR: Input is in an invalid format";
    	} else if (isNumber(operators[0]) == false || isNumber(operators[2]) == false) {
    		return "ERROR: Operators are not integers and/or fractions";
    	} else if (operators[2].equals("0") && operators[1].equals("/")) {
    		return "ERROR: Cannot divide by 0";
    	}
    	
        int[] fracDesc1 = fracDesc(operators[0]);
        int[] fracDesc2 = fracDesc(operators[2]);
        if (fracDesc1[2] == 0 || fracDesc2[2] == 0) {		//Error handling for denominator 0
        	return "ERROR: Cannot divide by 0";
        }
        if (fracDesc1[0] != 0) {
        	fracDesc1[1] = improp(fracDesc1[0], fracDesc1[1], fracDesc1[2]);	//improper frac1
        }
        if (fracDesc2[0] != 0) {
        	fracDesc2[1] = improp(fracDesc2[0], fracDesc2[1], fracDesc2[2]);	//improper frac2
        }
        if (operators[1].equals("+") || operators[1].equals("-")) {
        	int[] addfrac = addSub(operators[1], fracDesc1[1], fracDesc1[2], fracDesc2[1], fracDesc2[2]);
        	ans[0] = addfrac[0];
        	ans[1] = addfrac[1];
        } else if (operators[1].equals("*") || operators[1].equals("/")) {
        	int[] multifrac = multidiv(operators[1], fracDesc1[1], fracDesc1[2], fracDesc2[1], fracDesc2[2]);
        	ans[0] = multifrac[0];
       		ans[1] = multifrac[1];
        } else {
        	return "ERROR: Input is in an invalid format";
        }
        if (ans[0] == 0) {								//improper fraction, right after add/sub/multi/div math
        	return "0";
        } else {										//Reduces fraction
        	if (ans[0] < 0) {
        		int gcf = gcf(-ans[0], ans[1]);				//Deals with negative number gcf
        		ans[0] /= gcf;
        		ans[1] /= gcf;
        	} else {
        		int gcf = gcf(ans[0], ans[1]);				//gcf to simplify
        		ans[0] /= gcf;
        		ans[1] /= gcf;
        	}
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
    }

    public static String[] wholeNumDenom (String input) {	//Return whole number, numerator, and denominator of an input string 
    	String[] frac1 = input.split("_");
        String whole1 = frac1[0];
        String[] numdenom1 = frac1[1].split("/");
        String num1 = numdenom1[0];
        String denom1 = numdenom1[1];
        String[] answer = {whole1, num1, denom1};
        return answer;
    }
    
    public static int[] fracDesc (String val1) {		//Code that checks if input string is an integer, mixed fraction, or improper fraction (and uses different code for each possible input)
    	int[] fracDesc = new int[3];
    	String[] test1 = val1.split("_");					//tests if there is an underscore
    	if (test1.length == 1) {							//either integer or fraction
    		String[] sectest1 = test1[0].split("/");
    		if (sectest1.length > 1) {							//if fraction
    			val1 = "0_" + val1;
    			String[] desc1 = wholeNumDenom(val1);
    			fracDesc[0] = Integer.parseInt(desc1[0]);
    			fracDesc[1] = Integer.parseInt(desc1[1]);
    			fracDesc[2] = Integer.parseInt(desc1[2]);
    		} else if (sectest1.length == 1) {					//if integer
    			fracDesc[0] = Integer.parseInt(test1[0]);
    			fracDesc[1] = 0;
    			fracDesc[2] = 1;
    		}
    	} else {
    		String[] desc1 = wholeNumDenom(val1);
    		fracDesc[0] = Integer.parseInt(desc1[0]);
    		fracDesc[1] = Integer.parseInt(desc1[1]);
    		fracDesc[2] = Integer.parseInt(desc1[2]);
    	}
    	return fracDesc;
    }
    
    public static int improp (int whole, int num, int denom) {		//Takes in whole number, numerator, denominator, and converts into improper fraction
    	int numer;
    	if (whole > 0) {
    		numer = (whole * denom) + num;
    	} else {
    		numer = (whole * denom) - num;
    	}
    	return numer;
    }
    
    public static int absValue(int num) {
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
		int max = absValue((int)max(denom1, denom2));
		int min = absValue(min(denom1, denom2));
		int gcf = 1;
		if (isDivisibleBy(max, min) == true) {
			return min;
		} else if (max - min == 1) {
			gcf = 1;
		} else if (isPrime(max) == true && isPrime(min) == true) {
			gcf = 1;
		} else {
			for (int i = 2; i < min; i++) {
				if (isDivisibleBy(max, i) == true && isDivisibleBy(min, i) == true) {
					gcf = i;
				}
			}
		}
		return gcf;
	}
    
    public static int[] addSub (String op, int numer1, int denom1, int numer2, int denom2) {	//Method if addition or subtraction
    	int gcf = gcf(denom1, denom2);
    	int lcm = (denom1 / gcf) * denom2;	//common denominator
    	numer1 = numer1 * (lcm / denom1);
    	numer2 = numer2 * (lcm / denom2);
    	int num = 0;
    	if (op.equals("+")) {
    		num = numer1 + numer2;
    	} else {
    		num = numer1 - numer2;
    	}
    	int[] frac = {num, lcm};
    	return frac;
    }
    
    public static int[] multidiv (String op, int numer1, int denom1, int numer2, int denom2) {	//Method if multiplication or division
    	int[] numDenom = new int[2];
    	if (op.contentEquals("*")) {		//if multiply
    		numDenom[0] = numer1 * numer2;
    		numDenom[1] = denom1 * denom2;
    	} else {							//if divide
    		numDenom[0] = numer1 * denom2;
    		numDenom[1] = numer2 * denom1;
    		if (numDenom[1] < 0) {
    			numDenom[0] *= -1;
    			numDenom[1] *= -1;
    		}
    	}
    	return numDenom;
    }
    
    public static boolean isNumber (String input) {		//Error handling
    	boolean ans = true;
    	String[] ssplit = input.split("/");
    	String[] usplit = input.split("_");
    	if (ssplit.length == 1 && usplit.length == 1) {
    		for (int i = 0; i < input.length(); i++) {
    			if (Character.isDigit(input.charAt(i)) != true) {
    				ans = false;
    			}
    		}
    	} else if (ssplit.length > 2 || usplit.length > 2) {
    		ans = false;
    	} else if (ssplit.length == 0 || usplit.length == 0) {
    		ans = false;
    	} else {
    		String[] ussplit2 = ssplit[1].split("_");
    		if (ussplit2.length > 1) {
    			ans = false;
    		} else {
    			String[] ussplit1 = ssplit[0].split("_");
    			for (int i = 0; i < ussplit1.length; i++) {
    				for (int j = 0; j < ussplit1[i].length(); j++) {
    					if (Character.isDigit(ussplit1[i].charAt(j)) == true) {
    						for (int k = 0; k < ssplit[1].length(); k++) {
    							if (Character.isDigit(ssplit[1].charAt(k)) != true) {
    								ans = false;
    							}
    						}
    					} else {
    						ans = false;
    					}
    				}
    			}
    		}
    	}
    	return ans;
    }
}