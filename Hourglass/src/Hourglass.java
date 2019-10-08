//Wesley Tam
//October 8, 2019
//APCS Period 3
//This code prints out an hourglass figure using nested loops.

public class Hourglass {
	public static void main(String[] args) {
		System.out.print("|");
		for (int i = 0; i < 10; i++) {
			System.out.print("\"");
		}
		System.out.println("|");
		for (int row = 1; row <= 4; row++) {
			for (int space = 1; space <= row; space++) {
				System.out.print(" ");
			}
			System.out.print("\\");
			int numColon = -2 * row + 10;
			for (int colon = 0; colon < numColon; colon++) {
				System.out.print(":");
			}
			System.out.println("/");
		}
		System.out.println("     ||");
		for (int row2 = 4; row2 >= 1; row2--) {
			for (int space2 = row2; space2 >= 1; space2--) {
				System.out.print(" ");
			}
			System.out.print("\\");;
			int numColon2 = 2 * row2 - 10;
			for (int colon2 = numColon2; colon2 > 0; colon2--) {
				System.out.print(":");
			}
		}
	}
}