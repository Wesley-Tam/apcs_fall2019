//Wesley Tam
//APCS Period 3
//August 27, 2019
//This class draws Pikachu and uses static methods to simplify the program

public class Pikachu {
	
	public static void main (String[] args) {
		pikachuPrint();
		drawBox();
		System.out.println();
		drawBox();
		System.out.println();
		drawBox();
		System.out.println();
	}
	public static void pikachuPrint() {
		System.out.println("Hello");
		System.out.println("Pikachu Goes Here");
		System.out.println("Pikachu welcomes you to the world of Pokemon");
		System.out.println("\t\t\t (\\__/)");
		System.out.println("\t\t\t (o^.^)");
		System.out.println("\t\t\tz(_(\")(\")");
		
	}
	public static void plusMinusPlus() {
		System.out.println("+-------+");
	}
	public static void twoVerticalLines() {
		System.out.println("|       |");
	}
	public static void drawBox() {
		plusMinusPlus();
		twoVerticalLines();
		twoVerticalLines();
		plusMinusPlus();

	}
}