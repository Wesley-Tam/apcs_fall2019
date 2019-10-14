//Wesley Tam
//October 8, 2019
//APCS Period 3
//This code prints out an hourglass figure using nested loops.

//Your code should print the basic 11 line hourglass. 
//It should use nested loops and use less than 11 println or prints.  (I can do it with one print.)
//Export the .java file and submit it.
	//make it print different sizes
	//make it repeat for different inputs
	//deal with any size -- even or odd
	//make a new method to replace tophalf and bottomhalf

public class Hourglass {
	public static void main(String[] args) {
		int size = 101;
		firstLastLine(size);
		topHalf(size);
		middle(size);
		bottomHalf(size);
		firstLastLine(size);
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
				System.out.print(" ");
			}
			System.out.print("\\");
			int numColon = -2 * row + size;
			for (int colon = 1; colon <= numColon; colon++) {
				System.out.print(":");
			}
		System.out.println("/");
		}
	}
	
	public static void middle(int size) {
		for (int i = 0; i <= (size / 2 - 1); i++) {
			System.out.print(" ");
		}
		 if (size % 2 == 0) {
			 System.out.println("||");
		 } else {
			 System.out.println("\\:/");
		 }
	}
	
	public static void bottomHalf(int size) {
		for (int row2 = size / 2 + 1; row2 <= size; row2++) {
			for (int space2 = row2; space2 < size; space2++) {
				System.out.print(" ");
			}
			System.out.print("/");
			int numColon2 = 2 * row2 - size;
			for (int colon2 = 0; colon2 < numColon2; colon2++) {
				System.out.print(":");
			}
			System.out.println("\\");
		}
	}
}