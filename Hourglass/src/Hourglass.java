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
			for (int space = 1; space <= 1; space++) {
				System.out.print(" ");
			}
			System.out.print("\\");
			int numcolon = -2 * row + 10;
			for (int colon = 1; colon < numcolon; colon++) {
				System.out.print(":");
			}
			System.out.println("/");
		}
	}
}