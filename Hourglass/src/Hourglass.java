//Wesley Tam
//October 8, 2019
//APCS Period 3
//This code prints out an hourglass figure using nested loops.

public class Hourglass {
	public static void main(String[] args) {
		int size = 11;
		firstLastLine(size);
		topHalf(size);
		middle(size);
		bottomHalf(size);
		firstLastLine(size);
	}
	
	public static void space(int x) {	//reduce number of print/printlns
		System.out.print(" ");
	}
	
	public static void colon(int y) {	//reduce number of print/printlns
		System.out.print(":");
	}
	
	public static void firstLastLine(int size) {
		System.out.print("|");
		for (int i = 0; i < size; i++) {
			System.out.print("\"");
		}
		System.out.println("|");
	}
	
	public static void topHalf(int size) {
		for (int row = 1; row <= (size / 2 - 1); row++) {
			for (int space = 1; space <= row; space++) {
				space(1);
			}
			System.out.print("\\");
			for (int colon = 1; colon <= (-2 * row + size); colon++) {
				colon(1);
			}
		System.out.println("/");
		}
	}
	
	public static void middle(int size) {
		for (int i = 0; i <= (size / 2 - 1); i++) {
			space(1);
		}
		 if (size % 2 == 0) {
			 System.out.println("||");
		 } else {
			 System.out.println("\\:/");
		 }
	}
	
	public static void bottomHalf(int size) {
		for (int row2 = (size / 2 + 1); row2 <= size; row2++) {
			for (int space2 = row2; space2 < size; space2++) {
				space(1);
			}
			System.out.print("/");
			for (int colon2 = 0; colon2 < (2 * row2 - size); colon2++) {
				colon(1);
			}
			System.out.println("\\");
		}
	}
}