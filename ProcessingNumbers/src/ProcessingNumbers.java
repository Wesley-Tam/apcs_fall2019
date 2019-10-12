//Programmer 1: Wesley Tam
//Programmer 2: Noah Ku
//October 1, 2019
//APCS 3rd Period
//This code will give you the greatest number, smallest number, sum of all the even numbers, and the greatest even number out of a list of numbers.

import java.util.Scanner;

public class ProcessingNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many numbers are there?");
		int numAmount = scanner.nextInt();
		int max = 0;
		int min = 0;
		int evenSum = 0;
		int evenMax = 0;
		int evenCount = 0;
		//You can get first number in loop
		for (int i = 0; i < numAmount; i++) {
			System.out.println("What is your number?");
			int num = scanner.nextInt();
			if (num % 2 == 0) {
				evenCount++;
			}
			if (i == 0) {
				max = num;
				min = num;
			}
			if (num > max) {
				max = num;
			} else if (num < min) {
				min = num;
			}
			if (num % 2 == 0) {
				evenSum += num;
			}
			if (num % 2 == 0 && (num) > evenMax) {
				evenMax = num;
			}
		}
		System.out.println("The largest number was " + max);
		System.out.println("The smallest number was " + min);
		if (evenCount == 0) {
			System.out.println("There were no even numbers inputed");
		} else {
			System.out.println("The sum of the even numbers is " + evenSum);
			System.out.println("The greatest even number was " + evenMax);
		}
		scanner.close();
	}

}