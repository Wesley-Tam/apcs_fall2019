//Wesley Tam
//October 8, 2019
//APCS Period 3
//This code prints out an hourglass figure using nested loops.

public class Hourglass {
	public static void main(String[] args) {
		int size = 10;
		System.out.print("|");
		for (int i = 0; i < size; i++) {
			System.out.print("\"");
		}
		System.out.println("|");
		for (int row = 1; row <= (size / 2 - 1); row++) {
			for (int space = 1; space <= row; space++) {
				System.out.print(" ");
			}
			System.out.print("\\");
			int numColon = -2 * row + size;
			for (int colon = 1; colon <= numColon; colon++) {
				System.out.print(":");
			}
			System.out.println("/");
		}
		for (int i = 0; i <= (size / 2 - 1); i++) {
			System.out.print(" ");
		}
		System.out.println("||");
		for (int row2 = size / 2 + 1; row2 <= size; row2++) {
			for (int space2 = )
		}
	}
}