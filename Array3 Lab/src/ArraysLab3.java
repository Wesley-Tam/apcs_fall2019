//Wesley Tam
//October 25, 2019
//This code practices different array problems along with the Arrays class

import java.util.*;

public class ArraysLab3 {
	public static void main(String[] args) {
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = sum(a1, a2);
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));
	}
	
	public static int[] sum(int[] arr1, int[] arr2) {
		//Write a method sum that accepts two arrays of integers arr1 and arr2 and returns an 
		//array of integers, in which every element is the sum of the elements at that index 
		//for the arrays arr1 and arr2. You can assume arrays arr1 and arr2 have at least one 
		//element each and are the same length.
		int[] sumArray = new int[arr1.length];
		for (int i = 0; i < sumArray.length; i++) {
			sumArray[i] = arr1[i] + arr2[i];
		}
		return sumArray;
	}
	
	public static int[] append(int[] arr, int num) {
		//Write a method append that accepts an array of integers arr of length n and an integer
		//num, and returns an array of integers of length n+1 that consists of the elements of
		//arr with num appended to the end.  You can assume array arr has at least one element.
		int[] appendArray = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			appendArray[i] = arr[i];
		}
		appendArray[arr.length] = num;
		return appendArray;
	}
	
	public static int[] remove(int[] arr, int idx) {
		//Write a method remove that accepts an array of integers arr and an integer idx and
		//returns an array of integers consisting of all of the elements of arr except for the
		//element at index idx (thus, the returned array has a length of arr.length � 1).  
		//You can assume arr has at least two elements.
		int[] removeArray = new int[arr.length - 1];
		for (int i = 0; i < idx; i++) {
			removeArray[i] = arr[i];
		}
		for (int i = idx + 1; i <= removeArray.length; i++) {
			removeArray[i - 1] = arr[i];
		}
		return removeArray;
	}
	
	public static int sumEven(int[] arr) {
		//Write a method sumEven that accepts an array of integers arr and returns an integer 
		//containing the sum of the elements at the even indices of arr.  (That means elements
		//at indices 0,2,4,6,8.) You can assume arr has at least one element.
		int sum = 0;
		if (arr.length % 2 == 0) {
			for (int i = 0; i < arr.length / 2; i++) {
				sum += arr[2 * i];
			}
		} else {
			for (int i = 0; i < arr.length / 2 + 1; i++) {
				sum += arr[2 * i];
			}
		}
		return sum;
	}
	
	public static void rotateRight(int[] arr) {
		//Write a method rotateRight that accepts an array of integers arr and does not return 
		//a value. The rotateRight method moves each element of arr one index to the right 
		//(element 0 goes to element 1, element 1 goes to element 2, �, element n-1 goes to 
		//element 0). You can assume arr has at least one element.
		int[] rightArray = new int[arr.length];
		int temp = arr[arr.length - 1];
		for (int i = 0; i < arr.length - 1; i++) {
			rightArray[i + 1] = arr[i];
		}
		rightArray[0] = temp;
	}
}