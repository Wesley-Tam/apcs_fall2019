//Wesley Tam
//October 22, 2019
//Mini Array Lab

import java.util.*;

public class LotsOfCopies {
	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		changeMe(num, strMain, arrMain);
		System.out.println("Number: " + num);
		System.out.println("String: " + strMain);
		System.out.println("Array: " + Arrays.toString(arrMain));
	}
	
	public static void changeMe(int x, String str, int[] arr) {
		x = 8;
		str += "Hello";
		arr[3]++;
	}
}