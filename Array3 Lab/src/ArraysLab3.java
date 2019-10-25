//Wesley Tam
//October 25, 2019
//This code will 

import java.util.*;

public class ArraysLab3 {
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4};
		int[] arr2 = {2, 3, 4, 5};
		System.out.println(Arrays.toString(sum(arr1, arr2)));
		
		int[] arr3 = {1, 2, 3, 4};
		System.out.println(Arrays.toString(append(arr3, 5)));
		
		int[] arr4 = {1, 2, 3, 4};
		System.out.println(Arrays., key))
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
		//element at index idx (thus, the returned array has a length of arr.length – 1).  
		//You can assume arr has at least two elements.
		int[] removeArray = new int[arr.length - 1];
		for (int i = 0; i < idx; i++) {
			removeArray[i] = arr[i];
		}
		for (int i = idx + 1; i < removeArray.length; i++) {
			removeArray[i] = arr[i];
		}
		return removeArray;
	}
}
